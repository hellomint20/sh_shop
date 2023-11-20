package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Configuration
public class webConfig implements WebMvcConfigurer {
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		 registry.addInterceptor(new interceptor())
	 		.excludePathPatterns("/css/**", "/images/**", "/js/**");
	}
	
	@Bean(name = "jsonView")
	MappingJackson2JsonView jsonView() {
		return new MappingJackson2JsonView();
	}

}
