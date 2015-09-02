package Session7;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Deepali
 *
 */
public class BinarySearchOperations {

	/** Recursive Binary Search In array
	 * @param element :element to search
	 * @param startIndex :Starting Index of Array
	 * @param endIndex :End Index of array
	 * @param array :Array where element to be searched
	 * @return :returns index of array if found else -1
	 */
	public int binarySearch(int element, int startIndex, int endIndex, int array[]) {
		int midValue;
		//Loop invariant :
		//1 :startValue is always less than endValue
		//2 : If array[mid]==key then return mid
		while (startIndex <= endIndex) {
			
			midValue = (startIndex + endIndex) / 2;
			if (element == array[midValue]) {//if found at mid index
				System.out.println("Number Found at ");
				return midValue; // Returning position of number found
			} else if (element > array[midValue]) {	//If element is in Left sub array
				return (binarySearch(element, midValue + 1, endIndex, array));
			} else { //If element is in right sub array
				return (binarySearch(element, startIndex, midValue - 1, array));
			}
		}
		return -1;
	}

	/** To find Left Occurrence of element.
	 * @param element :element to search
	 * @param leftIndex :index of array
	 * @param array :Array where element to be searched
	 * @return :Left occurrence of element
	 */
	public int leftOccurrenceOfElement(int element, int leftIndex, int array[]) {
		//Loop invariant :
		//1 :leftIndex should always be greater than zero
		while (leftIndex > 0 && array[leftIndex - 1] == element) {
			leftIndex--;
		}
			
		return leftIndex;
	}

	/** To find Right Occurrence of element
	 * @param element :element to search
	 * @param rightIndex :index of array
	 * @param array :Array where element to be searched
	 * @return :right occurrence of element
	 */
	public int rightOccurrenceOfElement(int element, int rightIndex, int array[]) {
		//Loop invariant :
		//1 :rightIndex should always be less than array size
		while (rightIndex < array.length-1 && array[rightIndex + 1] == element) {
			rightIndex++;
		}
	
		return rightIndex;
	}

	/**Inserting  Elements in array
	 * @return array
	 */
	public int[] insertElementsInArray() {
		int noOfElements;
		Scanner scanner = new Scanner(System.in);
		int array[] = new int[10];
		System.out.println("Enter the number of elements");
		noOfElements = scanner.nextInt();
		//Loop invariant :
		//1 : i should be less than noOfElements
		for (int i = 0; i < noOfElements; i++) {
			array[i] = scanner.nextInt();
		}
		Arrays.sort(array);
		return array;
	}
}
