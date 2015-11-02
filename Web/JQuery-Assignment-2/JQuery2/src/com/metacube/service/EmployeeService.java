package com.metacube.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.metacube.db.ConnectionFactory;
import com.metacube.facade.EmployeeFacade;
import com.metacube.model.Employee;

/**
 * @author Deepali
 * 
 */
public class EmployeeService {

	/**
	 * Using facade class to create storage for Employee details
	 */
	public void createStorageForEmployee() {
		Connection connection = null;
		EmployeeFacade facade=new EmployeeFacade();
		try {
			//getting connection
			connection = ConnectionFactory.getConnection();
			//creating storage of Employee
			facade.createDatabaseAndEmployeeTable(connection);
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.out.println("Could not roleback.");
			}
		} finally {//finally close connection
			ConnectionFactory.closeConnection(connection);
		}

	}

	/**Using facade class to get list of employee
	 * @return :list of employee
	 */
	public List<Employee> getListOfEmployee() {
		List<Employee> employeeList = null;
		Connection connection = null;
		EmployeeFacade facade=new EmployeeFacade();
		try {
			//getting connection
			connection = ConnectionFactory.getConnection();
			//getting list of employee
			employeeList = facade.gettingListOfEmployee(connection);
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.out.println("Could not roleback.");
			}
		} finally {//finally close connection
			ConnectionFactory.closeConnection(connection);
		}
		return employeeList;

	}

	/**Using facade class to get employee based on id
	 * @param employeeId: employee id
	 * @return: employee
	 */
	public Employee getEmployeeById(int employeeId) {
		Employee employee= null;
		Connection connection = null;
		EmployeeFacade facade=new EmployeeFacade();
		try {
			//getting connection
			connection = ConnectionFactory.getConnection();
			//get employee based on id
			employee=facade.gettingEmployeeBasedOnId(connection, employeeId);
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.out.println("Could not roleback.");
			}
		} finally {//to close connection
			ConnectionFactory.closeConnection(connection);
		}
		return employee;
	}
}
