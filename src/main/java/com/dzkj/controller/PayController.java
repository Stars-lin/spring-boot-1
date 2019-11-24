package com.dzkj.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dzkj.config.OrderIdUtil;
import com.dzkj.pojo.Address;
import com.dzkj.pojo.Commodity;
import com.dzkj.pojo.Orderabout;
import com.dzkj.pojo.OrderAll;
import com.dzkj.pojo.Ordertotal;
import com.dzkj.pojo.Shopcart;
import com.dzkj.pojo.User;
import com.dzkj.service.IAddressService;
import com.dzkj.service.ICommodityService;
import com.dzkj.service.IOrderaboutService;
import com.dzkj.service.IOrdertotalService;
import com.dzkj.service.IShopcarService;


@Controller
public class PayController {
	
	@Autowired
	IAddressService addressservice;
   
	@Autowired
	IShopcarService shopcarService;
	
	@Autowired
	IOrderaboutService orderaboutService;
	
	@Autowired
	IOrdertotalService ordertotalService;
	
	@Autowired
	ICommodityService commodityService;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	OrderIdUtil orderIdUtil;
	
	@RequestMapping("/paypage")
	public String pay(Integer[] sc_id,Map<String , Object> map) {
		User user = (User) request.getSession().getAttribute("user");
		System.out.println("支付界面");
		Address address = new Address();
		address.setU_id(user.getU_id());
		List<Address> useraddress =addressservice.checkByUserid(address);
		if(useraddress.size() > 0) {	//判断地址是否为空
			map.put("add", useraddress);
		}else {
			map.put("add", "请先添加地址");
		}
		
		
		List<Orderabout> oAbouts = new ArrayList<Orderabout>();
		 //创建订单编号
		String o_bh = null;
		try {
			o_bh = new String(orderIdUtil.getOrderId().getBytes(),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		int t_price = 0;
		//创建订单详情对象
		for(int i=0;i<sc_id.length;i++){
				int id = sc_id[i];
				//将选中购物车id跟所有购物车id进行比较
					//获取选中的购物车对象
					Shopcart shopcart = new Shopcart();
					shopcart.setId(id);
					shopcart = shopcarService.findbyid(shopcart);
					Orderabout orderAbout = new Orderabout(
							o_bh,
							shopcart.getCommodity(),
							shopcart.getSc_number(),
							shopcart.getSc_price()
							);
					oAbouts.add(orderAbout);
					//添加购物车信息值商品详情表
					if (orderaboutService.add(orderAbout)) {
						Commodity commodity = shopcart.getCommodity();
						commodity.setS_repertory(commodity.getS_repertory()-shopcart.getSc_number());
						commodity.setS_sales(commodity.getS_sales()+shopcart.getSc_number());
						commodityService.updbyid(commodity);
					}
					t_price += shopcart.getSc_price();
					//删除购物车数据
					shopcarService.delone(id);
		}
		//获取当前时间
		String t_time = orderIdUtil.getdate();
		//获取用户
		Ordertotal orderTotal = new Ordertotal(
				user.getU_id(),
				o_bh,
				t_price,
				t_time
				);
		orderTotal.setT_state(0);
		ordertotalService.add(orderTotal);
		//订单模型
		OrderAll orderAll = new OrderAll(orderTotal,oAbouts);
		map.put("orderall", orderAll);
		
		return "home/pay";
	}
	@RequestMapping("payone")
	public String payone(Integer s_id,Integer number,Map<String, Object> map) {
		User user = (User) request.getSession().getAttribute("user");
		Address address = new Address();
		address.setU_id(user.getU_id());
		List<Address> useraddress =addressservice.checkByUserid(address);
		if(useraddress.size() > 0) {	//判断地址是否为空
			map.put("add", useraddress);
		}else {
			map.put("add", "请先添加地址");
		}
		Commodity commodity = commodityService.findById(s_id);
		//创建订单编号
				String o_bh = null;
				try {
					o_bh = new String(orderIdUtil.getOrderId().getBytes(),"utf-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
		Orderabout orderabout = new Orderabout(o_bh, commodity, number, number*commodity.getS_price());
		//添加购物车信息值商品详情表
		if (orderaboutService.add(orderabout)) {
			commodity.setS_repertory(commodity.getS_repertory()-number);
			commodity.setS_sales(commodity.getS_sales()+number);
			commodityService.updbyid(commodity);
		}
		List<Orderabout> orderabouts = new ArrayList<Orderabout>();
		orderabouts.add(orderabout);
		//获取当前时间
				String t_time = orderIdUtil.getdate();
				//获取用户
				Ordertotal orderTotal = new Ordertotal(
						user.getU_id(),
						o_bh,
						commodity.getS_price()*number,
						t_time
						);
				orderTotal.setT_state(0);
				ordertotalService.add(orderTotal);
				//订单模型
				OrderAll orderAll = new OrderAll(orderTotal,orderabouts);
				map.put("orderall", orderAll);
		return "home/pay";
	}
//	
//	@RequestMapping("/text")
//	public void text(Integer[] sc_id) {
//		
//		
//		
////		String[] shopcarts = request.getParameterValues("sc_id");
////		Shopcart[] shopcarts2 = new Shopcart[shopcarts.length];
////		for (String string : shopcarts) {
////			System.out.println(shopcarts.toString());
////		}
//	}
//	
	@RequestMapping("/payment")
	public String  payment(Integer a_id,String o_bh) {
		User user = (User) request.getSession().getAttribute("user");
		Ordertotal ordertotal = ordertotalService.findbyo_bh(o_bh);
		System.out.println(ordertotal.getO_bh());
		Address address = addressservice.findbyid(a_id);
		request.getSession().setAttribute("out_trade_no", ordertotal.getO_bh());
		request.getSession().setAttribute("total_amount", ordertotal.getT_price());
		request.getSession().setAttribute("subject", "在线购物商城");
		request.getSession().setAttribute("address", address);
		return "forward:pay";
	}
	
	
//	
//	/**
//	 * 查询地址是否存在
//	 * @return
//	 */
//	@RequestMapping("/getadress")
//	@ResponseBody
//	public Integer getAddress() {
//		User user = (User) request.getSession().getAttribute("user");
//		List<Address> useraddress =indexservice.checkByUserid(user.getUser_id());
//		if(useraddress.size() > 0) {
//			return 1;
//		}else {
//			return -1;
//		}
//	}
//	
//	@RequestMapping("/addadress")
//	@ResponseBody
//	public Integer addAdress(Address address) {
//		int add;
//		User user = (User) request.getSession().getAttribute("user");
//		address.setUserid(user.getUser_id());
//		List<Address> addresses = indexservice.checkByUserid(user.getUser_id());
//		if (addresses.size() == 0 ) {
//			address.setDef(1);
//			add = indexservice.add(address);
//		}else {
//			address.setDef(0);
//			add = indexservice.add(address);
//		}
//		if (add > 0) {
//			return 1;
//		}else {
//			return -1;
//		}
//	}
}
