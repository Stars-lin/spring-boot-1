package com.dzkj.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
/**
 * 页面拦截器配置
 * 该拦截器仅拦截以html结尾的页面请求
 * 比如说访问localhost:8080、localhost:8080/findAll、localhost:8080/login
 * 	以上这样的请求都不会拦截
 * ---------------------------
 * localhost:8080/login.html、localhost:8080/index.html
 * 以上这样的请求才会拦截
 * 
 * 这个拦截器主要的作用在于，当我们直接在地址栏访问页面时，或者是点击页面超链接时
 * 是不会经过springmvc控制器的，也就不能在页面使用th元素，就会拿不到值
 * 上次我说的是访问页面，需要先进控制器 然后由控制器转发该页面才能获取数据
 * 这种方式太麻烦了，所以我想了下加了个拦截器去实现
 * 
 * 思路：
 * 当请求以html为结尾的页面时拦截请求，获取到当前请求路径
 * 从路径中截取出页面名称，然后请求到控制器中，将页面名称作为参数传递过去
 * 控制拿到页面名称后，直接转发跳入该页面
 * 这样的好处就是，页面中直接访问html的超链接可以不用改，不需要加后台方法跳转页面
 * 包括直接在地址栏访问该页面，也能使用th元素获得数据
 * 
 * 
 * 注意：
 * 转发的地址我写的是topage 可以将如下代码放在任意一个Controller中即可
 * 建议都放在WelcomeController中

 	@RequestMapping("topage")
	public String tohtml(HttpServletRequest request) {
		return (String) request.getAttribute("pageName");
	}
 
 * 
 */
@Component
public class ForwardInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 拿到请求的路径
		String path = request.getServletPath();
		// 这里做了个确认 一定是html结尾的
		if(path.endsWith("html")) {
			// 拿到页面名称  可以输出看看
			String pageName = path.substring(1, path.lastIndexOf("."));
			// 排除掉footer页面与header页面 或其他公共页面
			if(!pageName.equals("footer") && !pageName.equals("header")) {
				// 将页面名称保存 转发到控制器中 topage地址
				request.setAttribute("pageName", pageName);
				request.getRequestDispatcher("/topage").forward(request, response);
				return false;
			}
		}
		return true;
	}

	
}
