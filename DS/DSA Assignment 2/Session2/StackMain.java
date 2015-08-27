/**
 *Q1: WAP to implement a Stack using a linked list that will contain push and pop operations.

Write a function to convert Infix notation to Postfix using the above implemented stack.
 */
package Session2;

import java.util.Scanner;

/**
 * @author Deepali
 *
 */
public class StackMain {

	public static void main(String[] args) {
		StackLinkList stacklist = new StackLinkList();
		StackLinkList list = new StackLinkList();// for infix
		Scanner sc = new Scanner(System.in);
		char mainChoice;
		do {
			MenuClass.showBasicMenu();
			int choice;

			do {// Validation

				while (!sc.hasNextInt()) {
					System.out
							.println("That's not a number!Please enter again");
					sc.next(); // this is important!
				}
				choice = sc.nextInt();
			} while (choice <= 0);
			switch (choice) {
			case 1:
				String string;
				System.out.println("enter a no to add");
				string = sc.next();
				StackLinkList.push(string);
				break;
			case 2:
				stacklist.pop();
				break;
			case 3:
				stacklist.display();
				break;
			case 4:
				System.out.println("Enter Expression");
				String postfix = list.convertFromInfixToPostfix(sc.next());
				System.out.println("postfix is" + postfix);
				break;
			default:
				System.out.println("enter rightvalues");

			}
			do {// validation
				System.out.println("Do you want to continue(Y/N)"); // continuing
																	// the
																	// procedure
				while (!sc.hasNext()) {
					System.out.println("That's not a character!");
					sc.next(); // this is important!

				}
				mainChoice = sc.next().toUpperCase().charAt(0);
				if (mainChoice == 'N')
					System.exit(0);
			} while (mainChoice != 'Y');

		} while (mainChoice == 'Y');
		sc.close();

	}

}
