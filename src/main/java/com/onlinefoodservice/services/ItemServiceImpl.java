package com.onlinefoodservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.onlinefoodservice.dao.ItemDao;
import com.onlinefoodservice.model.Item;

@Service
@Transactional
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	ItemDao itemDao;

	@Override
	public void saveItem(Item item) {
		// TODO Auto-generated method stub
		itemDao.save(item);
	}

	@Override
	public List<Item> selectAll() {
		// TODO Auto-generated method stub
		return itemDao.findAll();
	}

	@Override
	public Item selectById(int id) {
		
		return itemDao.getById(id);
	}

	@Override
	public void updateItem(Item item) {
		// TODO Auto-generated method stub
		 itemDao.save(item);
	}

	@Override
	public void deleteItem(Item item) {
		// TODO Auto-generated method stub
		itemDao.delete(item);
	}

	@Override
	public String[] getFileNameArray(MultipartFile[] images) {
		
		String[] imageNames = new String[images.length];
		for(int i=0; i<imageNames.length; i++) {
			imageNames[i] = images[i].getOriginalFilename();
		}
		return imageNames;
	}

}
