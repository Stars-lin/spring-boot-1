package com.dzkj.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dzkj.pojo.Collection;
import com.dzkj.pojo.Foot;
import com.dzkj.pojo.User;
import com.dzkj.service.ICollectionService;

@Controller
public class CollectionController {

	@Autowired
	ICollectionService collectionService;
	
	@Autowired
	HttpServletRequest request;
	
	@RequestMapping("/collection")
	public String foot(Map<String, Object> map) {
		User user = (User) request.getSession().getAttribute("user");
		List<Collection> collections = collectionService.findbyu_id(user.getU_id());
		map.put("collections", collections);
		return "person/collection";
	}
	
	@RequestMapping("/delcollection")
	@ResponseBody
	public boolean delfoot(Integer c_id) {
		return collectionService.del(c_id);
	}
}
