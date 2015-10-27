package com.metacube.webservices;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author Deepali
 *
 */

@WebService
public class TemperatureConvertor {
	/**
	 * Function to be accessed remotely
	 * 
	 * @param tempInFahrenheit
	 *            --value of temperature to be converted in celsius
	 * @return---temperature value in celsius
	 */
	@WebMethod
	public static double temperatureConvertor(double tempInFahrenheit) {
		return ((tempInFahrenheit * (9 / 5.0)) + 32);

	}

}
