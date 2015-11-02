package com.metacube.facade;

import java.sql.Connection;
import java.util.List;

import com.metacube.db.helper.EmployeeDao;
import com.metacube.exception.EmployeeSystemException;
import com.metacube.model.Employee;

/**
 * @author Deepali
 * 
 */
public class EmployeeFacade {

	/**Using dao class to create Database And Employee Table
	 * @param connection :connection
	 */
	public void createDatabaseAndEmployeeTable(Connection connection) {
		//Database and Employee Table created
		EmployeeDao employeeDao=new EmployeeDao(connection);
		//inserting dummy data
		employeeDao.insertIntoTableDefaultEmployee(connection);
	}


	/**Using dao class to getList of employee
	 * @param connection :connection
	 * @return list of employee
	 * @throws EmployeeSystemException 
	 */
	public List<Employee> gettingListOfEmployee(Connection connection) throws EmployeeSystemException {
		//using employee database
		EmployeeDao.useEmployeeDetailsDatabase(connection);
		// getting list of all employee
		return EmployeeDao.getEmployeeList(connection);
	}
	
	/**Using dao class to  get list of employee based on id
	 * @param connection :connection
	 * @param id:employee id
	 * @return :employee
	 * @throws EmployeeSystemException 
	 */
	public Employee gettingEmployeeBasedOnId(Connection connection,
			int id) throws EmployeeSystemException {
		//using employee database
		EmployeeDao.useEmployeeDetailsDatabase(connection);
		// getting employee based on id
		return EmployeeDao.getEmployeeById(id, connection);
	}


}
