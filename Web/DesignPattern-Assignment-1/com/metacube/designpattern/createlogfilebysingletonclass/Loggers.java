package com.metacube.designpattern.createlogfilebysingletonclass;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * @author Deepali
 * 
 */
public class Loggers {
	private static Loggers instance;

	/*
	 * A private Constructor prevents any other class from instantiating.
	 */
	private Loggers() {
	}

	/**
	 * @return :return instance of loggers class
	 */
	public static Loggers getInstance() {
		if (instance == null) {// To synchronize more than one threads
			synchronized (Loggers.class) {
				if (instance == null) {
					System.out
							.println("getInstance(): First time getInstance was invoked!");
					instance = new Loggers();
				}
			}
		}

		return instance;
	}

	/**
	 * Function to create exception and storing it in a log file
	 */
	protected void createExceptionAndStoringInLogFile() {

		Logger logger = Logger.getLogger("MyLog");

		// The FileHandler write to a specified file
		FileHandler fileHandler;

		try {

			// This block configure the logger with handler and formatter
			fileHandler = new FileHandler("MyLogFile.log");
			// Add a log Handler to receive logging messages.
			logger.addHandler(fileHandler);

			// Print a brief summary of the LogRecord in a human readable
			// format.
			SimpleFormatter formatter = new SimpleFormatter();
			fileHandler.setFormatter(formatter);
			int value = 5 / 0;

		} catch (ArithmeticException e) {
			logger.info(" ArithmeticException in LoggerFile::full stack trace follows:"
					+ e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
