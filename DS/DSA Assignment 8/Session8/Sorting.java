/**
 * Write a sorting system, which takes input from user and provide a sorted list. Here User could choose if he want to go with Comparison Sorting Or Linear Sorting.
Given Conditions: 
 1 - For comparison sorting system will use Bubble Sort or Quick Sort techniques (When less number of inputs (input elements <= 10) use Bubble Sort else Quicksort)
 2 - For linear sorting system will use Counting Sort or Radix Sort techniques (When large inputs(more than 2 digit) use Radix Sort else Counting Sort)
 
(System should be intelligent to pick suitable techniques for sort as per provided input )

Expected output : System has used XYZ sorting technique and sorted list as below :
				   n , n+1, ........... K -1, K


Note**: Write unit tests for both assignments
 */
package Session8;

/**
 * @author Deepali
 * 
 */
public class Sorting {

	public static void main(String[] args) {
		int choice;
		char mainChoice;

		MenuClass menuClass = new MenuClass();
		Utility utility = new Utility();
		SortingTechniques techniques = new SortingTechniques();
	
		do {
			//taking elements from user
			techniques.insertElements();
			//Menu
			menuClass.showMenuForSorting();
			//Taking choice
			choice = utility.checkingChoice();
			switch (choice) {
			case 1://for comparison sorting
				techniques.comparisonSorting();
				break;
			case 2://for linear sorting
				techniques.linearSorting();
				break;
			default:
				System.out.println("Enter correct choice");
				break;
			}
			mainChoice = utility.checkingString();
			techniques.getElements().clear();
		} while (mainChoice == 'Y');

	}

}
