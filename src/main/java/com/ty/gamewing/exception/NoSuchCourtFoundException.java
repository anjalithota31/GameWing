package com.ty.gamewing.exception;

public class NoSuchCourtFoundException extends RuntimeException {
	
	@Override
	public String getMessage() {
		return "No such court exists";
	}

}
