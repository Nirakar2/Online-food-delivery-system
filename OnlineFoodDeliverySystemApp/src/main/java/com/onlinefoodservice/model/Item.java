package com.onlinefoodservice.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="item_tbl")
public class Item {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int itemId;
	
	@ManyToOne
	private Category category;
	
	private String name;
	private String description;
	private double price;
	private String available;
	private String[] images;
	private String itemCode;
	
	public Item() {
		super();
	}

	public Item(int itemId, Category category, String name, String description, double price, String available,
			String[] images, String itemCode) {
		super();
		this.itemId = itemId;
		this.category = category;
		this.name = name;
		this.description = description;
		this.price = price;
		this.available = available;
		this.images = images;
		this.itemCode = itemCode;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAvailable() {
		return available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}

	public String[] getImages() {
		return images;
	}

	public void setImages(String[] images) {
		this.images = images;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	
	
	
	

}
