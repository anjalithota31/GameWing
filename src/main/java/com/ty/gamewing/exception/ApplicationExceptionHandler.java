package com.ty.gamewing.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ty.gamewing.entity.ResponseStructure;

@ControllerAdvice
public class ApplicationExceptionHandler {
	@ExceptionHandler(NoSuchClubExistException.class)
	public ResponseEntity<ResponseStructure<String>> IdNotPresentException(NoSuchClubExistException exception) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setData(exception.getMessage());
		responseStructure.setMessage("Failed");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(NoSuchCourtFoundException.class)
	public ResponseEntity<ResponseStructure<String>> courtNotFound(NoSuchCourtFoundException exception) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setData(exception.getMessage());
		responseStructure.setMessage("Failed");
		responseStructure.setStatusCode(HttpStatus.NO_CONTENT.value());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NO_CONTENT);
	}

	@ExceptionHandler(NoSuchClubInTheCourtException.class)
	public ResponseEntity<ResponseStructure<String>> catchNoSuchClubExistException(NoSuchClubInTheCourtException exception) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setData(exception.getMessage());
		responseStructure.setMessage("Failed");
		responseStructure.setStatusCode(HttpStatus.NO_CONTENT.value());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NO_CONTENT);
	}

}
