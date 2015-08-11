/**
 * Write recursive functions for the following
 *Write recursive functions for the following:
 *a) to search for a given value x in an array using linear search strategy.
 *Write JUnit Tests:
 *take an array having {2,5,8,9,10, 77, 55}, and search 88
 *take an array having {2,5,8,9,10, 77, 55, 11}, and search 77
 */
package Assignments3;

import java.util.Scanner;

/**
 * @author Deepali
 */
public class LinearSearch {
	private int index = 0;

	public static void main(String[] args) {
		int array[];
		int size, result, number, temp;

		LinearSearch linearSearch = new LinearSearch();
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Enter size of the array");
			size = sc.nextInt();
			array = new int[size];
			System.out.println("Enter Elements of array");
			for (int i = 0; i < size; i++) {
				array[i] = sc.nextInt();
			}
			System.out.println("Enter number to be searched in array");
			number = sc.nextInt();

			if (size > 0) {// checking if elements are their in array or not
				result = linearSearch.linearSearchInArray(array, number);
				if (result == 0)
					System.out.println("Number " + number
							+ " not found in array");
				else
					System.out.println("Number " + number
							+ " found in array at position "
							+ (linearSearch.index + 1));
			} else
				System.out.println("Enter Correct value");

			System.out.println("Press 1 if you want to exit");
			System.out.println("Press 0 if you want to continue");
			temp = sc.nextInt();

		} while (temp != 1);
	}

	/**
	 * Recursion function to search an element in array
	 * @param a: array where number to be searched
	 * @param index: contain index for array next recursion
	 * @param number: which is to be searched in array
	 * @return : if element found or not
	 */
	public int linearSearchInArray(int a[], int number) {
		int temp;
		if (index < a.length) {
			if (a[index] == number)
				return 1;
			else {
				index++;
				return (linearSearchInArray(a, number));
			}
		} else
			return 0;
	}
}
