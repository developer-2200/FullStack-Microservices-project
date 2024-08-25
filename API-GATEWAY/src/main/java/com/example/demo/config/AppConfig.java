package com.example.demo.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@Configuration
public class AppConfig {
	@Bean
	public RestTemplate template() {
		return new RestTemplate();
	}
	
//	@Bean
//	CorsWebFilter corsWebFilter() {
//		CorsConfiguration corsConfiguration = new CorsConfiguration();
//		corsConfiguration.setAllowedOrigins(List.of("http://loaclhost:4300"));
//		corsConfiguration.setAllowedHeaders(List.of("/*"));
//		corsConfiguration.setAllowedMethods(List.of("/*"));
//		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
//		urlBasedCorsConfigurationSource.registerCorsConfiguration("/user", corsConfiguration);
//		urlBasedCorsConfigurationSource.registerCorsConfiguration("/employee", corsConfiguration);
//
//		
//		return new CorsWebFilter(urlBasedCorsConfigurationSource);
//	}

}
