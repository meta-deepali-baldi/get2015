package Assignments;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Deepali
 *Write a program to find longest increasing sequence from an array of n integer values
 *Input:
 *Given Array: [1,2,3,2,3,4,5,3,4,2,2,3,4,5,6,7,8,1,2,4,5,6,7,8,9]
 *Output:
 *Resultant Array: [1, 2,4,5,6,7,8,9]
 *method name : int[] longestSequence(int input[])
 *Write JUnit test cases which will assert the array return from the above method and the expected array.
*/
public class LongestSequenceTestCase {

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
	public void tearDown() throws Exception {//initializing instance variable here
		Assignment3.count=0;
		Assignment3.count2=0;
		Assignment3.count2=0;
		Assignment3.greater=0;
	}

	
	/**
	 * JUnit test cases which will assert the array returned and the expected array for longestSequence
	 */
	 @Test
	public void test1() {
		int array1[]={1,2,3,2,3,4,5,3,4,2,2,3,4,5,6,7,8,1,2,4,5,6,7,8,9};
		int[] array2=Assignment3.longestSequence(array1);
		int array3[]={1,2,4,5,6,7,8,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		assertArrayEquals("correct",array3,array2);
	}
	
}
