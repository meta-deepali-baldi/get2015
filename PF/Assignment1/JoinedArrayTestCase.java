package Assignments;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
/**
 * @author Deepali
 *Write a program to join two sorted arrays and generate third sorted array.
 *int[] join(int a[], int asize, int b[], int bsize, int c[])
 *asize is number of elements in array a , bsize is number of elements in array b
 *Assume array c has sufficient space to store elements. Do not sort array c explicit.
 *Write JUnit test cases using a method which takes two arrays as input and return true or false for asserting.
 */

public class JoinedArrayTestCase {

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
	 * JUnit test cases using a method which takes two arrays as input and return true or false for asserting.
	 */
	@Test
	public void test() {
		int array1[]={1,2,2,2,3,3};//
		int array2[]={1,4,7,9};
		int array3[]=new int[array1.length+array2.length];
		array3=Assignment6.join(array1,array1.length,array2,array2.length,array3);
		int array4[]={1,1,2,2,2,3,3,4,7,9};//expected array
		assertArrayEquals("True",array4,array3);
	}
	
	/**
	 * JUnit test cases using a method which takes two arrays as input and return true or false for asserting.
	 */
	@Test
	public void test1() {
		int array1[]={1,3,4,7,9};
		int array2[]={2,7,9};
		int array3[]=new int[array1.length+array2.length];
		array3=Assignment6.join(array1,array1.length,array2,array2.length,array3);
		int array4[]={1,2,3,4,7,7,9,9};//expected array
		assertArrayEquals("True",array4,array3);
	}
}
