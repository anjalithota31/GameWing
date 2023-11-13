package com.ty.gamewing.exception;

public class NoCourtsPresentException extends Exception {
	@Override
	public String getMessage() {
		return "NO courts present ";
	}

}
