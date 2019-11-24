package com.dzkj.config;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;


/**
 * 支付逻辑处理类
 * 必须提供订单号订单总金额，订单描述
 * @author 29433
 *
 */

@Service
public class AlipayService {
	@Autowired
	HttpServletRequest request;
	

	@Autowired
	OrderIdUtil orderIdUtil;

	public String alipay() throws AlipayApiException, UnsupportedEncodingException {
		//获得初始化的AlipayClient
		AlipayClient alipayClient = new DefaultAlipayClient(AliPayConfig.gatewayUrl, AliPayConfig.app_id, AliPayConfig.merchant_private_key, "json", AliPayConfig.charset, AliPayConfig.alipay_public_key, AliPayConfig.sign_type);
		//设置请求参数
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
		alipayRequest.setReturnUrl(AliPayConfig.return_url);
		alipayRequest.setNotifyUrl(AliPayConfig.notify_url);

		//商户订单号，商户网站订单系统中唯一订单号，必填
		Object out_trade_no = request.getSession().getAttribute("out_trade_no");
		//付款金额，必填
		Integer total_amount =  (Integer) request.getSession().getAttribute("total_amount");
		//订单名称，必填
		String subject = (String) request.getSession().getAttribute("subject");
		//商品描述，可空
		String body = request.getParameter("body");
		alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\"," 
				+ "\"total_amount\":\""+ total_amount +"\"," 
				+ "\"subject\":\""+ subject +"\"," 
				+ "\"body\":\""+ body +"\"," 
				+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

		//请求
		String result = alipayClient.pageExecute(alipayRequest).getBody();

		//输出
		return result;
	}
	
}
