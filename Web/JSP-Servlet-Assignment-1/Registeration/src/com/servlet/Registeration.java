package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
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
		response.setContentType("text/html");
		pw.println("This is Registeration page.<br>");

		if (request.getParameter("first_name")=="") {
			flag = false;
			pw.println("First Name not Filled<br>");
		}
		if (request.getParameter("last_name")=="") {
			flag = false;
			pw.println("Last name not Filled<br>");
		}
		if (request.getParameter("gender").equals("-Select One-")) {
			flag = false;
			pw.println("Gender is not selected<br>");
		}
		if (request.getParameter("dob")=="") {
			flag = false;
			pw.println("Date of Birth Not Selected<br>");
		}
		if (request.getParameter("country").equals("-Select One-")) {
			flag = false;
			pw.println("country is not selected<br>");
		}
		if (request.getParameter("email")=="") {
			flag = false;
			pw.println("Email not specified<br>");
		}
		if (request.getParameter("pwd")=="") {
			flag = false;
			pw.println("Password not specified<br>");
		}
		if(request.getParameter("pwd").length() < 8 )
		{
			pw.println("Password Length should be greater than 8 <br>");
		     flag=false;
		}
		if (request.getParameter("cpwd")=="") {
			flag = false;
			pw.println("Reenter password not specified<br>");
		}
		if(request.getParameter("cpwd").length() < 8 )
		{
			pw.println("Reenter Password Length should be greater than 8 <br>");
		     flag=false;
		}
		if (!request.getParameter("pwd").equals(request.getParameter("cpwd"))) {
			flag = false;
			pw.println("Password and Reentered Password does not match<br>");
		}
		if (request.getParameter("questionFirst").equals("-Select One-")) {
			flag = false;
			pw.println("First Question is not Selected<br>");
		}
		if (request.getParameter("answerFirst")=="") {
			flag = false;
			pw.println("Answer of first Question not specified<br>");
		}
		
		if (request.getParameter("questionSecond").equals("-Select One-")) {
			flag = false;
			pw.println("Second Question is not Selected<br>");
		}
		if (request.getParameter("answerSecond")=="") {
			flag = false;
			pw.println("Answer of first Question not specified<br>");
		}
		
		if (flag == true) {
			pw.println("Form is validated at server side<br>");

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
