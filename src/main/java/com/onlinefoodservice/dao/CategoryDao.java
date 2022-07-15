package com.onlinefoodservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinefoodservice.model.Category;

@Repository
public interface CategoryDao extends JpaRepository<Category, Integer>{
	

		// basic crud operations are generated automatically
		// we can add others as below
	
	public List<Category> findByName(String name);
	
	public List<Category> findByParentCat(int parentCat);
	
	
	
}
