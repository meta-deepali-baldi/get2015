/**
 * 
 */
package com.metacube.controller;

/**
 * @author Deepali
 *
 */
public class ApplicationLogger {
	static org.apache.log4j.Logger log = org.apache.log4j.Logger
			.getLogger(ApplicationLogger.class.getName());

	public static void log(String logString) {

		
			log.info(logString);
		
	}

	public static void DebugLog(String logString) {

	
			log.debug(logString);
		
	}
}
