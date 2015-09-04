/**
 * Write a program to print disorderly provided role numbers of n students in  ascending series using tree sort?
 */

package Session8;

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
public class BinaryTreeTestCase {
	private BinaryTreeTraversal tree = new BinaryTreeTraversal();
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
	 * Test Case for ascending order of roll numbers
	 */
	@Test
	public void test() {
		
		tree.insert(1);
		tree.insert(1);
		tree.insert(1);
		tree.insert(1);
		tree.insert(1);
		tree.insert(1);
		tree.insert(1);
		
		assertEquals("   1",tree.printRollNumberInAscendingOrder());
		
		
	}
	

	/**
	 * Test Case for ascending order of roll numbers
	 */
	@Test
	public void test1() {
		
		tree.insert(1);
		tree.insert(5);
		tree.insert(6);
		tree.insert(3);
		tree.insert(2);
		tree.insert(7);
		
		assertEquals("   1   2   3   5   6   7",tree.printRollNumberInAscendingOrder());
		
		
	}
	
}
