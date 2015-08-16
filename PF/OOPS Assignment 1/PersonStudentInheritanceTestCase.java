/** Assignment 2: Apply Inheritance concepts
Implement Person and Student class as discussed in session and write appropriate unit test for testing them.
 */
package Assignment5;

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
public class PersonStudentInheritanceTestCase {

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

	// Test Case for toString
	@Test
	public void test() {
		Student student = new Student(12, "Rekha", 25);
		assertEquals(12, student.getUid());
		assertEquals("Rekha", student.getName());
		assertEquals(25, student.getStudentId());

	}

}
