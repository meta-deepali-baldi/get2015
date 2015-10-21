package com.metacube.designpattern.implementfactorypattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * @author Deepali
 *
 */
public class Company extends Developer {

	private static Company company = new Company();
	private List<Developer> developerList = new ArrayList<Developer>();//List to store developer data

	
	/**
	 * private constructor:: can only be get by the getInstance method()
	 */
	private Company() {
	}
	
	/**
	 * Function to return instance of company
	 * @return instance of company
	 */
	public static Company getInstance() {
		return company;
	}

	/**
	 * Function to add developers
	 * 
	 * @param name
	 *            ---Name of the developer
	 * @param role
	 *            ---Role of the developer
	 */
	public void addDeveloper(String name, String role) {
		Developer developer = new Developer();
		developer.setName(name);
		developer.setRole(role);
		developerList.add(developer);//adding developer to the list

	}

	/**
	 * Function to display the list of developers using overloaded to string
	 * function
	 * 
	 */
	public String showListOfDeveloper() {
		if(developerList.size()>0){
		Iterator<Developer> iterator = developerList.iterator();
		System.out.println("List of Developer:");
		while (iterator.hasNext()) {
			System.out.println(iterator.next().toString());
		}
		return "";
		}
		return "No Developers in Company";
	}

}
