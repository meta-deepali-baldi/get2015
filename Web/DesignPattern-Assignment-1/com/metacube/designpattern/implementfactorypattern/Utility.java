package com.metacube.designpattern.implementfactorypattern;

import java.util.Scanner;

/**
 * @author Deepali
 *
 */
public class Utility {
	private static Scanner scanner = new Scanner(System.in);

	/**
	 * checking input is integer or not
	 * 
	 * @param value :value to get
	 * @return :an integer value
	 */
	public static int checkingChoice() {
		int value;
		do {// Validation
			System.out.println("Enter correct choice");
			while (!scanner.hasNextInt()) {
				System.out.println("That's not a number!Please enter again");
				scanner.next(); // this is important!
			}
			value = scanner.nextInt();
		} while (value < 0);
		return value;
	}

	/**
	 * checking input is String or not
	 * 
	 * @param value :value to get
	 * @return :return a char value
	 */
	public static char checkingString() {
		char value;
		do {// validation
			System.out.println("Do you want to continue ?(Y/N)"); // continuing
			// the
			// procedure
			while (!scanner.hasNext()) {
				System.out.println("That's not a character!");
				scanner.next(); // this is important!

			}
			value = scanner.next().toUpperCase().charAt(0);
			if (value == 'N')
				break;
		} while (value != 'Y');
		return value;
	}
	
}
