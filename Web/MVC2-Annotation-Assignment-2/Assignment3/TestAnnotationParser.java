package Assignment3;
/**
 * Assignment 3:

Create an annotation CanRun with no elements.
Create a class AnnotationRunner, with 5 methods (method1 to method5), printing unique text to console in each method (e.g method1() prints “Executing method-1”). Put CanRun annotation on methods 1, 3 and 5.
Create a main class which instantiates an object of AnnotationRunner, and executes all the methods with annotation CanRun.
Verify the output on the console.



 *
 */
import java.lang.reflect.Method;

/**
 * @author Deepali
 *
 */
public class TestAnnotationParser {
	public static void main(String[] args) throws Exception {
		TestAnnotationParser parser = new TestAnnotationParser();
		parser.parse(AnnotationRunner.class);
	}

	public void parse(Class<?> tempClass) throws Exception {

		Method[] methods = tempClass.getMethods();

		for (Method method : methods) {

			if (method.isAnnotationPresent(CanRun.class)) {
				CanRun test = method.getAnnotation(CanRun.class);

				// try to invoke the method with param
				method.invoke(AnnotationRunner.class.newInstance());

			}

		}
	}

}
