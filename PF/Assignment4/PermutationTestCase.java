/**
*Write a Java program to generate all possible permutations of given letters in string.

Can you make it more generic so that it can generate permutations of any length of string.

List<String> generatePermutations(String input);

Write JUnit for the above program:
generatePermutations(“ABC”);
Expected: Return List of string containing following values:
ABC
ACB
BAC
BCA
CBA
CAB

2) generatePermutations(“ABCD”);
Expected: Return List of string containing 24 unique permutations.

*/
package Assignment4;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PermutationTestCase {

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
	 * Testing 1st case
	 */
	@Test
	public void test() {

		int i = 0;
		String Result1[] = { "acb", "bca", "abc", "cba", "bac", "cab" };

		ComputingPermutation.result = new ArrayList<String>();

		ComputingPermutation.result = ComputingPermutation.permutation("abc");
		Iterator<String> itr = ComputingPermutation.result.iterator();// getting Iterator from array
															
		// list to traverse elements
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		for (String a : ComputingPermutation.result) {

			assertEquals("", Result1[i], a);
			i++;
		}
	}

	/**
	 * Testing 2nd case
	 */
	@Test
	public void test1() {

		int i = 0;
		String Result1[] = { "acbd", "adbc", "bcad", "bdac", "cbad", "cdab",
				"abdc", "acdb", "bacd", "bdca", "cabd", "cdba", "dbac", "dcab",
				"abcd", "adcb", "badc", "bcda", "dabc", "dcba", "cadb", "cbda",
				"dacb", "dbca" };

		ComputingPermutation.result = new ArrayList<String>();

		ComputingPermutation.result = ComputingPermutation.permutation("abcd");
		Iterator<String> itr = ComputingPermutation.result.iterator();// getting Iterator from array
		// list to traverse elements
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		for (String a : ComputingPermutation.result) {

			assertEquals("", Result1[i], a);
			i++;
		}

	}


}
