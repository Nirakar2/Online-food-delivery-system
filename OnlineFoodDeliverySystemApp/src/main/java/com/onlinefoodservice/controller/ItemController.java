package com.onlinefoodservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.onlinefoodservice.model.Category;
import com.onlinefoodservice.model.Item;
import com.onlinefoodservice.services.CategoryService;
import com.onlinefoodservice.services.ItemService;
import com.onlinefoodservice.services.UploadService;

@Controller
public class ItemController {
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	UploadService uploadService;
	
	
	@Autowired
	ItemService itemService;

	@GetMapping("/admin/item/add")
	public String AddItem(Model model) {
		model.addAttribute("categorylist", categoryService.selectAll());
		return "admin/item";
	}
	
	@PostMapping("/admin/item/save")
	public String saveItem(@RequestParam("name") String name,
							@RequestParam("description") String description,
							@RequestParam("price") double price,
							@RequestParam("available") String available,
							@RequestParam("images") MultipartFile[] images,
							@RequestParam("itemCode") String itemCode,
							@RequestParam("catId") int catId) {
		Item item = new Item();
		item.setAvailable(available);
		item.setDescription(description);
		item.setItemCode(itemCode);
		item.setName(name);
		item.setPrice(price);
		
		String[] imageNames = itemService.getFileNameArray(images);
		item.setImages(imageNames);
		Category category = categoryService.selectById(catId);
		item.setCategory(category);
		
		itemService.saveItem(item);
		uploadService.uploadImages(images);
		return "redirect:/admin/item/add";
	}
	
	@GetMapping("/admin/item/show")
	public String showItem(Model model) {
		model.addAttribute("itemlist", itemService.selectAll());
		return "admin/item";
	}
	
	@GetMapping("/admin/item/edit/{id}")
	public String updateItem(Model model, @PathVariable("id") int id) {
		model.addAttribute("edit", true);
		model.addAttribute("olditem", itemService.selectById(id));
		model.addAttribute("itemlist", itemService.selectAll());
		return "admin/item";
	}
	
	@PostMapping("/admin/item/update")
	public String editItem(@RequestParam("itemId") int itemId,
							@RequestParam("name") String name,
							@RequestParam("description") String description,
							@RequestParam("price") double price,
							@RequestParam("available") String available,
							@RequestParam("images") MultipartFile[] images,
							@RequestParam("itemCode") String itemCode,
							@RequestParam("catId") int catId) {
		Item item = new Item();
		item.setItemId(itemId);
		item.setAvailable(available);
		item.setDescription(description);
		item.setItemCode(itemCode);
		item.setName(name);
		item.setPrice(price);
		
		String[] imageNames = itemService.getFileNameArray(images);
		item.setImages(imageNames);
		Category category = categoryService.selectById(catId);
		item.setCategory(category);
		
		itemService.saveItem(item);
		uploadService.uploadImages(images);
		return "redirect:/admin/item/add";
	}
	

	@GetMapping("/admin/item/delete/{id}")
	public String deleteItem(@PathVariable("id") int id) {
		Item item = new Item();
		item.setItemId(id);
		itemService.deleteItem(item);
		return "redirect:/admin/item/show";
	}
	
	
}
