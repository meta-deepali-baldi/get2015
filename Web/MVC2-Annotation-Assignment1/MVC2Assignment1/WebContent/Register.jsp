<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="Model.Employee"%>
<%@ page import="Model.GenericTextModel"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%!String name = "", email = "";
	Date date = new Date();
	double age = 0;
	int id = 0;
	String submit = "Register";
	String action = "RegistrationController";%>
<html>
<head>
<link rel="stylesheet" href="style.css" type="text/css">
<title>Registeration Page3</title>
</head>
<body>
	<div class="header">
		<h1>
			<%
				List<GenericTextModel> list = (List<GenericTextModel>) request
						.getAttribute("list");
				for (GenericTextModel str : list) {
					out.print(str.getDisplayData());
					out.write("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
				}
			%>
		</h1>
		<a href="./LandingController?page=EmployeeRegistrationPage">Register</a>
		&nbsp; &nbsp; &nbsp; &nbsp; 
		<a href="./LandingController?page=EmployeeListPage">List
			of Employees</a>
	</div>

	<%
		if (request.getAttribute("employeeDetails") != null) {
			Employee employee = (Employee) request
					.getAttribute("employeeDetails");
			id = employee.getEmployeeId();
			name = employee.getName();
			email = employee.getEmail();
			age = employee.getAge();
			date = employee.getDateOfRegistration();
			submit = "Update";
			action = "UpdateDetailsController";
		}
	%>

	<div class="content">
		<form action=<%=action%> method="get">


			<table>

				<%
					if (request.getAttribute("employeeDetails") != null) {
				%>
				<tr>
					<td>Employee ID :</td>
					<td><input type='text' name="empid" required
						readonly="readonly" value="<%=id%>"></td>
				</tr>
				<%
					}
				%>

				<tr>
					<td>Name :</td>
					<td><input type="text" name="empname" required
						value="<%=name%>" /></td>
				</tr>
				<tr>
					<td>Email :</td>
					<td><input type="text" name="empemail" required
						value="<%=email%>" /></td>
				</tr>
				<tr>
					<td>Age :</td>
					<td><input type="text" name="empage" required
						value="<%=age%>" /></td>
				</tr>
				<tr>
					<td>Date :</td>
					<td><input type="text" name="empdate" required
						value="<%=date%>" /></td>
				</tr>
		
				<tr><td colspan="2"><div class="submit">
				<input type="submit" name="submit" value="<%=submit%>" /></div></td></tr>
				</table>

		</form>

	</div>
</body>
</html>
