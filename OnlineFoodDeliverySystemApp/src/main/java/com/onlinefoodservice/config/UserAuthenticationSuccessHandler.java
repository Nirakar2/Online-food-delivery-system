package com.onlinefoodservice.config;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
public class UserAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	
	protected Log logger  = LogFactory.getLog(this.getClass());
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
	handle(request, response, authentication);
	clearAuthenticationAttributes(request);
	}
	protected void handle(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
	throws IOException {
		
		String targetUrl = determineTargetUrl(authentication);
		
		if(response.isCommitted()) {
			logger.debug(
				"Response has already been committed. Unable to redirect " 
				+ targetUrl);
			return ;
			
			}
		redirectStrategy.sendRedirect(request, response, targetUrl);
		}



	
protected String determineTargetUrl(Authentication authentication) {
	boolean isUser = false;
	boolean isAdmin = false;
	//boolean isOwner = false;
	Collection<? extends GrantedAuthority> authorities
	= authentication.getAuthorities();
	for(GrantedAuthority grantedAuthority : authorities) {
		if(grantedAuthority.getAuthority().equals("ROLE_USER")) {
			isUser= true;
			System.out.println("user logedin!");
			break;
		}else if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
			isAdmin= true;
			System.out.println("admin logedin!");
			break;
		}
	}
	
	if(isUser) {
		return "/user/home";
	}else if (isAdmin) {
		return "/admin/home";
	}else {
		throw new IllegalStateException();
	}
} 
protected void clearAuthenticationAttributes(HttpServletRequest request) {
	HttpSession session = request.getSession(false);
	if(session == null) {
		return;
	}
	session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
}
}

