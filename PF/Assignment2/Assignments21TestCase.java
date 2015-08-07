package Assignments;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Assignments21TestCase {
	Assignment21 a1= new Assignment21();
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
		assertEquals("Correct"," ",s1);
	}
	@Test
	public void test2() {
		
			String s1=a1.number(4,5);
			assertEquals("Correct","1234321",s1);
	}
	@Test
	public void test3() {
		String expected[]={"    1","   121","  12321"," 1234321","123454321"," 1234321","  12321","   121","    1"};
		String s1[]=a1.printWholePyramid(5);
		for(int i=0;i<9;i++){
			assertEquals("Correct",expected[i],s1[i]);
		}
}
}
