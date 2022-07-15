package com.onlinefoodservice.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.onlinefoodservice.model.Category;
import com.onlinefoodservice.model.Item;
import com.onlinefoodservice.model.UserDetail;
import com.onlinefoodservice.services.CategoryService;
import com.onlinefoodservice.services.UserDetailService;

@Controller
public class HomeController {
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserDetailService userDetailService;
	
	
	@GetMapping({"/","/home"})
	public String openHome() {
		
		return "index";
	}

	@GetMapping("/about")
	public String aboutAbout() {
		return "about";
	}
	
	@GetMapping("/menu")
	public String showMenu(Model model) {
		model.addAttribute("mainCategoryList", categoryService.selectMainCategories());
		Map<Category,List<Item>> catWiseItem  = categoryService.selectMenusByCategories();
		model.addAttribute("catwiselist", catWiseItem);
		return "menu";
	}
	
	
	@GetMapping("/contact")
	public String openContact() {
		return "contact";
	}
	
	
	@GetMapping("/signup")
	public String askdnaksjldn() {
		return "register";
	}
	
	
	@PostMapping("/signup")
	public String register(@ModelAttribute("userDetail") UserDetail  userDetail  ){
		
		if(!userDetail.getPassword().equals(userDetail.getConfirmPassword())) {
			return "redirect:/signup?password_mismatch";
		}
		userDetail.setPassword(passwordEncoder.encode(userDetail.getPassword()));
		
		userDetailService.saveUserDetail(userDetail);
		
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String userLosgin() {
		return "login";
	}
	
	
}
