package com.ty.gamewing.exception;

public class NoClubPresentException extends  RuntimeException{
	
	@Override
	public String getMessage() {
		
		return "No Club exists";
	}

}
