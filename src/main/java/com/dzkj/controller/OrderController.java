package com.dzkj.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dzkj.pojo.Address;
import com.dzkj.pojo.OrderAll;
import com.dzkj.pojo.Orderabout;
import com.dzkj.pojo.Ordertotal;
import com.dzkj.pojo.User;
import com.dzkj.service.IAddressService;
import com.dzkj.service.IOrderaboutService;
import com.dzkj.service.IOrdertotalService;

@Controller
public class OrderController {
	
	@Autowired
	IOrdertotalService ordertotalService;
	@Autowired
	IAddressService addressService;
	
	@Autowired
	IOrderaboutService orderaboutService;
	
	@Autowired
	HttpServletRequest request;

	@RequestMapping("/order")
	public String order(Map<String, Object> map) {
		User user = (User) request.getSession().getAttribute("user");
		List<OrderAll> orderAlls = new ArrayList<OrderAll>();
		List<Ordertotal> ordertotals = ordertotalService.findbyu_id(user.getU_id());
		for (Ordertotal ordertotal : ordertotals) {
			List<Orderabout> orderabouts = orderaboutService.findbyo_bh(ordertotal.getO_bh());
			OrderAll orderAll = new OrderAll(ordertotal, orderabouts);
			orderAlls.add(orderAll);
		}
		map.put("arr", orderAlls);
		return "person/order";
	}
	
	@RequestMapping("/orderinfo")
	public String orderinfo(String o_bh,Map<String, Object> map) {
		Ordertotal ordertotal = ordertotalService.findbyo_bh(o_bh);
		List<Orderabout> orderabout = orderaboutService.findbyo_bh(o_bh);
		OrderAll orderAll = new OrderAll(ordertotal, orderabout);
		map.put("orderall", orderAll);
		return "person/orderinfo";
	}
	
	@RequestMapping("delorder")
	@ResponseBody
	public boolean delorder(String o_bh,Map<String, Object> map) {
		Orderabout orderabout = new Orderabout();
		orderabout.setO_bh(o_bh);
		Ordertotal ordertotal = new Ordertotal();
		ordertotal.setO_bh(o_bh);
		orderaboutService.del(orderabout);
		return ordertotalService.del(ordertotal);
	}
	
	@RequestMapping("/payorder")
	public String payorder(String o_bh,Map<String, Object> map) {
		User user = (User) request.getSession().getAttribute("user");
		System.out.println("支付界面");
		Address address = new Address();
		address.setU_id(user.getU_id());
		List<Address> useraddress =addressService.checkByUserid(address);
		if(useraddress.size() > 0) {	//判断地址是否为空
			map.put("add", useraddress);
		}else {
			map.put("add", "请先添加地址");
		}
		
		Ordertotal ordertotal = ordertotalService.findbyo_bh(o_bh);
		List<Orderabout> orderabout = orderaboutService.findbyo_bh(o_bh);
		OrderAll orderAll = new OrderAll(ordertotal, orderabout);
		map.put("orderall", orderAll);
		return "home/pay";
	}
}
