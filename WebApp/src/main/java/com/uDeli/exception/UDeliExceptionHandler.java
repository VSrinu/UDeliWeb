package com.uDeli.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UDeliExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<UDeliErrorResponse> handleException(UserNotFoundException ex)
	{		
		UDeliErrorResponse response = new UDeliErrorResponse();
		response.setStatus(HttpStatus.NOT_FOUND.value());
		response.setMessage(ex.getMessage());
		response.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<UDeliErrorResponse> handleException(Exception ex)
	{		
		UDeliErrorResponse response = new UDeliErrorResponse();
		response.setStatus(HttpStatus.BAD_REQUEST.value());
		response.setMessage("Bad Request");
		response.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	}
}
