package com.onlinefoodservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinefoodservice.model.Booking;

@Repository
public interface BookingDao extends JpaRepository<Booking, Integer>{
	
	public List<BookingDao> findByName(String name);
	public BookingDao findByPhone(long phone); //for unique search option
	public BookingDao findByEmail(String email); // for unique search option
}
