package Session8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Deepali
 * 
 */
public class SortingTechniques {
	private List<Integer> listOfElements = new ArrayList<Integer>(); //Elements List 
	
	/**
	 * @return the elements
	 */
	public List<Integer> getElements() {
		return listOfElements;
	}

	/**
	 * @param elements the elements to set
	 */
	public void setElements(List<Integer> elements) {
		this.listOfElements = elements;
	}

	/**
	 * To insert Elements in List
	 */
	public void insertElements() {

		Utility utility = new Utility();
		System.out.println("Insert Number of elements");
		int numberOfElements = utility.checkingInteger();
		System.out.println("Insert elements");
		for (int i = 0; i < numberOfElements; i++) {
			listOfElements.add(utility.checkingInteger());
		}

	}

	/**
	 *For Comparison Sorting 
	 */
	public void comparisonSorting() {
		if (listOfElements.size() <= 10) { //bubble sort
			bubbleSorting();
		} else { //quick sort
			quickSort();
		}
	}

	/**
	 *For Linear Sorting 
	 */
	public void linearSorting() {
		if (noOfDigits() <= 2 ) {//counting sort
			countingSort();
		} else { //radix sort
			radixSort();
		}
	}

	/**
	 * For Bubble Sorting
	 */
	private void bubbleSorting() {
		for (int i = 0; i < (listOfElements.size() - 1); i++) {
			for (int j = 0; j < listOfElements.size() - i - 1; j++) {
				if (listOfElements.get(j) > listOfElements.get(j + 1)) /*For descending order use */
				{
					swap(j, j + 1);
				}
			}
		}
		displayElements();
	}

	/**
	 * For Quick Sorting
	 */
	public void quickSort(){
		quickSort(0, listOfElements.size() - 1); 
		displayElements();
	}

	/**For Quick Sorting
	 * @param low :Starting index
	 * @param high :Size of List
	 */
	private void quickSort(int low, int high) {
		int i = low; // index for left-to-right scan
		int k = high; // index for right-to-left scan

		
		if (high - low >= 1) {
			int pivot = listOfElements.get(low); // set the pivot as the first element in the partition

			while (k > i) {
				while (listOfElements.get(i) <= pivot && i <= high && k > i)
					// from the left, look element greater than the pivot
					i++; 
				while (listOfElements.get(k) > pivot && k >= low && k >= i){
					// from the right, look element not greater than the pivot
					k--; 
				}
				if (k > i) {// if the left index is smaller than the right index, swap Elements 
					swap(i, k);
				}
			}
			swap(low, k); // after the index have crossed, swap the element with the pivot
			quickSort(low, k - 1); // sorting on left partition
			quickSort(k + 1, high); // sorting on right partition
		
		} else {//if only one element in list
			return; 
		}
	}

	/**Swapping two values
	 * @param index1 :first value index
	 * @param index2 :Second Value index
	 */
	private void swap(int index1, int index2) {
		int temp = listOfElements.get(index1); // store the first value in a temp
		
		listOfElements.set(index1, listOfElements.get(index2)); // copy the value of second into the first
		
		listOfElements.set(index2, temp); // copy the value of the temp into the second
	}

	/**
	 * For Counting Sort
	 */
	private void countingSort() {
		int index;
		List<Integer> elementByIndex = new ArrayList<Integer>(); //List for storing no of element by index
		int large=largestElement();       //large value from list
		for (int i = 0; i <=large ; i++) {  //setting initial value
			elementByIndex.add(0);
		}

		for (int i = 0; i < listOfElements.size(); i++) { //counting for elements by index
			index = elementByIndex.get(listOfElements.get(i)); 
			elementByIndex.set(listOfElements.get(i), index + 1);
		}
		listOfElements.clear(); //clearing list for storing sorted elements
		int limit;
		for (int i = 0; i <= large; i++) {
			limit = elementByIndex.get(i);//No of times index to be stored
			for (int j = 0; j < limit; j++) {

				listOfElements.add(i);
			}
		}
		displayElements(); //display elements
	}

	/** To get Largest Element
	 * @return :Largest Element from list
	 */
	private int largestElement() {
	
		Iterator<Integer> elementIterator = listOfElements.iterator();
	
		int max =listOfElements.get(0);
		int element;
		while (elementIterator.hasNext()) {
			element = elementIterator.next();
			if (element > max) {
				max = element;
			}
		}
		return max;
	}

	/** No of Digit of Largest Element 
	 * @return No of digits
	 */
	private int noOfDigits() {
		
		int max = largestElement();
		int noOfDigit = 0;
		while (max > 0) {
			max = max / 10;
			noOfDigit++;
		}
		return noOfDigit;
	}

	/**To get digit by place
	 * @param element :Element whose digit we have to get
	 * @param temp :which place digit need
	 * @return :digit of element
	 */
	private int getIndex(int element, int temp) {
		int index = 0;
		for (int i = 0; i <= temp; i++) {
			index = element % 10;
			element = element / 10;
		}
		return index;
	}

	/**
	 * For Radix Sorting
	 */
	private void radixSort() {
		List<LinkedList<Integer>> elementByIndex = new ArrayList<LinkedList<Integer>>();
		int digit = noOfDigits(), element;
		for (int i = 0; i < digit; i++) {// loop for places as unit and tens place of element
			
			for (int j = 0; j <= 9; j++) {//bucket creating from 0-9 digit
				LinkedList<Integer> linkedlist = new LinkedList<Integer>();
				elementByIndex.add(linkedlist);//adding bucket
			}
			Iterator<Integer> elementIterator = listOfElements.iterator();
			while (elementIterator.hasNext()) {
				element = elementIterator.next();
				elementByIndex.get(getIndex(element, i)).addLast(element);//adding element in bucket basis of digit
			}

			listOfElements.clear();//clear list for storing sorted list of elements
			Iterator<LinkedList<Integer>> linkedlist = elementByIndex
					.iterator();
			while (linkedlist.hasNext()) {
				Iterator<Integer> iteratorElement = linkedlist.next()
						.iterator();
				while (iteratorElement.hasNext()) {
					listOfElements.add(iteratorElement.next());//adding sorted elements
				}
			}
			elementByIndex.clear(); //clearing bucket
		}
		displayElements();//displaying elements
	}

	private void displayElements() {
	
		System.out.println("Sorted List is :");
		Iterator<Integer> elementIterator = listOfElements.iterator();
		while (elementIterator.hasNext()) {
			System.out.print(elementIterator.next() + "   ");
		}
		System.out.println();
	}
}
