/**
 * Assignment 1:  Write a Logger class (Singleton) to log application exceptions in Log file.
 */

package com.metacube.designpattern.createlogfilebysingletonclass;

/**
 * @author Deepali
 * 
 */
public class LoggersMain {

	public static void main(String[] args) {
		// getting instance
		Loggers logger = Loggers.getInstance();
		// calling Loggers class function using that instance
		logger.createExceptionAndStoringInLogFile();

	}

}
