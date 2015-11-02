package com.metacube.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metacube.model.Employee;
import com.metacube.service.EmployeeService;

/**
 * Servlet implementation class EmployeeDetail
 */
@WebServlet("/detail")
public class EmployeeDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		EmployeeService service = new EmployeeService();
		service.createStorageForEmployee();
		request.setAttribute("employeeList", service.getListOfEmployee());
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("index.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		EmployeeService service = new EmployeeService();
		int id = Integer.parseInt(request.getParameter("id"));
		Employee employee = service.getEmployeeById(id);
		String detail = "Name : " + employee.getName() + "<br/>Email : "
				+ employee.getEmail() + "<br/>Date Of Birth : "
				+ employee.getDateOfBirth() + "<br/>Address : "
				+ employee.getAddress();
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(detail);
	}

}
