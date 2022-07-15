package com.onlinefoodservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlinefoodservice.dao.BookingDao;
import com.onlinefoodservice.model.Booking;

@Service
@Transactional

public class BookingServiceImpl implements BookingService{

	@Autowired
	BookingDao bookingDao;
	
	public void saveBooking(Booking booking) {
		// TODO Auto-generated method stub
		bookingDao.save(booking);
	}

	@Override
	public List<Booking> selectAll() {
		// TODO Auto-generated method stub
		return bookingDao.findAll();
	}

	@Override
	public Booking selectById(int bokId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Booking> selectByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Booking> selectMainBookings() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Booking> selectByParentBok(int parentBok) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateBooking(Booking bok) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCategory(Booking bok) {
		// TODO Auto-generated method stub
		
	}

	
	

}
