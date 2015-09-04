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

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Deepali
 *
 */
public class SortingTestCase {
	private SortingTechniques techniques = new SortingTechniques();
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test case for Bubble Sorting
	 */
	@Test
	public void testForBubbleSort() {
		techniques.getElements().add(45);
		techniques.getElements().add(0);
		techniques.getElements().add(4);
		techniques.getElements().add(987);
		techniques.getElements().add(34);
		int arr[]={0,4,34,45,987};
		int i=0;
		techniques.comparisonSorting();
		Iterator<Integer> elementIterator = techniques.getElements().iterator();
		while (elementIterator.hasNext()) {
			assertEquals(arr[i] ,(int)elementIterator.next());
			i++;
		}
	}
	/**
	 * Test Case for Quick Sorting
	 */
	@Test
	public void testForQuickSort() {
		techniques.getElements().add(45);
		techniques.getElements().add(0);
		techniques.getElements().add(4);
		techniques.getElements().add(98);
		techniques.getElements().add(40);
		techniques.getElements().add(17);
		techniques.getElements().add(56);
		techniques.getElements().add(0);
		techniques.getElements().add(234);
		techniques.getElements().add(22);
		
		int arr[]={0,0,4,17,22,40,45,56,98,234};
		int i=0;
		techniques.comparisonSorting();
		Iterator<Integer> elementIterator = techniques.getElements().iterator();
		while (elementIterator.hasNext()) {
			assertEquals(arr[i] ,(int)elementIterator.next());
			i++;
		}
	}

	/**
	 * Test case for Counting sort
	 */
	@Test
	public void testForCountingSort() {
		techniques.getElements().add(45);
		techniques.getElements().add(0);
		techniques.getElements().add(4);
		techniques.getElements().add(98);
		techniques.getElements().add(34);
		int arr[]={0,4,34,45,98};
		int i=0;
		techniques.linearSorting();
		Iterator<Integer> elementIterator = techniques.getElements().iterator();
		while (elementIterator.hasNext()) {
			assertEquals(arr[i] ,(int)elementIterator.next());
			i++;
		}
	}

	/**
	 * Test case for Radix sort
	 */
	@Test
	public void testForRadixSort() {
		techniques.getElements().add(45);
		techniques.getElements().add(0);
		techniques.getElements().add(4);
		techniques.getElements().add(98);
		techniques.getElements().add(40);
		techniques.getElements().add(17);
		techniques.getElements().add(56);
		techniques.getElements().add(0);
		techniques.getElements().add(234);
		techniques.getElements().add(22);
		
		int arr[]={0,0,4,17,22,40,45,56,98,234};
		int i=0;
		techniques.linearSorting();
		Iterator<Integer> elementIterator = techniques.getElements().iterator();
		while (elementIterator.hasNext()) {
			assertEquals(arr[i] ,(int)elementIterator.next());
			i++;
		}
	}
	


}
