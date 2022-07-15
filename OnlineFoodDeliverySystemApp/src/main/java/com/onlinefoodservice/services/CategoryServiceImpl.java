package com.onlinefoodservice.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlinefoodservice.dao.CategoryDao;
import com.onlinefoodservice.dao.ItemDao;
import com.onlinefoodservice.model.Category;
import com.onlinefoodservice.model.Item;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDao categoryDao;

	@Autowired
	ItemDao itemDao;

	@Override
	public void saveCategory(Category cat) {
		categoryDao.save(cat);
	}

	@Override
	public List<Category> selectAll() {

		return categoryDao.findAll();
	}

	@Override
	public Category selectById(int catId) {

		return categoryDao.getById(catId);
	}

	@Override
	public List<Category> selectByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> selectByParentCat(int parentCat) {
		// feature fix -- display only main level categories for sub-category creation..
		return categoryDao.findByParentCat(parentCat);
	}

	@Override
	public void updateCategory(Category cat) {
		categoryDao.save(cat);
	}

	@Override
	public void deleteCategory(Category cat) {
		List<Category> subCategoryList = categoryDao.findByParentCat(cat.getCatId());
		categoryDao.delete(cat);
	}

	@Override
	public List<Category> selectMainCategories() {
		// ParentCat value 0 for main categories
		return categoryDao.findByParentCat(0);
	}

	@Override
	public Map<Category, List<Item>> selectMenusByCategories() {
		List<Category> parentCatList = categoryDao.findByParentCat(0); // fetches parent main categories
		Map<Category, List<Item>> menuMap = new HashMap<>();
		for (Category cat : parentCatList) {
			List<Item> catItems = new ArrayList<>();
			for (Category c : categoryDao.findByParentCat(cat.getCatId())) // fetches sub categorries
			{
				catItems.addAll(itemDao.findByCategory(c));
			}
			menuMap.put(cat, catItems);
		}
			
		return menuMap;
	}

}
