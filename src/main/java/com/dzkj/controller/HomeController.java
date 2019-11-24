package com.dzkj.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dzkj.pojo.Commodity;
import com.dzkj.pojo.STopOne;
import com.dzkj.service.ICommodityService;
import com.dzkj.service.ISTopOneService;

@RequestMapping("/home")
@Controller
public class HomeController {
      @Autowired
      ICommodityService commodityService;
      
      @Autowired
      ISTopOneService oneservice;
      
      Random rd = new Random();
      
      @RequestMapping("/home")
      public String home(Map<String, Object> map) {
    	  
    	//三级联动导航条
    	  List<STopOne> sOnes = oneservice.findAll();
    	  map.put("sones", sOnes);
    	  
    	//第一层商品显示
    	  List<Commodity> commodities1 = commodityService.findByTwo(1);
    	  List<Commodity> arr_one = new ArrayList<Commodity>();
    	  arr_one.add(commodities1.get(rd.nextInt(commodities1.size()-1)));
    	  while (true) {
			Commodity commodity = commodities1.get(rd.nextInt(commodities1.size()-1));
			for (int i = 0; i < arr_one.size(); i++) {
				if (commodity.getS_id() == arr_one.get(i).getS_id()) {
					break;
				}
				if (i == arr_one.size()-1) {
					arr_one.add(commodity);
				}
			}
			if (arr_one.size()>=6) {
				break;
			  }
		}
    	  map.put("arr_one", arr_one);
    	//第二层商品显示
    	  List<Commodity> commodities2 = commodityService.findByTwo(4);
    	  List<Commodity> arr_two = new ArrayList<Commodity>();
    	  arr_two.add(commodities2.get(rd.nextInt(commodities2.size()-1)));
    	  while (true) {
			Commodity commodity = commodities2.get(rd.nextInt(commodities2.size()-1));
			for (int i = 0; i < arr_two.size(); i++) {
				if (commodity.getS_id() == arr_two.get(i).getS_id()) {
					break;
				}
				if (i == arr_two.size()-1) {
					arr_two.add(commodity);
				}
			}
			if (arr_two.size()>=6) {
				break;
			  }
		}
    	  map.put("arr_two", arr_two);
    	//第二层商品显示
    	  List<Commodity> commodities3 = commodityService.findByTwo(3);
    	  List<Commodity> arr_three = new ArrayList<Commodity>();
    	  arr_three.add(commodities3.get(rd.nextInt(commodities3.size()-1)));
    	  while (true) {
			Commodity commodity = commodities3.get(rd.nextInt(commodities3.size()-1));
			for (int i = 0; i < arr_three.size(); i++) {
				if (commodity.getS_id() == arr_three.get(i).getS_id()) {
					break;
				}
				if (i == arr_three.size()-1) {
					arr_three.add(commodity);
				}
			}
			 if (arr_three.size()>=6) {
					break;
				  }
		}
    	  map.put("arr_three", arr_three);
    	  //轮播图
    	  List<Commodity> commodities = commodityService.findbysale();
    	  Commodity banner1 = commodities.get(1);
    	  Commodity banner2 = commodities.get(2);
    	  Commodity banner3 = commodities.get(3);
    	  Commodity banner4 = commodities.get(4);
    	  map.put("banner1", banner1);
    	  map.put("banner2", banner2);
    	  map.put("banner3", banner3);
    	  map.put("banner4", banner4);
    	  return "home/home";
      }
      
      @RequestMapping("/register")
      public String reString() {
    	  return "home/register";
      }
      
      @RequestMapping("/login")
      public String login() {
    	  return "home/login";
      }
      
}
