/**
 * Using all the standards as discussed, write a Vehicle class with default attributes. And then extend this Vehicle class for Bike and Car classes.
Using JUnit create the instances of these vehicles and using Printer class print the Vehicle Details using toString().

Note: Go to Car / Bike sites, create two lists of attributes suitable for both classes and make Vehicle class with common attributes, 
Bike and Car with specific attributes. Minimum of 5 common and 2 for each specific attributes are required.

Deliverables- 
Vehicle, Car and Bike model classes with helper class to create specific vehicle object based on vehicle type. And JUnit to test the helper class.

Classes:
Vehicle - make, model, engineInCC, fuelCapacity, milage, price, roadTax
Create calculateOnRoadPrice method to be overwritten by children
Car - AC, powerSteering, accessoryKit
Bike - selfStart, helmetPrice

Class VehicleHelper
public static Vehicle createVehicle(String vehicleType, String Model, String make)
Create the Car/Bike based on vehicleType and return it

Class VehicleDetailPrinter
public static String printVehicleSpecification(Vehicle vehicle)
This method will return the generic attributes of Vehicle class as string.
{attributeKey:attributeValue,attributeKey:attributeValue}

JUnit:

VehicleHelperTest
Test class to test if vehicle objects are created as expected. Test to create a Car, Bike.

VehicleDetailPrinterTest
Test class to check if all the attributes values are returned in the specified string format.


 */
package CaseStudyAssignment1;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Deepali
 *
 */
public class VehicleDetailPrinterTest {
	/**
	 * Testing of vehicle Printer
	 */
	@Test
	public void test() {
		String object2 = "make:Verna,model:verna23";
		String object1 = VehiclePrinter.printVehicleSpecification(VehicleHelper
				.createVehicle("Car", "Verna", "verna23"));
		assertEquals(object1, object2);
	}

}