package Assignments;
	import static org.junit.Assert.*;

	import org.junit.After;
	import org.junit.AfterClass;
	import org.junit.Before;
	import org.junit.BeforeClass;
	import org.junit.Test;

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

		@Test
		public void test() {
			int array1[]={1,2,2,2,3,3};
			int[] array2=Assignment2.removeDuplicate(array1);
			int array3[]={1,2,3,0,0,0};
			assertArrayEquals("correct",array3,array2);
		}
		
		@Test
		public void test1() {
			int array1[]={2,5,4,6,3,8,5,9,3,3,6,3,9,0};
			int[] array2=Assignment2.removeDuplicate(array1);
			int array3[]={2,5,4,6,3,8,9,0,0,0,0,0,0,0};
			assertArrayEquals("correct",array3,array2);
		}
		
	}
