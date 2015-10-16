package Assignment1;
import java.lang.reflect.Method;

/**
 * @author Deepali
 *
 */
public class TestAnnotationParser {
	public void parse(Class<?> tempClass) throws Exception {

		Method[] methods = tempClass.getMethods();

		for (Method method : methods) {

			if (method.isAnnotationPresent(RequestForEnhancement.class)) {
				RequestForEnhancement test = method
						.getAnnotation(RequestForEnhancement.class);
				int info = test.id();
				String synopsis = test.synopsis();
				if (1 == info) {
					System.out.println("info is awesome!");
					// try to invoke the method with param
					method.invoke(Employee.class.newInstance(), info, synopsis,
							test.engineer(), test.date());
				}
			}

		}
	}
}
