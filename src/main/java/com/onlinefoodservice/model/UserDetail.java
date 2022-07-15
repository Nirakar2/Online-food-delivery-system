package com.onlinefoodservice.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="User_details")
public class UserDetail implements Serializable{

	private static final long serialVersionUID = 2342342234L;


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id", updatable = false, nullable = false)
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String gender;
	
	@Column(unique = true)
	private String username;
	
	private String password;
	// applying front-end validation for confirm-password
	@Transient
	private String confirmPassword;
	
	private String active;
	
	@Transient
	private String authority;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="userDetail")
    private Roles roles;

	public UserDetail() {
		super();
	}

	
	public UserDetail(int id, String firstName, String lastName, String email, String gender, String username,
			String password, String confirmPassword, String active, String authority, Roles roles) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.username = username;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.active = active;
		this.authority = authority;
		this.roles = roles;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getConfirmPassword() {
		return confirmPassword;
	}


	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}


	public String getActive() {
		return active;
	}


	public void setActive(String active) {
		this.active = active;
	}


	public String getAuthority() {
		return authority;
	}


	public void setAuthority(String authority) {
		this.authority = authority;
	}


	public Roles getRoles() {
		return roles;
	}


	public void setRoles(Roles roles) {
		this.roles = roles;
	}
	
	
	
	
}
