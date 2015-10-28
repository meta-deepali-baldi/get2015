/**
 * Case Study- Assignments
Phase 4
Duration (Number of Hrs)

Assignment 1: Implement CarSales website as designed in prototype in phase 3. 
Implement all the use cases as designed in phase 3.
Follow the MVC-2 on front end for implementing the jsp and servlet. 
Use annotations in the Servlet. 
Implement the validations in javascript as well as in servlet for create/edit car.
Follow the complete coding standards for the assignment, like class names, variable names, etc.
Code should be modular and extensible by implementing smaller methods and separate classes for various purpose.

Create Car Use case
Edit Car Use case
Search Car based on certain features as defined in use case
Login for administrator
Create/Edit only for administrator
 */


package com.metacube.carportal.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metacube.carportal.db.helper.CarPortalDao;
import com.metacube.carportal.model.Car;
import com.metacube.carportal.service.ConnectionForServlet;
import com.metacube.carportal.service.Validation;

/**
 * @author Deepali Servlet implementation class EditCar
 */
@WebServlet("/edit-car")
public class EditCar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		
		//Validation on Car details
		String message=Validation.validationOnCarDetails(request.getParameter("make"), request.getParameter("model"), request.getParameter("engineInCC"), request.getParameter("fuelCapacity"), request.getParameter("milage"), request.getParameter("price"),"abc");
		                                                                                                                               
		if (message.charAt(0)=='1') {
			// redirecting the response to Edit page for showing error
			response.sendRedirect("EditCar.jsp?message="
					+ URLEncoder.encode(message.substring(1), "UTF-8"));
		} else {
			Connection connection=ConnectionForServlet.getConnectionForServlet();
			// getting car detail in table for this make and model
			List<Car> car = CarPortalDao.selectCarBasedOnMakeAndModel(
					connection, (String) request.getParameter("make"),
					(String) request.getParameter("model"));
			//setting updated value
			car.get(0).setEngineInCC(
					Double.parseDouble((String) request
							.getParameter("engineInCC")));
			car.get(0).setFuelCapacity(
					Double.parseDouble((String) request
							.getParameter("fuelCapacity")));
			car.get(0)
					.setMilage(
							Double.parseDouble((String) request
									.getParameter("milage")));
			car.get(0).setPrice(
					Double.parseDouble((String) request.getParameter("price")));
			car.get(0).setOnRoadPrice();
			//updating car details
			int update = CarPortalDao.updateCarDetails(connection, car.get(0));

			if (update == -1) {//if not updated
				request.setAttribute("message", "Car not inserted");
				//redirected to edit car page again
				RequestDispatcher rd = request
						.getRequestDispatcher("/editCar.jsp");
				rd.forward(request, response);
			} else {
				//redirected to home page of admin if successfully updated
				request.setAttribute("username",
						session.getAttribute("username"));
				RequestDispatcher rd = request.getRequestDispatcher("/admin-home");
				rd.forward(request, response);
			}
		}

	}

}
