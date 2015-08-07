package Assignments;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Assignment22TestCase {
	 Assignment22 a1=new Assignment22();
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

		@Test
		public void test1() {
			
			String s1=a1.spaces(4,5);
			assertEquals("Correct","   ",s1);
		}
		@Test
		public void test2() {
			
				String s1=a1.number(4,5);
				assertEquals("Correct","12",s1);
		}
		@Test
		public void test3() {
			String expected[]={"12345"," 1234","  123","   12","    1"};
			String s1[]=a1.printWholePyramid(5);
			for(int i=0;i<5;i++){
				assertEquals("Correct",expected[i],s1[i]);
			}
	}
}
