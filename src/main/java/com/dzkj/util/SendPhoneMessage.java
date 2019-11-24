package com.dzkj.util;


import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

public class SendPhoneMessage {
	
	public static String sendMessage(String phonenumber) {
		DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI2ly0cnMmR5Bg", "6oC0YRLUvBAyWdQsp1RRfheiEyq2aO");
		IAcsClient client = new DefaultAcsClient(profile);
		CommonRequest request = new CommonRequest();
		String code = CodeUtil.getCode();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phonenumber);
        request.putQueryParameter("SignName", "橘猫在线购物");
        request.putQueryParameter("TemplateCode", "SMS_176480029");
        request.putQueryParameter("TemplateParam", "{\"code\":\""+code+"\"}");
        CommonResponse response = null;
        try {
        	response  = client.getCommonResponse(request);
        	System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        System.out.println(response);
        return code;
	}
	
}
