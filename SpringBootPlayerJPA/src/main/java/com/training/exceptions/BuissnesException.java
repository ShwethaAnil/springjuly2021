package com.training.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_ACCEPTABLE)
public class BuissnesException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BuissnesException(String message) {
		super(message);
	}

}
