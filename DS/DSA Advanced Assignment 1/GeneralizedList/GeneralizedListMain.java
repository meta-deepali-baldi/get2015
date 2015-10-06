/**
 *Question 1. Generalized (Nested) Lists 

Implement generalized list collection in Java. An element of a generalized list can itself be a generalized list. Here is an example of a generalized list-

(5, (8, 3), (6, (10, 12), 4), 7)

The above list consists of four elements, the first and last elements are numbers, whereas second and third elements are themselves lists. 

You can assume that the atomic elements of the list are integers.

Implement the following methods for this collection:

a) Constructor to create an empty list.
b) Constructor that will take a string representing a generalized list; and will create the list accordingly. For example we can provide “(5, (8, 3), (6, (10, 12), 4), 7)” as an argument to the constructor.
c) Method toString() that will return a string representing the generalized list.
d) Method sum() that will return the sum of all the elements in the list
e) Method max() that will return the largest value in the list
f) Method find(x) that will search for x in the list; and return true if x is present in the list and false otherwise.
 *
 */
package GeneralizedList;

import java.util.Scanner;

/**
 * @author Deepali
 *
 */
public class GeneralizedListMain { 
	
	public static void main(String[] args) {
		System.out.println("Enter expression \n");
		Scanner scan = new Scanner(System.in);
		String inputList = scan.next();
		int choice;
		char mainChoice;
		//validating expression
		while (Validation.isExpression(inputList) != true) {
			System.out.println("Enter Valid Expression");

			inputList = scan.next();
		}
		GeneralizedList generalizedList = new GeneralizedList(inputList);
		

		do {// Menu
			MenuClass.menuForGeneralizedList();
			choice = Validation.checkingChoice();

			switch (choice) {
			case 1:// to display list
				System.out.println(generalizedList);
				break;
			case 2:
				// sum of list
				System.out.println("Sum of list is : " + generalizedList.calculateSum());

				break;
			case 3:
				// Maximum from expression
				System.out.println("Maximum Element from list :" + generalizedList.calculateMax());
				break;
			case 4:
				//Searching value from expression
				System.out.println("Enter value to search \n");

				System.out.println("Value Found :"
						+ generalizedList.searchValue(Validation.checkingChoice()));
				break;

			default:
				System.out.println("Enter Correct Choice");
			}
			mainChoice = Validation.checkingString();
		} while (mainChoice == 'Y');
		scan.close();

	}

}
