package com.metacube;

import java.util.Scanner;

import com.metacube.webservices.TemperatureConvertor;
import com.metacube.webservices.TemperatureConvertorServiceLocator;

/**
 * @author Deepali
 *
 */
public class WSClient {
	public static void main(String[] args) {
		// locating the web service by creating the object of service locator
		// and connecting it to the wsdl file of web service
		TemperatureConvertorServiceLocator CTCWebServiceImplServiceLocator = new TemperatureConvertorServiceLocator();
		CTCWebServiceImplServiceLocator
				.setTemperatureConvertorEndpointAddress("http://localhost:8081/SOAPWebServiceAssignment/services/TemperatureConvertor");

		try {
			// creating the object of web service class by the locator and
			// accessing it
			TemperatureConvertor calcCTCWebService = CTCWebServiceImplServiceLocator
					.getTemperatureConvertor();
			System.out.println("Enter Temperature in Fahrenheit");
			Scanner scanner = new Scanner(System.in);
			double value = scanner.nextDouble();
			System.out.println("Temperature in Celsius :"+calcCTCWebService.temperatureConvertor(value));
			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
