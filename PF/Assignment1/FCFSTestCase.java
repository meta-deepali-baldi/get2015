package Assignments;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Deepali
 *Write a java  function int [][]FCFS( int arrival_time [], int job_size[] , n) to simulate FCFS (First come First Server) scheduler of a machine.  First parameter represents list of jobs arrival time and second parameter represent length for respective job. Function should display wait time for each job for cpu cycle. Assume CPU cycle start with 1 for processing.  
 *Input:
 *Arrival_time [1, 5, 9, 25]
 *Job_size [12,7,2,5]
 *Output:

Job       job arrived time      Job wait time    Job Start at         Job finished at

1          1                               	0	           1                  	   12

2          5   	                 			8             13                       19

3          9                               11             20                       21

4          25                             	0             25                       29


Note: To create JUNIT Test Case for array problem , you need to create a sample function that will take 2 input ( first one will be expected 2D array and second input will be 2D array came after above function call)
isArrayEqual(int expected[][], int output[][])
Write JUnit test cases using a method which asserts on the return value of isArrayEqual method.
 */

public class FCFSTestCase {

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
	 * JUnit test cases using a method which asserts on the return value of firstComeFirstServe method.
	 */
	@Test
	public void test() {
		int arrival[]={1,5,9,25};
		int jobsize[]={12,7,2,5};
		int assumed[][]={{1,1,0,1,12},{2,5,8,13,19},{3,9,11,20,21},{4,25,0,25,29}};
		int finalResult[][]=Assignments4.firstComeFirstServe(arrival,jobsize,jobsize.length);
		for(int i=0;i<arrival.length;i++){
				assertArrayEquals(assumed[i],finalResult[i]);	
		}
	}

}
