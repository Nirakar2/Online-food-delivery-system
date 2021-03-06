package com.onlinefoodservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinefoodservice.model.Category;
import com.onlinefoodservice.model.Item;

@Repository
public interface ItemDao extends JpaRepository<Item, Integer>{
	
	public List<Item> findByName(String name);
	
	public List<Item> findByCategory(Category category);
	
	public List<Item> findByAvailable(String available);
	

}
