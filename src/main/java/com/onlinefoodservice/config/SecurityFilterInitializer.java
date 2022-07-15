package com.onlinefoodservice.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SecurityFilterInitializer extends AbstractSecurityWebApplicationInitializer{

	

	public SecurityFilterInitializer() {
		super(SecurityFilterConfiguration.class);
	}

	
	
}
