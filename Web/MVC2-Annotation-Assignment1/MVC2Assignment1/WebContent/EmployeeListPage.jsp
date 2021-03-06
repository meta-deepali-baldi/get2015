<%@page import="Model.Employee"%>
<%@page import="java.util.List"%>
<%@page import="java.util.concurrent.ConcurrentHashMap"%>
<%@page import="java.util.Map"%>
<%@page import="Model.GenericTextModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css" type="text/css">
<title>Employee List Page</title>
</head>

<body>
	<div class="header">
		<h1>Metacube Software Pvt. Ltd.</h1>
		<a href="./LandingController?page=EmployeeRegistrationPage">Register</a>
		&nbsp; &nbsp; &nbsp; &nbsp; 
		<a href="./LandingController?page=EmployeeListPage">List
			of Employees</a>
	</div>
	<div class="main">
		<h1>
			<%
				List<GenericTextModel> list1 = (List<GenericTextModel>) request
						.getAttribute("list");
				for (GenericTextModel str : list1) {
					out.print(str.getDisplayData());
					out.write("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
				}
			%>
			
		</h1>
<table border="1">
		<%
			List<Employee> list = (List<Employee>) request
					.getAttribute("employeeList");

			out.print("<tr><td>Employee Id</td><td>Name</td><td>Email</td><td>View</td><td>Edit</td></tr> ");
			for (Employee str : list) {
				out.print("<tr><td>"+str.getEmployeeId() + "</td><td> " + str.getName() + " </td><td> "
						+ str.getEmail()+"</td>");
				out.write("<td><a href='./ViewDetailsController?id="
						+ str.getEmployeeId() + "'> View details</a></td>");
				out.write("<td><a href='./EditDetailsController?id="
						+ str.getEmployeeId() + "'> Edit details </a></td>");
				out.write("</tr>");
			}
		%>
		</table>
	</div>
</body>

</html>