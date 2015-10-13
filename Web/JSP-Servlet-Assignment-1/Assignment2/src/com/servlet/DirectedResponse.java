/**
Write a web application that:
Contains a user registration information form that requests a 	servlet.
Contains a servlet that accepts the request sent by client, validates the form data and dispatches the validation result to the other servlet and that servlet displays the validation result.


Note: The registration form can be the form created in previous assignment and the information sent must be validated on the server side.
 */

package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Deepali
 * 
 * Servlet implementation class Registeration
 */

@WebServlet("/DirectedResponse")
public class DirectedResponse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println(request.getAttribute("result"));
	}

	
}
