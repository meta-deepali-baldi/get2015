package Assignments3;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BinarySearchTestCase.class,
		GreatestCommondivisorTestCase.class,
		LargestDigitOfNumberTestCase.class, LinearSearchTestCase.class,
		QuickSortTestCase.class, RemainderTestCase.class })
public class AllTests {

}
