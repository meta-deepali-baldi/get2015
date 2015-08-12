/**
 * Tower of Hanoi
List<String> towerOfHanoi(String source, String destination, String temp, int numOfDisk)
Write JUnit for the above program:
towerOfHanoi(“A”, “B”, “C”, 1);
Expected: Returns List of movements of discs.
Move Disk 1 from A to B 

towerOfHanoi(“A”, “B”, “C”, 2);
Expected: Returns List of movements of discs.
Move Disk 2 from A to C 
Move Disk 1 from A to B 
Move Disk 2 from C to B

towerOfHanoi(“A”, “B”, “C”, 3);
Expected: Returns List of movements of discs.
Move Disk 3 from A to B 
Move Disk 2 from A to C 
Move Disk 3 from B to C
Move Disk 1 from A to B 
Move Disk 3 from C to A 
Move Disk 2 from C to B
Move Disk 3 from A to B
 *
 */
package Assignment4;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TowerOfHanoiTestCase {
	
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
	 * Junit Test Case For Tower Of Hanoi
	 */
	@Test
	public void test1() {
		
		TowerOfHanoi towerHanoi=new TowerOfHanoi(1);
		int i=0;
		String Result1[]={"Move Disk 1 from A to B"};
		
		towerHanoi.Result=new ArrayList<String>();
		
		towerHanoi.Result=towerHanoi.towerOfHanoi("A","B","C",1);
		for(String a:towerHanoi.Result){ 
		
			assertEquals("",Result1[i],a);
			i++;
		}  
	}
	
	
	/**
	 * Junit Test Case For Tower Of Hanoi
	 */
	@Test
	public void test2() {
		
		TowerOfHanoi towerHanoi=new TowerOfHanoi(2);
		int i=0;
		String Result1[]={"Move Disk 2 from A to C","Move Disk 1 from A to B","Move Disk 2 from C to B"};
		
		towerHanoi.Result=new ArrayList<String>();
	
		towerHanoi.Result=towerHanoi.towerOfHanoi("A","B","C",1);
		for(String a:towerHanoi.Result){ 
		
			assertEquals("",Result1[i],a);
			i++;
	 	 }  
	}


	/**
	 * Junit Test Case For Tower Of Hanoi
	 */
	@Test
	public void test3() {
		TowerOfHanoi towerHanoi=new TowerOfHanoi(3);
		int i=0;
		String Result1[]={"Move Disk 3 from A to B","Move Disk 2 from A to C","Move Disk 3 from B to C","Move Disk 1 from A to B",
"Move Disk 3 from C to A","Move Disk 2 from C to B","Move Disk 3 from A to B"};
		
		towerHanoi.Result=new ArrayList<String>();
	
		towerHanoi.Result=towerHanoi.towerOfHanoi("A","B","C",1);
		for(String a:towerHanoi.Result){ 
		
			assertEquals("",Result1[i],a);
			i++;
	 	 }  
	}

}
