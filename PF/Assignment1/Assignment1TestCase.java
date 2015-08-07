package Assignments;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * @author Deepali
 *
 *Write a function (int convertBinaryToOctal(int n) )to convert binary numbers to octal eg.

	      Input:

Binary Number: 110101

	     Output:

Octal Number:  65

Also write JUnit test cases which takes above input and assert octal number.
 */

public class Assignment1TestCase {
	ConvertBinaryToOctal c1=new ConvertBinaryToOctal();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		//nothing to set
	}

	@After
	public void tearDown() throws Exception {
	//nothing to tear
	}

	
	/**
	 * JUnit test cases which takes above input and assert octal number for ConvertBinaryToOctal function
	 */
	@Test
	public void test() {
		
		int octal=c1.convertBinaryToOctal(11011);
		assertEquals("correct",33,octal);
	}
	
	/**
	 * JUnit test cases which takes above input and assert octal number for ConvertBinaryToOctal function
	 */
	@Test
	public void test1() {
		int octal=c1.convertBinaryToOctal(110101);
		assertEquals("correct",65,octal);
	}
	
	/**
	 * JUnit test cases which takes above input and assert octal number for ConvertBinaryToOctal function
	 */
	@Test
	public void test2() {
		int octal=c1.convertBinaryToOctal(110);
		assertEquals("correct",6,octal);
	}
}
