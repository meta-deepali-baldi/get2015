/**
 *Assignment 2: Write an application to create a Company and its

employees(Developers) without exposing their public constructors.

 Implement Classes(Factory Pattern) like:

Company ­>Developer 

class Developer{

string Name    {get;set;}

string Role        {get;set;}}

class Company extend Developer  {

public static List<Developer> getDevelopers(){}

}
 */
package com.metacube.designpattern.implementfactorypattern;

import java.util.Scanner;

/**
 * @author Deepali
 * 
 */
public class FactoryMain {

	public static void main(String[] args) {
		String name;
		String role;
		int choice;
		char mainChoice;
		// getting instance of company
		Company company = Company.getInstance();
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("1 : To add Developer");
			System.out.println("2 : To print Developer List");
			choice = Utility.checkingChoice();
			switch (choice) {
			case 1:
				// adding data in list
				System.out.println("Enter name of Developer :");
				name = scanner.next();
				System.out.println("Enter role of Developer");
				role = scanner.next();
				company.addDeveloper(name, role);
				break;
			case 2:
				// showing list of developer
				System.out.println(company.showListOfDeveloper());
				break;
			default:
				System.out.println("Enter correct choice");
				break;
			}

			mainChoice = Utility.checkingString();
		} while (mainChoice == 'Y');

		scanner.close();
	}

}
