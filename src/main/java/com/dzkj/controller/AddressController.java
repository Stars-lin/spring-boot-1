package com.dzkj.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dzkj.pojo.Address;
import com.dzkj.pojo.User;
import com.dzkj.service.IAddressService;

@Controller
public class AddressController {
	
	@Autowired
	IAddressService addressService;
	
	@Autowired
	HttpServletRequest request;
	
	
	/**
	 * 判断
	 * @param address
	 * @return
	 */
	@RequestMapping("/skip")
	public String href(Address address,Map<String, Object> map) {
		if(address.getA_id()  == null) {//添加
			User user = (User) request.getSession().getAttribute("user");
			Address address2 = new Address();
			address2.setU_id(user.getU_id());
			List<Address> addresses = addressService.checkByUserid(address2);
			if (addresses.size() >= 3 ) {
				/* map.put("message", "地址不能超过三个"); */
				return "forward:dz";
			}else {
				return "forward:addAddress";
			}
		}else {//修改
			boolean updata = addressService.update(address);
			return "redirect:dz";
		}
	}
	
	/**
	 * 添加地址
	 * @param address
	 * @return
	 */
	@RequestMapping("/addAddress")
	public String addAddress(Address address) {
		boolean add;
		User user = (User) request.getSession().getAttribute("user");
		Address address2 = new Address();
		address2.setU_id(user.getU_id());
		List<Address> addresses = addressService.checkByUserid(address2);
		if (addresses.size() == 0 ) {
			add = addressService.add(address);
		}else {
			add = addressService.add(address);
		}
		if (add) {
			return "redirect:dz";
		}else {
			return"test";
		}
		
	}
	
	/**
	 * 删除地址
	 * @param address
	 * @return
	 */
	@RequestMapping("/delAddress")
	@ResponseBody
	public boolean delAddress(Integer addressid) {
		Address address = new Address();
		address.setA_id(addressid);
		boolean data = addressService.del(address);
		return data;
	}
	
	/**
	 * 地址查询
	 * @param userid
	 * @param map
	 * @return
	 */
	@RequestMapping("/dz")
	public String address(Map<String , Object> map) {
		System.out.println("地址管理");
	    User user = (User) request.getSession().getAttribute("user");
	    Address address2 = new Address();
		address2.setU_id(user.getU_id());
		List<Address> addresses = addressService.checkByUserid(address2);
		if (addresses.size() > 0) {
			map.put("add", addresses);
		}else {
			map.put("add", "请先添加地址");
		}
		return "person/address";
	}
	
	/**
	 * 修改默认地址
	 * @param address
	 * @return
	 */
	@RequestMapping("/def")
	@ResponseBody
	public String def(Integer a_id, Integer a_status) {
		Address address = addressService.findbyid(a_id);
		address.setA_status(a_status);
		boolean updata = addressService.update(address);
		if(updata) {
			return "1";
		}else {
			return "-1";
		}
		
	}
	
	/**
	 * 修改默认地址
	 * @param address
	 * @return
	 */
//	@RequestMapping("/updata")
//	public String update(Address address) {
//		System.out.println("修改");
//		
//		
//	}
}
