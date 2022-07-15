package com.onlinefoodservice.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.onlinefoodservice.model.Booking;
import com.onlinefoodservice.services.BookingService;



@Controller
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	
	
	
	@GetMapping("/booking")
	public String defineBooking() {
//		model.addAttribute("BookingList", BookingService.selectAll());
		return "index";
	}
		// get list of mainBookings only // fixed // show only main form view 
		@PostMapping("/booking")
	public String saveBooking( 
				@RequestParam("name") String name,
				@RequestParam("email") String email,
				@RequestParam("phone") long phone,
				@RequestParam("date") String date,
				@RequestParam("time") String time,
				@RequestParam("people") int numberofpeople,
				@RequestParam("message") String message) {
	
Booking book = new Booking();
book.setName(name);
book.setEmail(email);
book.setPhone(phone);

book.setDate( LocalDate.parse(date));
book.setTime( LocalTime.parse(time));
book.setNumberofpeople( numberofpeople);
book.setMessage( message);
		
		bookingService.saveBooking(book);
		System.out.println("booking saved");
		return "redirect:/home";
}	

@GetMapping("/admin/booking/show")
public String showBooking(Model model) {
	model.addAttribute("bookingList", bookingService.selectAll());
	
	return "admin/table";
}
}
		
	
			
			

