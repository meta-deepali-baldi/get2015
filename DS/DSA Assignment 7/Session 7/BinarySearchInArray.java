/**
 * Write a program the binary search function and its loop invariants in a way so that
 *  it will always find the leftmost occurrence of x in the array in case the occurrences are not unique
 *   (if it is actually in the array, −1 as before if it is not).
 *   Need to write unit test for the program
 */
package Session7;

import java.util.Scanner;

/**
 * @author Deepali
 *
 */
public class BinarySearchInArray {

	public static void main(String[] args) {
		int choice = 0;
		char mainChoice = 0;
		Utility utility = new Utility();
		BinarySearchOperations binarySearchOperation = new BinarySearchOperations();
		Scanner scanner = new Scanner(System.in);
		int valueToSearch = 0, indexOfElement = 0,leftIndex,rightIndex;
		int array[] = binarySearchOperation.insertElementsInArray();
	
		do {
			System.out.println("1 Enter element to search in array");
			System.out.println("2 Left Occurrence");
			System.out.println("3 Right Occurence");
			choice = utility.checkingInteger(choice);
			switch (choice) {
			case 1:
				System.out.println("Enter the element to be searched");
				valueToSearch = utility.checkingInteger(valueToSearch);
				indexOfElement = binarySearchOperation.binarySearch(valueToSearch, 0, array.length-1, array);
				if (indexOfElement == -1) {
					System.out.println("element does not exist");
					break;
				}
				break;
			case 2:
				leftIndex = binarySearchOperation.leftOccurrenceOfElement(valueToSearch, indexOfElement, array);
				System.out.println("left occurrence of " + valueToSearch + " is " + leftIndex);
				break;
			case 3:
				rightIndex = binarySearchOperation.rightOccurrenceOfElement(valueToSearch, indexOfElement, array);
				System.out.println("right occurrence of " + valueToSearch + " is "
						+ rightIndex);
				break;
			default:
				System.out.println("Enter correct choice");
				break;
			}
			mainChoice = utility.checkingString(mainChoice);
		} while (mainChoice == 'Y');
		scanner.close();
	}

}
