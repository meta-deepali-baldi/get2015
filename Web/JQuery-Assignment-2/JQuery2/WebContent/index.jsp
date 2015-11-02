<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "java.util.*,com.metacube.model.*;"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Employee Detail</title>
		<script type = "text/javascript" src = "js/jquery-1.11.3.js"></script>
		<script type = "text/javascript" src = "js/script.js"></script>
		<link rel="stylesheet" type="text/css" href="css/style.css">
	</head>
	<body>
		<div class="main">
			<select name = "employeeName" id = "employeeName">
				<option value="" disabled selected >-- Select Name --</option>
				<%
					if(request.getAttribute("employeeList") == null) {
						RequestDispatcher requestDispatcher =request.getRequestDispatcher("detail");
						requestDispatcher.forward(request, response);
					}
					List<Employee> employeeList = (List<Employee>)(request.getAttribute("employeeList"));
					for(Employee employee:employeeList) {
				%>
					<option value="<%=employee.getEmployeeId() %>"> <%=employee.getName()%> </option>
				<%
					}
				%>
			</select> 
			</div>
			<div id = "demo">
			</div>
	</body>
</html>