package Assignments;
	import static org.junit.Assert.*;

	import org.junit.After;
	import org.junit.AfterClass;
	import org.junit.Before;
	import org.junit.BeforeClass;
	import org.junit.Test;
	
	/**
	 * @author Deepali
	 *Write a program which remove duplicate elements from an unsorted Array eg.
	 *Input:
	 *Given Array: [2,5,4,6,3,8,5,9,3,3,6,3,9,0]
	 *Output:Resultant Array:[2,5,4,6,3,8,9,0]
	 *Method name : int[] removeDuplicate(int input[])
	 *Write JUnit test cases which will assert the array return from the above method and the expected array.
	 */
public class RemoveDuplicateTestCase {
	

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
			Assignment2.count=0;
		}

		
		/**
		 * JUnit test cases which will assert the array returned and the expected array for removeDuplicate
		 */
		@Test
		public void test() {
			int array1[]={1,2,2,2,3,3};
			int[] array2=Assignment2.removeDuplicate(array1);//Returned Array
			int array3[]={1,2,3,0,0,0};//Expected array
			assertArrayEquals("correct",array3,array2);
		}
		
		/**
		 * JUnit test cases which will assert the array returned and the expected array for removeDuplicate
		 */
		@Test
		public void test1() {
			int array1[]={2,5,4,6,3,8,5,9,3,3,6,3,9,0};
			int[] array2=Assignment2.removeDuplicate(array1);//Returned Array
			int array3[]={2,5,4,6,3,8,9,0,0,0,0,0,0,0};//Expected array
			assertArrayEquals("correct",array3,array2);
		}
		
	}
