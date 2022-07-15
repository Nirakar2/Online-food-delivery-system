package com.onlinefoodservice.services;

import java.util.List;
import java.util.Map;

import com.onlinefoodservice.model.Booking;



public interface BookingService {
public void saveBooking(Booking booking);
	
	public List<Booking> selectAll();
	
	public Booking selectById(int bokId);
	
	public List<Booking> selectByName(String name);
	
	public List<Booking> selectMainBookings();
	
	public List<Booking> selectByParentBok(int parentBok);
	
	public void updateBooking(Booking bok);
	
	public void deleteCategory(Booking bok);

	
}
