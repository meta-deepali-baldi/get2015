package com.metacube.exception;

/**
 * @author Deepali
 *
 */
public class EmployeeSystemException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * @param message :message of exception
	 */
	public EmployeeSystemException(String message) {
		super(message);
	}

	/**
	 * @param message :message
	 * @param cause :cause of exception
	 */
	public EmployeeSystemException(String message, Throwable cause) {
		super(message, cause);
	}
}
