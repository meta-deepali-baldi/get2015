/**
 *c) int largestdigit(int x) where x >= 0,  to find out the largest digit in the number x.
 *Also, Write following JUnits cases:
 *largestdigit(2)
 *largestdigit(1257369)
 *largestdigit(444)
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
public class LargestDigitOfNumberTestCase {
	LargestDigitOfNumber largestDigitOfNumber=new LargestDigitOfNumber(); 
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
	 * JUnits case for largestDigit method
	 */
	@Test
	public void test() {
		int digit=largestDigitOfNumber.largestDigit(2);
		assertEquals("Correct",2,digit);
	}
	
	/**
	 * JUnits case for largestDigit method
	 */
	@Test
	public void test1() {
		int digit=largestDigitOfNumber.largestDigit(1257369);
		assertEquals("Correct",9,digit);
	}
	
	/**
	 * JUnits case for largestDigit method
	 */
	@Test
	public void test2() {
		int digit=largestDigitOfNumber.largestDigit(444);
		assertEquals("Correct",4,digit);
	}
}
