package com.metacube.db.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.metacube.exception.EmployeeSystemException;
import com.metacube.model.Employee;

/**
 * @author Deepali
 *
 */
public class EmployeeDao {
	private static String CREATE_EMPLOYEE_QUERY,
			CREATE_EMPLOYEE_DATABASE_QUERY, USE_EMPLOYEE_DATABASE_QUERY,
			GET_EMPLOYEE_LIST_QUERY, GET_EMPLOYEE_BY_ID_QUERY,
			INSERT_EMPLOYEE_QUERY;

	static {
		CREATE_EMPLOYEE_DATABASE_QUERY = "CREATE DATABASE employee_details";
		USE_EMPLOYEE_DATABASE_QUERY = "USE employee_details;";
		CREATE_EMPLOYEE_QUERY = "create table employee(employeeId int auto_increment primary key "
				+ ",name varchar(30),"
				+ "email varchar(100),"
				+ "date_of_birth Date," + "address varchar(200))";
		GET_EMPLOYEE_LIST_QUERY = "SELECT * FROM employee";
		GET_EMPLOYEE_BY_ID_QUERY = "SELECT * FROM employee where employeeId = ?";
		INSERT_EMPLOYEE_QUERY = "insert into employee values(?,?,?,?,?)";
	}

	/**
	 * Constructor creating database and table
	 */
	public EmployeeDao(Connection connection) {
		Statement statement = null;
		try {
			statement = connection.createStatement();
			// Creating database and creating table employee
			statement.execute(CREATE_EMPLOYEE_DATABASE_QUERY);
			// Use query For employee detail Database
			useEmployeeDetailsDatabase(connection);
			// create employee table
			statement.execute(CREATE_EMPLOYEE_QUERY);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @param connection
	 */
	public static void useEmployeeDetailsDatabase(Connection connection) {
		Statement statement = null;
		try {
			statement = connection.createStatement();
			// use query for employee detail database
			statement.execute(USE_EMPLOYEE_DATABASE_QUERY);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Inserting dummy data in Employee table
	 * 
	 * @param connection
	 *            :connection
	 */
	public void insertIntoTableDefaultEmployee(Connection connection) {
		if (connection != null) {
			insertIntoEmployeeTable(new Employee(1, "Deepali", "db@gmail.com",
					"1993-11-28", "Neemuch"), connection);
			insertIntoEmployeeTable(new Employee(2, "Arushi", "ar@gmail.com",
					"1993-10-22", "Jaipur"), connection);
			insertIntoEmployeeTable(new Employee(3, "Anshika", "a@gmail.com",
					"1993-04-24", "Bhilwara"), connection);
			insertIntoEmployeeTable(new Employee(4, "Priyamvada",
					"p@gmail.com", "1993-05-10", "Udaipur"), connection);
			insertIntoEmployeeTable(new Employee(5, "Sumitra", "s@gmail.com",
					"1993-09-06", "chittor"), connection);

		} else {
			System.out.println("Connection Error");
		}
	}

	/**
	 * Insert data in employee table
	 * 
	 * @param employee
	 *            :employee to insert
	 * @param connection
	 *            :connection
	 * @return :1 if employee inserted else -1
	 */
	private static int insertIntoEmployeeTable(Employee employee,
			Connection connection) {

		PreparedStatement preparedStatement = null;

		try {
			// inserting user into user table
			preparedStatement = connection
					.prepareStatement(INSERT_EMPLOYEE_QUERY);
			preparedStatement.setInt(1, employee.getEmployeeId());
			preparedStatement.setString(2, employee.getName());
			preparedStatement.setString(3, employee.getEmail());
			preparedStatement.setString(4, employee.getDateOfBirth());
			preparedStatement.setString(5, employee.getAddress());
			return preparedStatement.executeUpdate();

		} catch (SQLException e) {
			return -1;
		}
	}

	/**
	 * To get employee list
	 * 
	 * @param connection
	 *            :connection
	 * @return :list of employee
	 * @throws EmployeeSystemException
	 */
	public static List<Employee> getEmployeeList(Connection connection)
			throws EmployeeSystemException {
		Statement statement = null;
		ResultSet resultSet = null;
		List<Employee> employeeList = new ArrayList<Employee>();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(GET_EMPLOYEE_LIST_QUERY);
			while (resultSet.next()) {//getting employees

				employeeList.add(new Employee(resultSet.getInt(1), resultSet
						.getString(2), resultSet.getString(3), resultSet
						.getString(4), resultSet.getString(5)));
			}
		} catch (SQLException e) {
			throw new EmployeeSystemException(
					"Exception while getting list of Employees: "
							+ e.getMessage());
		}
		return employeeList;
	}

	/**
	 * To get employee based on id
	 * 
	 * @param id
	 *            :id if employee
	 * @param connection
	 *            :connection
	 * @return :employee of this id
	 * @throws EmployeeSystemException
	 */
	public static Employee getEmployeeById(int id, Connection connection)
			throws EmployeeSystemException {
		Employee employee = null;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection
					.prepareStatement(GET_EMPLOYEE_BY_ID_QUERY);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {//getting employee by id
				employee = new Employee(resultSet.getInt(1),
						resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getString(5));
			}
		} catch (SQLException e) {
			throw new EmployeeSystemException(
					"Exception while getting Employee Description "
							+ e.getMessage());
		}
		return employee;
	}

}
