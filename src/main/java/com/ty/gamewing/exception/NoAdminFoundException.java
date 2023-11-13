package com.ty.gamewing.exception;

public class NoAdminFoundException extends RuntimeException {

	@Override
	public String getMessage() {
		return "No Admin Exists";
	}

}
