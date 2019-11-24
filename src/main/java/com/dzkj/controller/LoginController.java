package com.dzkj.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dzkj.pojo.User;
import com.dzkj.service.IUserService;

@Controller
public class LoginController {
   
	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpServletResponse response;
	
	@Autowired
	IUserService user_service;
	
	@RequestMapping("/CheckCooking")
	@ResponseBody
	public Map<String, Object> checkCooking() {
		Map<String, Object> map = new HashMap<>();
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if("userName".equals(cookie.getName()) && !"".equals(cookie.getValue())) {
				map.put("user", cookie.getValue());
			}
			if("userPassword".equals(cookie.getName()) && !"".equals(cookie.getValue())) {
				map.put("password", cookie.getValue());
			}
			if("is_remember".equals(cookie.getName()) && !"".equals(cookie.getValue())) {
				map.put("is_remember", cookie.getValue());
			}
		}
		return map;
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public boolean login(String user,String password,Integer is_check) {
		User u = user_service.findoneUser(user, password);
		if(u != null) {
			request.getSession().setAttribute("user", u);
//			判断是否勾选记住密码
			Cookie cookie = null;
			if(is_check == 1) {
				cookie = new Cookie("userName", user);
				response.addCookie(cookie);
				cookie = new Cookie("userPassword",password);
				response.addCookie(cookie);
				cookie = new Cookie("is_remember",is_check.toString());
				response.addCookie(cookie);
			}else {
				cookie = new Cookie("userName", null);
				response.addCookie(cookie);
				cookie = new Cookie("userPassword",null);
				response.addCookie(cookie);
				cookie = new Cookie("is_remember",null);
				response.addCookie(cookie);
			}
			return true;
		}
		return false;
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().removeAttribute("user");
		return "home/login";
	}
}
