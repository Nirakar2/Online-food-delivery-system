package com.onlinefoodservice.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	
	@GetMapping("/home")
	public String adminHomePage(Principal p, Model model) {
		model.addAttribute("username", p.getName());
		return "admin/adminhome";
	}
	
	@GetMapping("/profile")
	public String adminProfilePage(Principal p, Model model) {
		model.addAttribute("username", p.getName());
		return "admin/profile";
	}

	
	
}
