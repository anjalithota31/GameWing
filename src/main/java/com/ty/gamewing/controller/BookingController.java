package com.ty.gamewing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.gamewing.dto.Booking;
import com.ty.gamewing.entity.ResponseStructure;
import com.ty.gamewing.service.BookingService;

@RestController
public class BookingController {

	@Autowired
	private BookingService service;

	@PostMapping("/savebooking")
	public ResponseEntity<ResponseStructure<Booking>> saveBooking(@RequestParam int courtId, @RequestParam String email,
			@RequestBody Booking booking) {
		return service.saveBooking(courtId, email, booking);
	}

	@GetMapping("/findbooking")
	public ResponseEntity<ResponseStructure<Booking>> findBookingById(@RequestParam int id) {
		return service.findBookingById(id);
	}
}
