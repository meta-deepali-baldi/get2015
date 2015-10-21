package com.metacube.designpattern.implementfactorypattern;

/**
 * @author Deepali
 *
 */
public class Developer {

	String name;
	String role;
	

	/**
	 * Protected Constructor
	 */
	protected Developer() {

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
	 * @return the role
	 */
	public String getRole() {
		return role;
	}


	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Name : " + name + "\nRole : " + role + "\n";
	}

}
