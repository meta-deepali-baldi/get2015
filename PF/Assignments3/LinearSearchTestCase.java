/**
 * @author Deepali
 *Write recursive functions for the following:
 *a) to search for a given value x in an array using linear search strategy.
 *Write JUnit Tests:
 *take an array having {2,5,8,9,10, 77, 55}, and search 88
 *take an array having {2,5,8,9,10, 77, 55, 11}, and search 77
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
public class LinearSearchTestCase {
	LinearSearch linearSearch = new LinearSearch();
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
		int result=linearSearch.linearSearchInArray(array,88);
		assertEquals("Correct",0,result);
	}

	/**
	 * JUnits case for linearSearchInArray method
	 */
	@Test
	public void test1() {
		int array[]= {2,5,8,9,10, 77, 55, 11};
		int result=linearSearch.linearSearchInArray(array,77);
		assertEquals("Correct",1,result);
	}

}
