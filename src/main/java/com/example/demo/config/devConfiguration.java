package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("dev")
@Configuration
public class devConfiguration {
	
	@Bean
	String hello() {
		return "hello dev";
	}
}
