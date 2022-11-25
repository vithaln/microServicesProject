package com.code.vithal.exception;

public class ResourcenotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourcenotFoundException() {
		super("Resource not found on server");
	}
	
	public ResourcenotFoundException(String message) {
		super(message);
	}
}
