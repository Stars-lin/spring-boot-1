package com.dzkj.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.dzkj.interceptor.ForwardInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer{
    
	@Autowired
	ForwardInterceptor forwardInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//添加拦截器，并添加拦截地址    加载拦截器，并配置拦截地址
		registry.addInterceptor(forwardInterceptor).addPathPatterns("/**/*html");
	}
	
	
}
