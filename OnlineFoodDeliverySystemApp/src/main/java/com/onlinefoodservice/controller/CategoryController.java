package com.onlinefoodservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.onlinefoodservice.model.Category;
import com.onlinefoodservice.services.CategoryService;

@Controller
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/admin/category/add")
	public String defineCategory(Model model) {
		// get list of mainCategories only // fixed // show only main form view 
		List<Category> cl = categoryService.selectAll();
//		List<Category> cl = categoryService.selectByParentCat(0);
		model.addAttribute("categorylist", cl);
		return "admin/category";
	}

	@PostMapping("/admin/category/save")
	public String saceCategory(@ModelAttribute("category") Category category ) {
		categoryService.saveCategory(category);
		return "redirect:/admin/category/add";
	}
	
	
	
	@GetMapping("/admin/category/show")
	public String showCategory(Model model) {
		List<Category> cl = categoryService.selectAll();
		model.addAttribute("categorylist", cl);
		return "admin/category";
	}
	
	@GetMapping("/admin/category/edit/{id}")
	public String editCategory(@PathVariable("id") int id, Model model) {
		model.addAttribute("edit", true);
		List<Category> cl = categoryService.selectAll();
		model.addAttribute("categorylist", cl);
		model.addAttribute("oldcategory", categoryService.selectById(id));
		return "admin/category";
	}
	
	@PostMapping("/admin/category/update")
	public String updateCategory(@ModelAttribute("category") Category category ) {
		categoryService.updateCategory(category);
		return "redirect:/admin/category/show";
	}
	
	
	@GetMapping("/admin/category/delete/{id}")
	public String deleteCategory(@PathVariable("id") int id) {
		Category cat = categoryService.selectById(id);
		categoryService.deleteCategory(cat);
		return "redirect:/admin/category/show";
	}
	
}
