package com.ty.gamewing.exception;

public class NoSuchBookingFoundException extends RuntimeException {

	@Override
	public String getMessage() {
		return "No Such Booking Found";
	}

}
