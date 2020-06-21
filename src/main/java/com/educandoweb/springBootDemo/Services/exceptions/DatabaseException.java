package com.educandoweb.springBootDemo.services.exceptions;

public class DatabaseException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public DatabaseException(String msg) {
		super("The requested ID could not be deleted");
	}
	

}
