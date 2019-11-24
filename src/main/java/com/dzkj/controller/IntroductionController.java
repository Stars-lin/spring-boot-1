package com.dzkj.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dzkj.pojo.Commodity;
import com.dzkj.pojo.Foot;
import com.dzkj.pojo.Productimage;
import com.dzkj.pojo.Shopcart;
import com.dzkj.pojo.User;
import com.dzkj.service.IFootService;
import com.dzkj.service.imp.CommodityService;
import com.dzkj.service.imp.ProductImageService;
import com.dzkj.service.imp.ShopcarService;

@Controller
public class IntroductionController {
    
	@Autowired
	CommodityService cService;
	@Autowired
	ProductImageService pService;
	@Autowired
	ShopcarService shopcarService;
	@Autowired
	IFootService footService;
	
	@Autowired
	HttpServletRequest request;
	
	@RequestMapping("/lookshop")
	public String lookshop(@RequestParam("s_id")Integer s_id,Map<String, Object> map) {
		User user = (User) request.getSession().getAttribute("user");
		//商品详细信息
		Commodity commodity = cService.findById(s_id);
		map.put("shop", commodity);
		//添加足迹
		Foot foot = new Foot();
		foot.setCommodity(commodity);
		foot.setU_id(user.getU_id());
		if(footService.findone(foot) == null) {
			footService.add(foot);
		}
		//放大镜图片
		Productimage pImage = pService.findByS_id(commodity.getS_id());
		map.put("images", pImage);
		//侧边同类推荐
		List<Commodity> kinds = cService.findByThreeId(commodity.getS_three_id());
		for (int i = 0; i < kinds.size(); i++) {
			if (kinds.get(i).getS_id()==commodity.getS_id()) {
				kinds.remove(i);
			}
		}
		map.put("kinds", kinds);
		
		return "home/introduction";
	}
	
	@RequestMapping("/addcar")
	@ResponseBody
	public boolean addcar(Integer s_id,Integer number) {
		User user = (User) request.getSession().getAttribute("user");
		Commodity commodity = cService.findById(s_id);
		//储存需要添加购物车的值
		Shopcart shopcart = new Shopcart();
		shopcart.setU_id(user.getU_id());
		shopcart.setCommodity(commodity);
		
		//判断购物车是否已存在此商品
		if (shopcarService.findone(shopcart) == null) {
			shopcart.setSc_number(number);
			shopcart.setSc_price(commodity.getS_price()*number);
			return shopcarService.add(shopcart);
		}else {
			Shopcart shopcart2 = shopcarService.findone(shopcart);
			shopcart2.setSc_number(shopcart2.getSc_number()+number);
			shopcart2.setSc_price(shopcart2.getSc_number()*shopcart2.getCommodity().getS_price());
			return shopcarService.upd(shopcart2);
		}
		
	}
	
}
