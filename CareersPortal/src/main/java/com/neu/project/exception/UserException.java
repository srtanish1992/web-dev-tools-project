package com.neu.project.exception;

public class UserException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3489309772582417796L;

	public UserException(String message) {
		super("UserException-" + message);
	}

	public UserException(String message, Throwable cause) {
		super("UserException-" + message, cause);
	}

}
