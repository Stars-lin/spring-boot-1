package com.dzkj.util;

import org.apache.commons.mail.HtmlEmail;

public class SendEmailCode {
	public static String sendMessage(String e_mail){
		String code = CodeUtil.getCode();
		try {
//			创建一个HtmlEmail实例
			HtmlEmail email = new HtmlEmail();
//			邮箱的SMTP服务
			email.setHostName("smtp.163.com");
//			设置发送的字符集
			email.setCharset("utf-8");
//			设置收件人
			email.addTo(e_mail);
//			设置发件人，参数1：发送人邮箱，参数2：用户名（随意填写）
			email.setFrom("lhxqa315@163.com", "橘猫在线");
//			设置发送人的邮箱和授权密码
			email.setAuthentication("lhxqa315@163.com", "lhxqa315");
//			设置发送主题
			email.setSubject("橘猫在线");
//			设置发送内容
			email.setMsg("<h1>橘猫在线网上商城提醒您</h1>"
					+ "<br>"
					+ "<h2>您的注册激活码为："+code+"</h2>"
					+ "<br>"
					+ "<h3>如果不是本人操作，请忽略该邮件</h3>");
//			发送
			email.send();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return code;
	}
}
