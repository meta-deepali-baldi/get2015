/**
Write a web application that:
Contains a user registration information form that requests a 	servlet.
Contains a servlet that accepts the request sent by client, validates the form data and dispatches the validation result to the other servlet and that servlet displays the validation result.


Note: The registration form can be the form created in previous assignment and the information sent must be validated on the server side.
 */

package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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
@WebServlet("/Registeration")
public class Registeration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		boolean flag = true;
		String result = "";
		response.setContentType("text/html");
		pw.println("This is Registeration page.<br>");

		if (request.getParameter("first_name") == "") {
			flag = false;
			result += "First Name not Filled<br>";
		}
		if (request.getParameter("last_name") == "") {
			flag = false;
			result += "Last name not Filled<br>";
		}
		if (request.getParameter("gender").equals("-Select One-")) {
			flag = false;
			result += "Gender is not selected<br>";
		}
		if (request.getParameter("dob") == "") {
			flag = false;
			result += "Date of Birth Not Selected<br>";
		}
		if (request.getParameter("country").equals("-Select One-")) {
			flag = false;
			result += "country is not selected<br>";
		}
		if (request.getParameter("email") == "") {
			flag = false;
			result += "Email not specified<br>";
		}
		if (request.getParameter("pwd") == "") {
			flag = false;
			result += "Password not specified<br>";
		}
		if (request.getParameter("pwd").length() < 8) {
			result += "Password Length should be greater than 8 <br>";
			flag = false;
		}
		if (request.getParameter("cpwd") == "") {
			flag = false;
			result += "Reenter password not specified<br>";
		}
		if (request.getParameter("cpwd").length() < 8) {
			result += "Reenter Password Length should be greater than 8 <br>";
			flag = false;
		}
		if (!request.getParameter("pwd").equals(request.getParameter("cpwd"))) {
			flag = false;
			result += "Password and Reentered Password does not match<br>";
		}
		if (request.getParameter("questionFirst").equals("-Select One-")) {
			flag = false;
			result += "First Question is not Selected<br>";
		}
		if (request.getParameter("answerFirst") == "") {
			flag = false;
			result += "Answer of first Question not specified<br>";
		}

		if (request.getParameter("questionSecond").equals("-Select One-")) {
			flag = false;
			result += "Second Question is not Selected<br>";
		}
		if (request.getParameter("answerSecond") == "") {
			flag = false;
			result += "Answer of first Question not specified<br>";
		}

		if (flag == true) {
			result += "Form is validated at server side<br>";

		}

		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("DirectedResponse");
		rd.forward(request, response);

	}

}
