package com.ty.gamewing.exception;

import com.ty.gamewing.dto.Court;

public class NoSuchClubInTheCourtException extends RuntimeException {
	
	@Override
	public String getMessage() {
		
		return "NO such club in the court";
	}

}
