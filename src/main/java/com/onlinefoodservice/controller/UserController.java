package com.onlinefoodservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.onlinefoodservice.services.UserDetailService;

@Controller
public class UserController {
	
	@Autowired
	UserDetailService userDetailService;
	
	@GetMapping("/user/home")
	public String getUserProfile(Model model, Authentication auth) {
		String username = auth.getName();
		String userrole = auth.getAuthorities().toString();
		
		//model.addAttribute("username", username);
		//model.addAttribute("userrole", userrole);
		
		model.addAttribute("userdetail",
				userDetailService.selectUserByUsername(username));
		return "user_profile" ;
		
	}
	@GetMapping("/user_profile")
	public String getUsersProfile() {
		
		return "design_page" ;
		
	}
}
