package com.dzkj.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dzkj.pojo.Foot;
import com.dzkj.pojo.User;
import com.dzkj.service.IFootService;

@Controller
public class FootController {

	@Autowired
	IFootService footService;
	
	@Autowired
	HttpServletRequest request;
	
	@RequestMapping("/foot")
	public String foot(Map<String, Object> map) {
		User user = (User) request.getSession().getAttribute("user");
		List<Foot> foots = footService.findbyu_id(user.getU_id());
		map.put("foots", foots);
		return "person/foot";
	}
	
	@RequestMapping("/delfoot")
	@ResponseBody
	public boolean delfoot(Integer f_id) {
		return footService.del(f_id);
	}
}
