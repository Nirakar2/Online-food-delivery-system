package com.onlinefoodservice.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="role_table")
public class Roles implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2342342234L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="role_id", updatable = false, nullable = false)
	private int id;
	
	private String role;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name="user_id")
    private UserDetail userDetail;

	public Roles() {
		super();
	}

	public Roles(int id, String role, UserDetail userDetail) {
		super();
		this.id = id;
		this.role = role;
		this.userDetail = userDetail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public UserDetail getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

	
	
	
}
