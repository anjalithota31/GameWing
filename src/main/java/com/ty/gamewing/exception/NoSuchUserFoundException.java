package com.ty.gamewing.exception;

public class NoSuchUserFoundException extends RuntimeException {

	@Override
	public String getMessage() {
		return "No Such User Found";
	}

}
