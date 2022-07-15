package com.onlinefoodservice.services;

import java.util.List;
import java.util.Map;

import com.onlinefoodservice.model.Category;
import com.onlinefoodservice.model.Item;

public interface CategoryService {

	
	public void saveCategory(Category cat);
	
	public List<Category> selectAll();
	
	public Category selectById(int catId);
	
	public List<Category> selectByName(String name);
	
	public List<Category> selectMainCategories();
	
	public List<Category> selectByParentCat(int parentCat);
	
	public void updateCategory(Category cat);
	
	public void deleteCategory(Category cat);

	public Map<Category, List<Item>> selectMenusByCategories();
	
	
}
