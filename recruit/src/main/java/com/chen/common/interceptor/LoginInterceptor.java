package com.chen.common.interceptor;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.chen.system.entity.SysUser;

/**
 * @ClassName:  MyInterceptor   
 * @Description:TODO 系统拦截器 
 * @author:chencundeng 
 * @date:   2018年4月4日 下午5:27:20       
 * @Copyright: 2018 www.chen.com Inc. All rights reserved.
 */
public class LoginInterceptor implements HandlerInterceptor{
    
	private final static String LOGIN_URL="/system/login/loginip";
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView view)
			throws Exception {
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		
		if(request.getRequestURI().equals(LOGIN_URL)||request.getRequestURI().equals("/system/login/login")){
			return true;
		}
		 
		SysUser sysUser = (SysUser) request.getSession().getAttribute("user");
		if(null==sysUser){
			response.sendRedirect("/system/login/loginip");
			return false;
		}
		
		//@SuppressWarnings("unchecked")
		//Set<Long> limits = (Set<Long>) request.getSession().getAttribute("user");
		
		return true;// 只有返回true才会继续向下执行，返回false取消当前请求
		
	}

}
