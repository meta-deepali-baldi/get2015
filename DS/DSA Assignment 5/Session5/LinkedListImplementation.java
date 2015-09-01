/**
 *Write a program to implement the Queue functionality using the java collections.
 * Look for the best collection to meet this requirement. Provide some points justifying your collection choice. 
 */
package Session5;

import java.util.Scanner;

/**
 * @author deepali
 *
 */
public class LinkedListImplementation {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int choice = 0;
		char mainChoice = 0;
		String data;
		LinkedQueue queue=new LinkedQueue();
		LinkedListImplementation listImplementation=new LinkedListImplementation();
		do {
			// menu
			System.out.println("Enter 1 for Inserting element in Queue,"
					+ "\n2 for removing from queue"
					+ "\n3 for getting element at first position"
					+ "\n4 for displaying all elements from queue"
					+"\n5 for clearing queue"
					+"\n6 for getting size  of queue");
			choice = listImplementation.checkingInteger(choice);
			switch (choice) {
			case 1:
				System.out.println("Enter data to insert in queue");
				queue.enqueue(listImplementation.sc.next());
				System.out.println("Element inserted in queue");
				break;
			case 2:
				data=queue.dequeue();
				System.out.println("Element removed from queue is :"+data);

				break;
			case 3:
				data=queue.getFront();
				System.out.println("Element at front of queue is :"+data);
				break;
			case 4:
				queue.display();
				break;
			case 5:
				queue.makeEmpty();
				System.out.println("queue is now empty");
				break;
			case 6:
				System.out.println("Size of queue is: "+queue.getSize());
				break;
			default:
				System.out.println("enter rightvalues");

			}
			mainChoice = listImplementation.checkingString(mainChoice);
		} while (mainChoice == 'Y');
		listImplementation.sc.close();
	}

	/**
	 * checking input is integer or not
	 * 
	 * @param value
	 *            :value to get
	 * @return :an integer value
	 */
	public int checkingInteger(int value) {

		do {// Validation

			while (!sc.hasNextInt()) {
				System.out.println("That's not a number!Please enter again");
				sc.next(); // this is important!
			}
			value = sc.nextInt();
		} while (value <= 0);
		return value;
	}

	/**
	 * checking input is String or not
	 * 
	 * @param value
	 *            :value to get
	 * @return :return a char value
	 */
	public char checkingString(char value) {

		do {// validation
			System.out.println("Do you want to continue ?(Y/N)"); // continuing
			// the
			// procedure
			while (!sc.hasNext()) {
				System.out.println("That's not a character!");
				sc.next(); // this is important!

			}
			value = sc.next().toUpperCase().charAt(0);
			if (value == 'N')
				break;
		} while (value != 'Y');
		return value;
	}
}
