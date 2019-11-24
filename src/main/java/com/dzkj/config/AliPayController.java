package com.dzkj.config;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dzkj.mapper.IOrdertotalMapper;
import com.dzkj.pojo.Address;
import com.dzkj.pojo.Orderabout;
import com.dzkj.pojo.Ordertotal;
import com.dzkj.pojo.User;
import com.dzkj.service.IOrdertotalService;

@Controller
public class AliPayController {
	@Autowired
	AlipayService alipay_service;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	IOrdertotalService ordertotalService;
	
	@RequestMapping(value = "pay")
	@ResponseBody
	public String alipay() throws Exception {
		return alipay_service.alipay();
	}
	
	@RequestMapping("return_url")
	public String returnurl(Map<String , Object> map) {
		// 支付成功后可得到订单信息，然后自己往数据库写入数据 接着进入成功页面
//		System.out.println("订单号:"+request.getParameter("out_trade_no"));
//		System.out.println("付款金额:"+request.getParameter("total_amount"));
//		System.out.println("支付宝交易号:"+request.getParameter("trade_no"));
		Address address = (Address) request.getSession().getAttribute("address");
		Ordertotal ordertotal = ordertotalService.findbyo_bh((String) request.getSession().getAttribute("out_trade_no"));
		ordertotal.setA_consigneename(address.getA_consigneename());
		ordertotal.setA_province(address.getA_province());
		ordertotal.setA_city(address.getA_city());
		ordertotal.setA_area(address.getA_area());
		ordertotal.setA_phone(address.getA_phone());
		ordertotal.setA_details(address.getA_details());
		ordertotalService.updstates(ordertotal);
		
		map.put("orderdata", ordertotal);
		return "home/success";
	}
}
