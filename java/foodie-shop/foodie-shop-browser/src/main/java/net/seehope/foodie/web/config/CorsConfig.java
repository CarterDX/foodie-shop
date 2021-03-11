package net.seehope.foodie.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import net.seehope.foodie.properties.ProjectProperties;

@Configuration
public class CorsConfig {

	@Autowired
	private ProjectProperties properties;

	@Bean
	public CorsFilter corsFilter() {

		CorsConfiguration corsConfiguration = new CorsConfiguration();
		//  你需要跨域的地址  注意这里的 127.0.0.1 != localhost
        // * 表示对所有的地址都可以访问
		corsConfiguration.addAllowedOrigin(properties.getBrowser().getBaseStaticServerUrl());
		//	加上这一句，大致意思是可以携带cookie
		//	最终的结果是可以在跨域请求的时候获取同一个session
		corsConfiguration.setAllowCredentials(true);
		//	跨域的请求方法
		corsConfiguration.addAllowedMethod("*");
		//	跨域的请求头
		corsConfiguration.addAllowedHeader("*");

		//	配置可以访问的地址
		UrlBasedCorsConfigurationSource corsSource = new UrlBasedCorsConfigurationSource();
		corsSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(corsSource);
	}
}
