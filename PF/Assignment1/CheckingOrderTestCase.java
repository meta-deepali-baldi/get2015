package Assignments;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CheckingOrderTestCase {

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
	public void test() {
		int array1[]={1,2,2,2,3,3};
		int order=Assignment5.checkingorderofarray(array1);
	
		assertEquals("Ascending order",1,order);
	}
	
	@Test
	public void test1() {
		int array1[]={1,4,6,3,7,8,9};
		int order=Assignment5.checkingorderofarray(array1);
	
		assertEquals("Not sorted",0,order);
	}
	@Test
	public void test2() {
		int array1[]={9,6,4,2,0};
		int order=Assignment5.checkingorderofarray(array1);
	
		assertEquals("Descending order",2,order);
	}

}
