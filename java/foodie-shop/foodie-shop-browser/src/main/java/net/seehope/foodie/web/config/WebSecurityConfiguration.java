
package net.seehope.foodie.web.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.filter.CorsFilter;




/**
 * 认证 鉴权 攻击防护
 *
 */
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

//	@Autowired
//    private UserDetailsService userDetailsService;
	
//	@Autowired
//	private CorsFilter corsFilter;
	
	 @Bean
	    public BCryptPasswordEncoder passwordEncoder(){
	        return new BCryptPasswordEncoder();
	    }

    //指定认证对象的来源
//	@Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//    	//加密
//        auth.userDetailsService(userDetailsService)
//        	.passwordEncoder(passwordEncoder());
//    }
    
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()//接下来都是对请求的配置
			.anyRequest()
//				.authenticated()
			.permitAll()//所有请求放行
			.and()
			.csrf()
			.disable();//攻击防护关闭
		
//		authorizeConfigManager.config(http.authorizeRequests());
//		formAuthenticationConfig.config(http);

//		http.rememberMe()// 接下来都是对记住我功能的配置
//				.tokenRepository(persistentTokenRepository())// 配置token的存储方式
//				.tokenValiditySeconds(projectProperties.getBrowser().getTokenValiditySeconds())// token有效期
//				.userDetailsService(userDetailService)// 从token中获取到用户名之后，走那个一个userDetailService
//				.and()// 返回http配置
//				.csrf()// csrf攻击防护
//				.disable();// 暂时关闭

//		http.apply(smsCodeAuthenticationConfig);
//		http.apply(validateCodeSecurityConfig);
	}
	
	
	

	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * 
	 * BrowserProperties properties = projectProperties.getBrowser();
	 * 
	 * ValidateCodeFilter validateCodeFilter = new ValidateCodeFilter();
	 * validateCodeFilter.setFailureHandler(authenticationFailureHandler);
	 * validateCodeFilter.setProperties(projectProperties);
	 * validateCodeFilter.setValidateCodeProcessors(validateCodeProcessors);
	 * validateCodeFilter.afterPropertiesSet();
	 * 
	 * SmsCodeAuthenticationFilter smsCodeAuthenticationFilter = new
	 * SmsCodeAuthenticationFilter();
	 * smsCodeAuthenticationFilter.setAuthenticationManager(authenticationManager())
	 * ; smsCodeAuthenticationFilter.setAuthenticationSuccessHandler(
	 * authenticationSuccessHandler);
	 * smsCodeAuthenticationFilter.setAuthenticationFailureHandler(
	 * authenticationFailureHandler);
	 * 
	 * authorizeConfigManager.config(http.authorizeRequests());
	 * formAuthenticationConfig.config(http);
	 * 
	 * http.addFilterBefore(validateCodeFilter,
	 * UsernamePasswordAuthenticationFilter.class)//
	 * 将自定义的过滤器添加到usernamepassword过滤器之前
	 * .addFilterBefore(smsCodeAuthenticationFilter,
	 * UsernamePasswordAuthenticationFilter.class)// 将短信登录过滤器添加到用户名密码之前
	 * .rememberMe()// 接下来都是对记住我功能的配置
	 * .tokenRepository(persistentTokenRepository())// 配置token的存储方式
	 * .tokenValiditySeconds(properties.getTokenValiditySeconds())// token有效期
	 * .userDetailsService(userDetailService)//
	 * 从token中获取到用户名之后，走那个一个userDetailService .and()// 返回http配置 .csrf()// csrf攻击防护
	 * .disable();// 暂时关闭
	 * 
	 * }
	 */

	/*	*//**
			 * 很多框架在覆盖某个配置之后，其实已经将父类默认的配置覆盖掉了，这个时候需要调用一下父类的方法
			 *//*
				 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
				 * Exception { // 添加短信登录处理逻辑 SmsCodeAuthenticationProvider
				 * smsCodeAuthenticationProvider = new SmsCodeAuthenticationProvider();
				 * smsCodeAuthenticationProvider.setUserDetailsService(userDetailService);
				 * 
				 * DaoAuthenticationProvider daoAuthenticationProvider = new
				 * DaoAuthenticationProvider();
				 * daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
				 * daoAuthenticationProvider.setUserDetailsService(userDetailService);
				 * 
				 * auth.authenticationProvider(daoAuthenticationProvider);
				 * auth.authenticationProvider(smsCodeAuthenticationProvider); }
				 */

}
