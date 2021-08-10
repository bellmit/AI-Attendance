package com.jian.ssm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class Interceptor implements  HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String user  =(String) request.getSession().getAttribute("user");
		String url  = request.getRequestURI();
		if(url.indexOf("/sys_login/login") >= 0){
			return true;
		}
		if(url.indexOf("/peopleIdentity/PeopleIdentityApi")>=0){
			return  true ;
		}
		 if(StringUtils.isEmpty(user)){
			request.getRequestDispatcher("/sys_login/login").forward(request, response);
			 return false ;
		 }
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

}
