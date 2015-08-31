/**
 * By using Heap data structure techniques write a program to handle the jobs sent to the admin department's printer: Jobs sent by the department chair should be printed first, then jobs sent by professors, then those sent by graduate students, and finally those sent by undergraduates. The job put into as per the priority of the sender (e.g., using 4 for the chair, 3 for professors, 2 for grad students, and 1 for undergrads), and the associated information would be the document to print. Each time the printer is free, the job with the highest priority would be removed from the print queue, and printed. (Note there could be multiple jobs with the same)  
 
 Following operations must be satisfied by program:
 
 1. create an empty priority queue for JOB
 2. Insertion of new JOB
 3. Print the job based on priority
 */
package PrinterRequestManagement;

import java.util.Scanner;

/**
 * @author Deepali
 *
 */
public class Admin {

	public static void main(String[] args) {
		int choice = 0;
		char mainChoice = 0;

		Scanner sc = new Scanner(System.in);
		Printer printer = new Printer();
		do {
			// menu
			System.out.println("Enter 1 for inserting new job to printer,"
					+ "\n2 for Printing Jobs Based on Priority");
			choice = printer.checkingInteger(choice);
			switch (choice) {
			case 1:
				printer.insertingNewJobs();

				break;
			case 2:
				printer.printJobsBasedOnPriority();

				break;
			default:
				System.out.println("enter rightvalues");

			}
			mainChoice = printer.checkingString(mainChoice);

		} while (mainChoice == 'Y');
		sc.close();
	}

}
