package Assignments;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * @author Deepali
 * 	     1
       1 2 1
     1 2 3 2 1
   1 2 3 4 3 2 1
 1 2 3 4 5 4 3 2 1
   1 2 3 4 3 2 1
	 1 2 3 2 1
	   1 2 1
		 1

Write a program to display above pyramid using modular approach. 
Divide whole problem in 3 parts as per describe in the presentation.
1. spaces(row, n): return the spaces string
2. numbers(row, n): return the number string
3. print whole pyramid : It will return the array of string by using above 2 functions.
Also write JUnit test cases for each modules.
 */
public class Assignments21TestCase {
	Assignment21 a1= new Assignment21();
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
	 * JUnit test case for spaces(row, n): return the spaces string
	 */
	@Test
	public void test1() {
		
		String s1=a1.spaces(4,5);
		assertEquals("Correct"," ",s1);
	}
	
	/**
	 * JUnit test case for numbers(row, n): return the number string
	 */
	@Test
	public void test2() {
		
			String s1=a1.number(4,5);
			assertEquals("Correct","1234321",s1);
	}
	
	/**
	 * JUnit test case for printWholePyramid : It will return the array of string by using above 2 functions
	 */
	@Test
	public void test3() {
		String expected[]={"    1","   121","  12321"," 1234321","123454321"," 1234321","  12321","   121","    1"};
		String s1[]=a1.printWholePyramid(5);
		for(int i=0;i<9;i++){
			assertEquals("Correct",expected[i],s1[i]);
		}
}
}
