package net.seehope.foodie.config;

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

		System.out.println(properties.getBrowser().getBaseStaticServerUrl());

		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.addAllowedOrigin(properties.getBrowser().getBaseStaticServerUrl());
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.addAllowedMethod("*");
		corsConfiguration.addAllowedHeader("*");

		UrlBasedCorsConfigurationSource corsSource = new UrlBasedCorsConfigurationSource();
		corsSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(corsSource);
	}
}
