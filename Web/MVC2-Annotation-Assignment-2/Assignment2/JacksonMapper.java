package Assignment2;
/**
 *Assignment 2:

Use Faster-XML/Jackson API to parse a Model class to JSON and vice versa.
Model Class - Employee:
employeeName
employeeId
emailId
dateOfBirth
dateOfJoining
ctcPerAnnum

Only following fields should be converted to JSON String -
employeeName
employeeId
emailId
dateOfJoining

Only follwing fields should be converted to Model Object from JSON -
employeeName
employeeId
dateOfBirth

Only following fields are allowed to be null -
dateOfBirth
dateOfJoining

 *
 */
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Deepali
 *
 */
public class JacksonMapper {
	public static void main(String args[]) {
		toJSON(); // converting Java object to JSON String
		toJava(); // parsing JSON file to create Java object
	}

	/**
	 * Method to parse JSON String into Java Object using Jackson Parser.
	 *
	 */
	public static void toJava() {
		// this is the key object to convert JSON to Java
		ObjectMapper mapper = new ObjectMapper();

		try {
			File json = new File("employee.json");
			
			Employee employee1 = mapper.readValue(json, Employee.class);
			System.out.println("Java object created from JSON String :");
			System.out.println(employee1.getEmployeeName());
			System.out.println(employee1.getEmployee_id());
			System.out.println(employee1.getDate_Of_Birth());

		} catch (JsonGenerationException ex) {
			ex.printStackTrace();
		} catch (JsonMappingException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();

		}
	}

	/**
	 * Java method to convert Java Object into JSON String with help of Jackson
	 * API.
	 *
	 */
	public static void toJSON() {
		Employee employee = new Employee("Deepali",12,"deepali@gmail.com","3-08-2015");

		// our bridge from Java to JSON and vice versa
		ObjectMapper mapper = new ObjectMapper();

		try {
			File json = new File("employee.json");
			
			mapper.writeValue(json,employee);

			System.out
					.println("Java object converted to JSON String, written to file");
			System.out.println(mapper.writeValueAsString(employee));


		} catch (JsonGenerationException ex) {
			ex.printStackTrace();
		} catch (JsonMappingException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();

		}
	}
	
}




