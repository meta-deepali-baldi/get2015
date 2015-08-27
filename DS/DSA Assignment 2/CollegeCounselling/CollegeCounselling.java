/**
 * Q2. WAP to implement the Queue in Java using Array.

The program should implement the following responsibility:

	a)void enqueue( item )  - Adding an Object item

	b)Object dequeue( ) -  Remove and return the least recent item inserted

	c)void makeEmpty( ) -  Remove all items of queue and make queue empty

	d)Object getFront( ) - Return least recently inserted item


Using the above Queue structure implement College counseling process. 

Create queue of all the candidates based on their respective ranks. Higher rank will be at the starting. 
Creating List of Colleges that will be available for admission. Take minimum 5 colleges as available, So each candidate will have option to select from 1 to 5 ranked colleges.  
Candidates will be called for counselling in the order based on created queue and the candidate can only opt for the seats available in the college at that time. Un Assigned will be processed in the later round. 

Note: Keep number of Candidates  should be higher than the total number of seats available.

Output: Finally display Candidates with assigned college. 
 *
 */
package CollegeCounselling;

import java.util.Scanner;
/**
 * @author Deepali
 *
 */
public class CollegeCounselling {

	// main function
	public static void main(String arg[]) {
		Scanner scanner = new Scanner(System.in);
		College college = new College();
		String name;
		int rank;
		int choice;
		int noOfStudents;
		System.out.println("enter total number of students");
		do {// Validation
			while (!scanner.hasNextInt()) {
				System.out.println("That's not a number!Please enter again");
				scanner.next(); // this is important!
			}
			noOfStudents = scanner.nextInt();
		} while (noOfStudents <= 0);

		Students students = new Students(noOfStudents);
		do {
			MenuClass.showBasicMenu();
			do {// Validation
				while (!scanner.hasNextInt()) {
					System.out
							.println("That's not a number!Please enter again");
					scanner.next(); // this is important!
				}
				choice = scanner.nextInt();
			} while (choice <= 0);

			switch (choice) {

			case 1:// to add students

				for (int i = 0; i < noOfStudents; i++) {
					System.out.println("enter name");
					name = scanner.next();
					System.out.println("enter rank");
					do {// Validation
						while (!scanner.hasNextInt()) {
							System.out
									.println("That's not a number!Please enter again");
							scanner.next(); // this is important!
						}
						rank = scanner.nextInt();
					} while (rank <= 0);

					students.enqueue(name, rank);
				}
				students.sortingByRank();
				break;

			case 2:// to print list of available colleges
				college.listOfCollegesWithAvailableSeats();
				break;

			case 3: // for allotment
				if (students.getFront().equals("noName")) {
					System.out.println("Please enter Details of student by choosing correct option");
					break;
				}
				for (int i = 0; i < noOfStudents; i++) {
					int check;
					name = students.getFront();
					if (college.getSeatsFulled() < 16) {
						do {
							college.selectCollege();
							System.out.println(name + "  enter your choice");
							do {// Validation
								while (!scanner.hasNextInt()) {
									System.out
											.println("That's not a number!Please enter again");
									scanner.next(); // this is important!
								}
								rank = scanner.nextInt();
								if(rank==1||rank==2||rank==3||rank==4||rank==5){
									break;
								}else {
									rank=-1;
								}
							} while (rank <= 0);

							check = college.allotToStudent(name, rank);
						} while (check != 1);
						name = students.dequeue();
						System.out.println(name + "  was alloted");
					}
					else {
						System.out.println("Seats full no vacancy");
						break;
					}
				}
				break;

			case 4:// to print list of students alloted to colleges
				college.printListOfNamesOfStudentsAlloted(students);
				break;

			case 5: // to empty lists
				students.makeEmpty();
				System.out.println("list cleared");
				break;

			default:
				System.out.println("invalid input");
				break;
			}
			do {// validation
				System.out.println("Do you want to continue(Y/N)"); // continuing
																	// the
																	// procedure
				while (!scanner.hasNext()) {
					System.out.println("That's not a character!");
					scanner.next(); // this is important!

				}
				choice = scanner.next().toUpperCase().charAt(0);
				if (choice == 'N')
					System.exit(0);
			} while (choice != 'Y');

		} while (choice == 'Y');

	}
}
