/**
 * Assignment 2: Apply Inheritance concepts
Implement Person and Student class as discussed in session and write appropriate unit test for testing them.
 */
package Assignment5;

import java.util.Scanner;

/**
 * @author Deepali
 * 
 */

public class InheritanceMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// Person Information

		System.out.println("Enter name of person");
		String personName = sc.next();
		System.out.println("Enter id of Person");
		int personId = sc.nextInt();

		// Student Information
		System.out.println("Enter id of Student");
		int studentId = sc.nextInt();
		System.out.println("Enter no. of Courses of Student");
		int noOfCourses = sc.nextInt();
		System.out.println("Enter Courses of Student");
		String studentCourses[] = new String[noOfCourses];
		for (int i = 0; i < noOfCourses; i++) {
			studentCourses[i] = sc.next();
		}
		Student student = new Student(personId, personName, studentId);// Setting
																		// Values
		student.setCources(studentCourses);// Setting Courses

		// Displaying Information
		System.out.println("Information :");
		System.out.println(student);
		System.out.println("Courses Of Student :");
		String studentGetCourses[] = student.getCourses();
		for (int i = 0; i < noOfCourses; i++) {
			System.out.println(studentGetCourses[i]);
		}
		sc.close();
	}

}
