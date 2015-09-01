package Session5;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * @author Deepali
 *
 */
public class SortedListOperation {
	private int index=0; //Starting index
	private Scanner scan = new Scanner(System.in);

	/**Recursive function to insert element in sorted list
	 * @param element :element to insert
	 * @param list :list in which element to be added
	 */
	public void insert(int element, List<Integer> list) {
		if (index == list.size()) { //if index reached till end of list then add directly at end of list
			list.add(element);
			index=0;
		} else if ((int) list.get(index) < element) {//searching exact position of element in list
			index=index+1;
			insert(element, list);
		} else { //position found then add element
			list.add(index, element);
			index=0;
		}

	}

	/**To display Elements of Linked List
	 * @param list :Linked list of elements
	 */
	public void display(List<Integer> list) {
		Iterator<Integer> iterator = list.iterator();
		System.out.println("Elements are :");
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

	/**
	 * checking input is integer or not
	 * @param value :value to get
	 * @return :an integer value
	 */
	public int checkingInteger(int value) {

		do {// Validation

			while (!scan.hasNextInt()) {
				System.out.println("That's not a number!Please enter again");
				scan.next(); // this is important!
			}
			value = scan.nextInt();
		} while (value <= 0);
		return value;
	}

	/**
	 * checking input is String or not
	 * @param value :value to get
	 * @return :return a char value
	 */
	public char checkingString(char value) {

		do {// validation
			System.out.println("Do you want to continue ?(Y/N)"); // continuing
			// the
			// procedure
			while (!scan.hasNext()) {
				System.out.println("That's not a character!");
				scan.next(); // this is important!

			}
			value = scan.next().toUpperCase().charAt(0);
			if (value == 'N')
				break;
		} while (value != 'Y');
		return value;
	}
}
