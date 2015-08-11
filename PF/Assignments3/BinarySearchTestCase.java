/**Write recursive functions for the following
 *b) to search for a given value x in an array using binary search strategy.
Write JUnit Tests for each function:
take an array having {2,5,8,9,10, 55, 77}, and search 88
take an array having {2,5,8,9,10, 55, 77}, and search 77
 *
 */
package Assignments3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BinarySearchTestCase {
	BinarySearchInArray binarySearchInArray = new BinarySearchInArray();
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
	 * JUnits case for linearSearchInArray method
	 */
	@Test
	public void test() {
		int array[]= {2,5,8,9,10,77,55};
		int result=binarySearchInArray.binarySearch(array,0,array.length-1,88);
		assertEquals("Correct",7,result);
	}

	/**
	 * JUnits case for linearSearchInArray method
	 */
	@Test
	public void test1() {
		int array[]= {2,5,8,9,10, 55, 77};
		int result=binarySearchInArray.binarySearch(array,0,array.length-1,77);
		assertEquals("Correct",7,result);
	}

}
