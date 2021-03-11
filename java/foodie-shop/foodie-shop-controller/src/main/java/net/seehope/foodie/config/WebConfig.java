package net.seehope.foodie.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import net.seehope.foodie.controller.filter.TimeFilter;
import net.seehope.foodie.controller.intercepter.TimeIntercepter;

//@Configuration
public abstract class WebConfig implements WebMvcConfigurer {

	
	@Autowired 
	private TimeIntercepter timeIntercepter;
	
	/*
	 * 配置过滤器
	 */
	@Bean 
	public FilterRegistrationBean timeFilter() {
		FilterRegistrationBean bean = new FilterRegistrationBean(); 
		TimeFilter timeFilter = new TimeFilter();
		bean.setFilter(timeFilter);
		List<String> urls = new ArrayList<String>();
		urls.add("/index/*");
		bean.setUrlPatterns(urls);
		return bean;
	}
	 
	/*
	 * 配置拦截器
	 * 
	 */
	 @Override
	 public void addInterceptors(InterceptorRegistry registry) {
	  registry.addInterceptor(timeIntercepter);
	 }

	@Override
	public void addCorsMappings(CorsRegistry registry) {

		registry.addMapping("/**")
				.allowedOrigins("*")
				.maxAge(300L);
	}
	 
	 
	 

}
