package com.chen.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.chen.common.interceptor.LoginInterceptor;

/**
 * @ClassName:  InterceptorConfigurer   
 * @Description:TODO 
 * @author:chencundeng 自定义拦截配置类 
 * @date:   2018年4月8日 下午2:40:59       
 * @Copyright: 2018 www.chen.com Inc. All rights reserved.
 */
@Configuration
public class InterceptorConfigurer extends WebMvcConfigurerAdapter{

	@Override
	  public void addInterceptors(InterceptorRegistry registry) { 
	    // 多个拦截器组成一个拦截器链 
	    // addPathPatterns 用于添加拦截规则 
	    // excludePathPatterns 用户排除拦截 
		 registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/system/**"); 
		 super.addInterceptors(registry); 
	  } 
	
}
