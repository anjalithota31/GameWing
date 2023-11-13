package com.ty.gamewing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.gamewing.dto.Booking;

public interface BookingRepo extends JpaRepository<Booking, Integer> {

	@Query("SELECT c.bookings from Court c where c.id=?1")
	public List<Booking> findByCourtId(int id);

	@Query("SELECT b from Booking b where b.user.id=?1")
	public List<Booking> findBookingByUserId(int id);
}
