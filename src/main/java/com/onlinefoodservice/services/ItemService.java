package com.onlinefoodservice.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.onlinefoodservice.model.Item;

public interface ItemService {
	
	public void saveItem(Item item);
	
	public List<Item> selectAll();
	
	public Item selectById(int id);
	
	public void updateItem(Item item);
	
	public void deleteItem(Item item);
	
	public String[] getFileNameArray(MultipartFile[] images);
	
	

}
