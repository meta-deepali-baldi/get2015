/**
 * Write a program to print disorderly provided role numbers of n students in  ascending series using tree sort?
 */
package Session8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Deepali
 *
 */

public class TreeSorting {
	
	public static void main(String args[]) {
		int choice;
		char mainChoice;
		int element;
		Scanner scan = new Scanner(System.in);
		MenuClass menuClass=new MenuClass();
		Utility utility=new Utility();
		List<Integer> rollList =new ArrayList<Integer>(); //to check duplicacy of elements
		BinaryTreeTraversal tree = new BinaryTreeTraversal();
		do {
			menuClass.showMenuForTreeSorting();
			choice=utility.checkingInteger();
			switch (choice) {
			case 1:// To input an element
				System.out.println("Insert an element");
				element=utility.checkingInteger();
				if(!rollList.contains(element)){
				rollList.add(element);
				tree.insert(element);
				}else {
					System.out.println("Roll No. already exist");
				}
				break;

			case 2://To print in ascending order roll number of students
				System.out.println("Roll No in Ascending Order "+tree.printRollNumberInAscendingOrder());
				break;

			default:
				System.out.println("Enter correct choice");
				break;
			}
			mainChoice=utility.checkingString();
		} while (mainChoice == 'Y');
		scan.close();
	}
}
