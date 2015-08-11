/**3.
 *Write a recursive function to sort the given array in ascending order using quicksort.
 *Write JUnit Tests for above function.
 *Sort this array {2,5,8,9,10, 77, 55, 11}
 *Sort this array {} 
 */
package Assignments3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Deepali
 *
 */
public class QuickSortTestCase {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Testing for Sort Array
	 */

	@Test
	public void test1() {
		int[] arr = { 2, 5, 8, 9, 10, 77, 55, 11 };
		int[] arr1 = { 2, 5, 8, 9, 10, 11, 55, 77 };
		int temp[] = Quicksort.sortArray(arr, 0, 7);
		assertArrayEquals("correct", arr1, temp);
	}

	/**
	 * Testing for Sort Array
	 */

	@Test
	public void test2() {
		int[] arr = {};
		int[] arr1 = {};
		int temp[] = Quicksort.sortArray(arr, 0, 0);
		assertArrayEquals("correct", arr1, temp);
	}


}
