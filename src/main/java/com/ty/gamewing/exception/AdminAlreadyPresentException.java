package com.ty.gamewing.exception;

public class AdminAlreadyPresentException extends RuntimeException {

	@Override
	public String getMessage() {
		return "Admin already Exists";
	}

	
}
