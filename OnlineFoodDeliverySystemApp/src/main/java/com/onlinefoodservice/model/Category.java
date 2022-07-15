package com.onlinefoodservice.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Category_tbl")

public class Category implements Serializable{
	
	public static final long serialVersionUID = 1212222L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cat_id")
	private int catId;
	@Column(unique=true)
	private String name;
	
	private String description;
	
	private int parentCat;

	@OneToMany(mappedBy="category", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Item> items;
	
	
	public Category() {
		super();
	}

	public Category(int catId, String name, String description, int parentCat, List<Item> items) {
		super();
		this.catId = catId;
		this.name = name;
		this.description = description;
		this.parentCat = parentCat;
	}

	

	public List<Item> getItems() {
		return items;
	}


	public void setItems(List<Item> items) {
		this.items = items;
	}


	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
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

	public int getParentCat() {
		return parentCat;
	}

	public void setParentCat(int parentCat) {
		this.parentCat = parentCat;
	}
	
	

}
