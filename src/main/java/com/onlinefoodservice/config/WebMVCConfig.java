package com.onlinefoodservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMVCConfig implements WebMvcConfigurer {

	@Override
public void addResourceHandlers(ResourceHandlerRegistry registry) {
registry
        .addResourceHandler("/menu_images/**")
        .addResourceLocations("file:/users/stim/desktop/images_uploads/")
        .setCachePeriod(0);

}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}