package com.dzkj.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dzkj.pojo.Collection;
import com.dzkj.pojo.Shopcart;
import com.dzkj.pojo.User;
import com.dzkj.service.ICollectionService;
import com.dzkj.service.IShopcarService;

@Controller
public class ShopcarController {
   
	@Autowired
	IShopcarService shopcarService;
	@Autowired
	ICollectionService collectionService;
	
	@Autowired
	HttpServletRequest request;
	
	//显示购物车所有商品
	@RequestMapping("/shopcar")
	public String shopcar(Map<String, Object> map) {
		//获取用户id
		User user = (User) request.getSession().getAttribute("user");
		Integer u_id = user.getU_id();
		//获取已登录用户的值
		List<Shopcart> shopcarts = shopcarService.findall(u_id);
		map.put("shopcarts", shopcarts);
		return "home/shopcart";
	}
	
	//异步购物车购买数量变化
	@RequestMapping("/updnumber")
	@ResponseBody
	public boolean updnumber(@RequestParam("sc_id") Integer sc_id,
			@RequestParam("sc_number") Integer sc_number,
			@RequestParam("sc_price") Integer sc_price) {
		Shopcart shopcart = new Shopcart();
		shopcart.setId(sc_id);
		shopcart.setSc_number(sc_number);
		shopcart.setSc_price(sc_price);
		return shopcarService.upd(shopcart);
	}
	
	//删除单条
	@RequestMapping("/delone")
	@ResponseBody
	public boolean delone(Integer sc_id) {
		return shopcarService.delone(sc_id);
	}
	
	//添加单条收藏夹
	@RequestMapping("/addcollection")
	@ResponseBody
	public boolean addcollection(Integer sc_id) {
		User user = (User) request.getSession().getAttribute("user");
		Shopcart shopcart = new Shopcart();
		shopcart.setId(sc_id);
		shopcart = shopcarService.findbyid(shopcart);
		Collection collection = new Collection();
		collection.setCommodity(shopcart.getCommodity());
		collection.setU_id(user.getU_id());
		return collectionService.add(collection);
	}
	
	//添加单条收藏夹
		@RequestMapping("/addarr")
		@ResponseBody
		public boolean addcollection(@RequestParam("items")List<Integer> items) {
			User user = (User) request.getSession().getAttribute("user");
			for (int i = 0; i < items.size(); i++) {
				Shopcart shopcart = new Shopcart();
				shopcart.setId(items.get(i));
				shopcart = shopcarService.findbyid(shopcart);
				Collection collection = new Collection();
				collection.setCommodity(shopcart.getCommodity());
				collection.setU_id(user.getU_id());
				if (!collectionService.add(collection)) {
					return false;
				}
			}
			return true;
		}
	
	//批量删除
	@RequestMapping("/delarr")
	public String delarr(@RequestParam("items")List<Integer> items) {
		shopcarService.delarr(items);
		return "forward:shopcar";
	}
}
