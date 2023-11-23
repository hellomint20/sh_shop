package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("prod")
@Configuration
public class prodConfiguration {
	
	@Bean
	String hello() {
		return "hello prod";
	}
}
