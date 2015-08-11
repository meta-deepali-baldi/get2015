/**3.
 *Write a recursive function to sort the given array in ascending order using quicksort.
 *Write JUnit Tests for above function.
 *Sort this array {2,5,8,9,10, 77, 55, 11}
 *Sort this array {} 
 */
package Assignments3;

import java.util.Scanner;

/**
 * @author Deepali
 * array :Denote an integer array to be sorted
 */
public class Quicksort {
private int array[];
	public static void main(String[] args) {
		int size,temp;
		int finalArr[];
		Quicksort quicksort=new Quicksort();
		Scanner sc = new Scanner(System.in);
		do {//Continues Looping
			System.out.println("Enter size of the array");
			size = sc.nextInt();
			quicksort.array = new int[size];
			System.out.println("Enter Elements of array");
			for (int i = 0; i < size; i++) {
				quicksort.array[i] = sc.nextInt();
			}
		
				finalArr= sortArray(quicksort.array, 0, size - 1);

				System.out.println("\nElements after sorting ");
				for (int i = 0; i < size; i++) {
					System.out.print(finalArr[i] + " ");
					System.out.println();

			System.out.println("Press 1 if you want to exit");
			System.out.println("Press 0 if you want to continue");
			temp = sc.nextInt();

		} while (temp != 1);
	}
	
/**
 * Function calls recursive sort array
 * 
 * @param arr
 *            -input array
 * @param low
 *            --lower index
 * @param high
 *            --higher index
 * @return--sorted array
 */
public static int[] sortArray(int arr[], int low, int high) {
	if ((low == 0) && (high == 0)) {// checking if elements are their in array or not
		return arr;
	} else
		quickSort(arr, low, high);//Recursive Function
	return arr;
}

/**
 * Function status-->dividing array into parts before mid value and after
 * mid value as before mid it contains smaller values than mid and after it
 * contains greater values.
 * 
 * @param arr
 *            --->input array
 * @param low
 *            --->lower bound
 * @param high
 *            --->upper bound
 * @return----->sorted array
 */
public static void quickSort(int arr[], int low, int high) {
	int i = low, j = high;
	int temp;
	int mid = arr[(low + high) / 2];
	int midptr = (low + high) / 2;

	while (i <= j) {
		while ((i < midptr) && (arr[i] < mid))
			i++;
		while ((j > midptr) && (arr[j] > mid))
			j--;
		if (i <= j) {

			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;

			i++;
			j--;
		}
	}
	if (low < j) {
		quickSort(arr, low, j);
	}

	if (i < high) {
		quickSort(arr, i, high);
	}
}
}
             
