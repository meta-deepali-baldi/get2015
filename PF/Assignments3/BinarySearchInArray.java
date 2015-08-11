/**Write recursive functions for the following
 *b) to search for a given value x in an array using binary search strategy.
Write JUnit Tests for each function:
take an array having {2,5,8,9,10, 55, 77}, and search 88
take an array having {2,5,8,9,10, 55, 77}, and search 77
 *
 */
package Assignments3;

import java.util.Scanner;

/**
 * @author Deepali
 */
public class BinarySearchInArray {
	//private int index = 0;

	/**
	 * array :In which element is to be searched
	 * size: length of the array
	 * number: Number which we want to search
	 */
	public static void main(String[] args) {
		int array[];
		int size, result, number, temp;

		BinarySearchInArray binarySearchInArray = new BinarySearchInArray();
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
				result = binarySearchInArray.binarySearch(array,0,array.length-1, number);
				if (result >size-1)
					System.out.println("Number " + number
							+ " not found in array");
				else
					System.out.println("Number " + number
							+ " found in array at position "
							+  (result+1));
			} else
				System.out.println("Enter Correct value");

			System.out.println("Press 1 if you want to exit");
			System.out.println("Press 0 if you want to continue");
			temp = sc.nextInt();

		} while (temp != 1);

	}

	/**
	 * @param array : receives array where element is to be searched
	 * @param startIndex : start index of array
	 * @param endIndex : end index of array
	 * @param number : which is to be searched
	 * @return : returns index of element
	 */
	public int binarySearch(int array[],int startIndex,int endIndex, int number) {
		if(startIndex < endIndex){
			int mid=(startIndex+endIndex)/2;
		
			if(number==array[mid]){
				return mid;
			}
			else if(number<array[mid])
			{
				startIndex=0;
				endIndex=mid-1;
				return(binarySearch(array,startIndex,endIndex,number));
			}
			else {
				startIndex=mid+1;
				endIndex=array.length-1;
				return(binarySearch(array,startIndex,endIndex,number));
			}
		}
		else 
			return array.length ;
	}
}
