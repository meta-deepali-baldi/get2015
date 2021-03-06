/**
 * Assignment 3: Apply Interface concepts
Implement Shape class and its child class as discussed in session, write appropriate unit test for testing them.
note: you can display appropriate message in draw method for different shapes
 */
package Assignment5;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Deepali
 *
 */
public class ShapeTestCase {

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
	 * Test Case for calculating area of shapes
	 */
	@Test
	public void test() {
	int i=0;
	double area[]={12.56,9.0};
	Shape circleShape = new Circle(2);
	Shape squareArea = new Square(3);

	List<Shape> shape = new ArrayList<Shape>();
	shape.add(circleShape);
	shape.add(squareArea);

	Iterator<Shape> itr=shape.iterator();//getting Iterator from arraylist to traverse elements  
	 while(itr.hasNext()){  

	assertArrayEquals(area[i],itr.next().getArea());
	i++;
	}
	}

	private void assertArrayEquals(double d, double area) {
	// TODO Auto-generated method stub

	}


}
