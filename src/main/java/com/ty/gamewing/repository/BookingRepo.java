package com.ty.gamewing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.gamewing.dto.Booking;

public interface BookingRepo extends JpaRepository<Booking,Integer> {

}
