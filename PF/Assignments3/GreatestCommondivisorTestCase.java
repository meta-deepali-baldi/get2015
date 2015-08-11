/**
 *b) int gcd(int x, int y) where x > 0 and y > 0, to compute the greatest common divisor of x and y. 
 *Also, Write following JUnits cases
 *gcd(2, 1)
 *gcd(12, 18)
 *gcd(100, 3)
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
public class GreatestCommondivisorTestCase {
	GreatestCommonDivisor commonDivisor=new GreatestCommonDivisor();
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
	 * JUnits case for greatestCommonDivisor method
	 */
	@Test
	public void test() {
		int divisor=commonDivisor.greatestCommonDivisor(2,1);
		assertEquals("Correct",1,divisor);
	}

	/**
	 * JUnits case for greatestCommonDivisor method
	 */
	@Test
	public void test1() {
		int divisor=commonDivisor.greatestCommonDivisor(12,18);
		assertEquals("Correct",6,divisor);
	}
	
	/**
	 * JUnits case for greatestCommonDivisor method
	 */
	@Test
	public void test2() {
		int divisor=commonDivisor.greatestCommonDivisor(100,3);
		assertEquals("Correct",1,divisor);
	}
}
