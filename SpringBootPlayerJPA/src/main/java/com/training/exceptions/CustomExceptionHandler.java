package com.training.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(RecordNotFoundException.class)
	public  final ResponseEntity<Object> handleRecordNotFoundException(Exception exception,
			WebRequest request){
		ExceptionResponse eResponse=new ExceptionResponse(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<Object>(eResponse,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(BuissnesException.class)
	public  final ResponseEntity<Object> handleBuissnesException(Exception exception,
			WebRequest request){
		ExceptionResponse eResponse=new ExceptionResponse(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<Object>(eResponse,HttpStatus.NOT_ACCEPTABLE);
		
	}
}
