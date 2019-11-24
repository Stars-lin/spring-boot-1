package com.dzkj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.dzkj.pojo.User;
import com.dzkj.service.IUserService;
import com.dzkj.util.SendEmailCode;
import com.dzkj.util.SendPhoneMessage;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@Autowired
	IUserService user_service;
	
	
	@RequestMapping("/addUserByEmail")
	@ResponseBody
	public boolean addUserByEmail(String email,String password) {
		User user = new User();
		user.setU_email(email);
		user.setU_pwd(password);
		user.setU_url("/images/getAvatar.do.jpg");
		user.setU_nickname(email);
		return user_service.addUser(user);
	}
	
	@RequestMapping("/addUserByPhone")
	@ResponseBody
	public boolean addUserByPhone(String u_phone,String password) {
		User user = new User();
		user.setU_phone(u_phone);
		user.setU_pwd(password);
		user.setU_nickname(u_phone);
		user.setU_url("/images/getAvatar.do.jpg");
		return user_service.addUser(user);
	}
	
	
	@RequestMapping("/emailCode")
	@ResponseBody
	public String getEmailCode(String e_mail) {
		return SendEmailCode.sendMessage(e_mail);
	}
	
	@RequestMapping("/checkEmail")
	@ResponseBody
	public boolean checkEmail(String e_mail) {
		User user =  new User();
		user.setU_email(e_mail);
		return user_service.findOneByEmailOrPhone(user)==null;
	}
	
	@RequestMapping("/phoneCode")
	@ResponseBody
	public String getPhoneCode(String u_phone) {
		return SendPhoneMessage.sendMessage(u_phone);
	}
	
	@RequestMapping("/checkPhone")
	@ResponseBody
	public boolean checkPhone(String u_phone) {
		User user =  new User();
		user.setU_phone(u_phone);
		return user_service.findOneByEmailOrPhone(user)==null;
	}
}
