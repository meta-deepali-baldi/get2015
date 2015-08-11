/**
 *1. 
 *Write recursive functions for the following:
 *int rem(int x, int y) where x >=0 and y > 0, to compute the remainder of x divided by y.
 *Also, Write following JUnits cases:
 *rem(2, 1)
 *rem(2, 0)
 *rem(100, 3)
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
 */
public class RemainderTestCase {
ComputeRemainder computeRemainder= new ComputeRemainder();

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
	 * JUnits case for computeRemainder method
	 */
	@Test
	public void test() {
		int remainder=computeRemainder.rem(2, 1);
		assertEquals("Correct",0,remainder);
	}
	
	/**
	 * JUnits case for computeRemainder method
	 */
	@Test
	public void test1() {
		int remainder=computeRemainder.rem(2, 0);
		assertEquals("False",0,remainder);
	}
	
	/**
	 * JUnits case for computeRemainder method
	 */
	@Test
	public void test2() {
		int remainder=computeRemainder.rem(100, 3);
		assertEquals("Correct",1,remainder);
	}

}
