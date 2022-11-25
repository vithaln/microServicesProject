package com.vitu.hotel.exception;

public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException() {
		super("SORRY!!..NOT FOUND ON SERVER..");
	}
	public ResourceNotFoundException(String message) {
		super(message);
	}

}
