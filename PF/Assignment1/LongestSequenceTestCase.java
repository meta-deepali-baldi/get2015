package Assignments;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
	public void tearDown() throws Exception {
		Assignment3.count=0;
		Assignment3.count2=0;
		Assignment3.count2=0;
		Assignment3.greater=0;
	}

	@Test
	public void test() {
		int array1[]={1,1,2,3,4,1};
		int[] array2=Assignment2.removeDuplicate(array1);
		int array3[]={1,2,3,4,0,0};
		assertArrayEquals("correct",array3,array2);
	}
	public void test1() {
		int array1[]={1,2,3,2,3,4,5,3,4,2,2,3,4,5,6,7,8,1,2,4,5,6,7,8,9};
		int[] array2=Assignment2.removeDuplicate(array1);
		int array3[]={1,2,4,5,6,7,8,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		assertArrayEquals("correct",array3,array2);
	}
	
}
