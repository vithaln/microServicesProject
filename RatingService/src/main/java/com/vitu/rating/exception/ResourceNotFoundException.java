package com.vitu.rating.exception;
public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException() {
		super("RATINGS NOT FOUND BUDDY...");
		
	}

	public ResourceNotFoundException(String message) {
		super(message);
	}
}
