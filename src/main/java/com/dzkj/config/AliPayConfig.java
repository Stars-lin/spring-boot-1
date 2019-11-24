package com.dzkj.config;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 沙箱支付
 * @author 29433
 *
 */
public class AliPayConfig {
	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
		public static String app_id = "2016101500695166";
		
		// 商户私钥，您的PKCS8格式RSA2私钥
	    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCaq6jg4zhqW5MylEO5xI+XjMWuihT0GZf2HZjHabSatqgE2w9DMRH4+vf5uw5h4x+Hz5rFg0ektuyaScQns0xMemk887cm8Y1yNmIk7ZQQI/mifVtplaEXoUJopywJd96+u6Hkn6GpTOihDIutY71exVsuI7wQ4llin0jZ/ZJkwOXaTK9NXM/Nki/JGUUhKkjxAB9i6G0ELqD6cRR94PZYtKOvfj2JZsWs0TrHIjls0ZU6ugeflhZvc/3o/RzuO/AFeOzQ4U6RIKAGbKjpLazdXYqlUk73vBY+7fg6Ifo74TPnTIW+l/g5OGY8IygpT/ney9JEuUDxNQWxw7iO8bNnAgMBAAECggEAIuohIzLnp0qovcAuUZ8HcwR6E15kQH4OiaZAuLMp68rTvtTcaySGlBfDJoKNSpeEpJm+rFtoLsyEOIfyWavly1XOr82sSIQ6k8+m9AMVa1dToNR/cCQwyy7B2PHzxOdkRtYAQ6WtTpRn5wL3/NoJA321iYLTj1QpLVQbk+njxA5VCUGhCYAiEbuGnKG2ZTmTWZ8/VkegwWRD2jwsdyFF+9XHzJhRqNyh2Nq6tiOTXZ6k1NqwojAxcJAzanVQRShwY31K22lVmzYnzZTpmj1xda3uIdgPdiHpwrRNEJ+Mh106leCzmo1jGyB+LFyCvob/a/BWBOuvrUUgCyEDwUvpAQKBgQDcFeQghn3qnZ4iuGTytD2ICeFHAZpjhyJoF8p71icYbOiPPc9F6G0zWeYLKpCoA4WiZBfjauyCb2e0VuL5mFSgRBvI3uAhc6eBEbc8OGE1nPuCOirLRY48am5w7tzw41miX9cRdXpG7/tUC5ctw07KZad+Uu+QDRD1NjHmgRqlwQKBgQCz6QwlyhGsbnaodItucTd/in9aItHPDSzNUCbpuHsr4AjKKt9GyvwV8wr21qMNzwLhyPijIow8h/ZYi3qu+SPibYwZK3x4GkI2zkfeJwDwDP/rsoOV3LlTVIyLmqa3ewne7fKBEbDAH9GocgyQjBz6IAdlVLRTvilNWtidTh0zJwKBgQC3x7f1yRkAf5n7mEsDuKrhHI73wkjv73o1vhghjNScuuUAKDcbQ1lc1icZD/Q3uKkwz7B7AWB6ExlgKGXk0uVn5zfkZuh2RqOLTgXazaGvKWWEe5ocn/qETMPoni31IYRJ6Qoo1BbFgcQ3jG4zkrIKpRRWkl7lxWNxwE2vFAPygQKBgBLxEmpYIAw7hRqvSo7SNLmk50uiJtzZ0kG7kp1A4xb3e3Vtlhxp+qiE8j6S0o/9n5wOAL+MP5+P4Qvpg30wleqdBgcQYQZ0HUyP41ksWhjsBXXXUatRleGEIVgBbFQdDCkAfGvCZQ2VTAmkGFaPqe1bueudQ28dslOGoQ/OzZw5AoGAa29MQQk+CGi1wyrLMGJxA4xV9KNwV0KpqS4KuUXRe28XvbJ66ZmtoG+b/HTsrnyp6EOlAvMDlSsZ3MITuUEMo+P5KNItAMaEMJoqTiqd91f/3C/bf61fdOdA1c45xB0xK/GtTEKYOScMBqLJDtHfc6PKfPbj2o/jGsxagyHuOtI=";
		// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
	    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmquo4OM4aluTMpRDucSPl4zFrooU9BmX9h2Yx2m0mraoBNsPQzER+Pr3+bsOYeMfh8+axYNHpLbsmknEJ7NMTHppPPO3JvGNcjZiJO2UECP5on1baZWhF6FCaKcsCXfevruh5J+hqUzooQyLrWO9XsVbLiO8EOJZYp9I2f2SZMDl2kyvTVzPzZIvyRlFISpI8QAfYuhtBC6g+nEUfeD2WLSjr349iWbFrNE6xyI5bNGVOroHn5YWb3P96P0c7jvwBXjs0OFOkSCgBmyo6S2s3V2KpVJO97wWPu34OiH6O+Ez50yFvpf4OThmPCMoKU/53svSRLlA8TUFscO4jvGzZwIDAQAB";
		// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
		public static String notify_url = "http://localhost:8080/";

		// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
		public static String return_url = "http://localhost:8080/return_url";

		// 签名方式
		public static String sign_type = "RSA2";
		
		// 字符编码格式
		public static String charset = "utf-8";
		
		// 支付宝网关
		public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
		
		// 支付宝网关
		public static String log_path = "C:\\";


	//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

	    /** 
	     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
	     * @param sWord 要写入日志里的文本内容
	     */
	    public static void logResult(String sWord) {
	        FileWriter writer = null;
	        try {
	            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
	           
	            writer.write(sWord);
	            System.out.println(writer);
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            if (writer != null) {
	                try {
	                    writer.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	    }
}
