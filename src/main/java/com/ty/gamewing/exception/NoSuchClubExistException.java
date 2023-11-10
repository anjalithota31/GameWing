package com.ty.gamewing.exception;

public class NoSuchClubExistException extends  RuntimeException{

	@Override
	public String getMessage() {
		
		return "No Such Club exists";
	}
	
}
