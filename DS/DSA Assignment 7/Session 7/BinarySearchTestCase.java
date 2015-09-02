/**
 * Write a program the binary search function and its loop invariants in a way so that
 *  it will always find the leftmost occurrence of x in the array in case the occurrences are not unique
 *   (if it is actually in the array, _1 as before if it is not).
 *   Need to write unit test for the program
 */
package Session7;

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
public class BinarySearchTestCase {
	BinarySearchOperations  binarySearchOperations=new BinarySearchOperations();
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
	 * Test Case For Left Occurence of Element 
	 */
	@Test
	public void testForSameAndLeftMost() {
		int a[] = { 1, 1, 1, 1, 1 };

		assertEquals(0, binarySearchOperations.leftOccurrenceOfElement(1,3,a));
	}
	
	/**
	 * Test Case For Right Occurence of Element 
	 */
	@Test
	public void testForSameAndRighttMost() {
		int a[] = { 1, 1, 1, 1, 1 };

		assertEquals(4, binarySearchOperations.rightOccurrenceOfElement(1,3,a));
	}

	/**
	 * Test Case For Left Occurence of Element 
	 */
	@Test
	public void testForDifferentAndLeftttMost() {
		int a[] = { 1, 2, 2, 3, 4 };

		assertEquals(1, binarySearchOperations.leftOccurrenceOfElement(2,2, a));
	}

	/**
	 * Test Case For Right Occurence of Element 
	 */
	@Test
	public void testForDifferentAndRighttMost() {
		int a[] = { 1, 2, 2, 3, 4 };

		assertEquals(2, binarySearchOperations.rightOccurrenceOfElement(2,2,a));
	}

	/**
	 * Test Case For Occurence of Element 
	 */
	@Test
	public void testForNotPresent() {
		int a[] = { 1, 2, 3, 4, 5 };

		assertEquals(-1, binarySearchOperations.binarySearch(9,0,4,a));
	}

}
