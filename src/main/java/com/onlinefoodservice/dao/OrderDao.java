package com.onlinefoodservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinefoodservice.model.Order;

public interface OrderDao extends JpaRepository<Order, Integer>{
	public List<BookingDao> findByName(String name);
	public BookingDao findByPhone(long phone); //for unique search option
	public BookingDao findByEmail(String email); // for unique search option
}
