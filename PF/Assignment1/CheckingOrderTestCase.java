package Assignments;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Deepali
 *Write a function to check given array is in sorted order or not. Function should return 1 if array is in ascending order, 2 if array is in descending order, 0 if array is not in sorted
 *Use this function and write a program to display appropriate message based on return value of above function.
 *Also write JUnit test cases which takes an integer array as input and assert return value.
 *Write Junit Test cases for all above 3 cases.
 */
public class CheckingOrderTestCase {

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
	 * Junit Test cases for Ascending order on checkingOrderOfArray Method
	 */
	@Test
	public void test() {
		int array1[]={1,2,2,2,3,3};
		int order=Assignment5.checkingOrderOfArray(array1);
	
		assertEquals("Ascending order",1,order);
	}
	

	/**
	 * Junit Test cases for Not sorted order on checkingOrderOfArray Method
	 */
	@Test
	public void test1() {
		int array1[]={1,4,6,3,7,8,9};
		int order=Assignment5.checkingOrderOfArray(array1);
	
		assertEquals("Not sorted",0,order);
	}
	

	/**
	 * Junit Test cases for Descending order on checkingOrderOfArray Method
	 */
	@Test
	public void test2() {
		int array1[]={9,6,4,2,0};
		int order=Assignment5.checkingOrderOfArray(array1);
	
		assertEquals("Descending order",2,order);
	}

}
