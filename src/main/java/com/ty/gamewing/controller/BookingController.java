package com.ty.gamewing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@GetMapping("/findallbooking")
	public ResponseEntity<ResponseStructure<List<Booking>>> findAllBooking() {
		return service.findAllBooking();
	}

	@GetMapping("/findbookingbyuserid/{id}")
	public ResponseEntity<ResponseStructure<Booking>> findBookingByUserId(@PathVariable int id) {
		return service.findBookingById(id);
	}

	@GetMapping("/findbookingbyclubid")
	public ResponseEntity<ResponseStructure<Booking>> findBookingByClubId(@RequestParam int id) {
		return service.findBookingById(id);
	}

}
