package com.onlinefoodservice.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Booking_tbl")
public class Booking implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="booking_id")
	private int book_id;
	private String name;
	private String email;
	private long phone;
	
	private LocalDate date;
	
	private LocalTime time;
	
	private int numberofpeople;
	
	private String message;

	public Booking() {
		super();
	}

	public Booking(int book_id, String name, String email, long phone,LocalDate  date, LocalTime time,
			int numberofpeople, String message) {
		super();
		this.book_id = book_id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.date = date;
		this.time = time;
		this.numberofpeople = numberofpeople;
		this.message = message;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public int getNumberofpeople() {
		return numberofpeople;
	}

	public void setNumberofpeople(int numberofpeople) {
		this.numberofpeople = numberofpeople;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
