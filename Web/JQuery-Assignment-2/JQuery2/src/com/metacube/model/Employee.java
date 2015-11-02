package com.metacube.model;

/**
 * @author Deepali
 *
 */
public class Employee {
	private int employeeId;//employee id
	private String name;//name of employee
	private String email;//email of employee
	private String dateOfBirth;//date of birth of employee
	private String Address;//address of employee

	
	/**
	 * @param employeeId:employee id
	 * @param name:name of employee
	 * @param email: email of employee
	 * @param dateOfBirth :date of birth of employee
	 * @param address :address of employee
	 */
	public Employee(int employeeId, String name, String email,
			String dateOfBirth, String address) {
		this.employeeId = employeeId;
		this.name = name;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		Address = address;
	}
	
	/**
	 * @return the employeeId
	 */
	public int getEmployeeId() {
		return employeeId;
	}

	

	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	

	/**
	 * @return the dateOfBirth
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return Address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		Address = address;
	}

}
