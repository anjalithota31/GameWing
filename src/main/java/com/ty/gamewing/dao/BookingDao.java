package com.ty.gamewing.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.gamewing.dto.Booking;
import com.ty.gamewing.repository.BookingRepo;

@Repository
public class BookingDao {
	@Autowired
	private BookingRepo repo;

	public Booking saveBooking(Booking booking) {
		return repo.save(booking);
	}

	public Booking updateBooking(Booking booking) {
		return repo.save(booking);
	}

	public boolean deleteBooking(int id) {
		repo.deleteById(id);
		return true;
	}

	public Booking findBookingById(int id) {
		Optional<Booking> optional = repo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	public List<Booking> findAllBooking() {
		return repo.findAll();
	}

	public List<Booking> findBookingByCourtId(int id) {
		return repo.findByCourtId(id);
	}

	public List<Booking> findBookingByUserId(int id) {
		return repo.findBookingByUserId(id);
	}
}
