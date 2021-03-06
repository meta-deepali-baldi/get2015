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

/**
 * @author Deepali
 *
 */
public class Bike extends Vehicle {
	private Boolean selfStart;//if bike is self start or not
	private double helmetPrice;//price of helmet for bike 
	

	/**
	 * @param make :instance variable of vehicle
	 * @param model :model no of vehicle
	 */
	public Bike(String make, String model) {
		super(make, model);
	}


	/**
	 * @return the selfStart
	 */
	public Boolean getSelfStart() {
		return selfStart;
	}



	/**
	 * @param selfStart the selfStart to set
	 */
	public void setSelfStart(Boolean selfStart) {
		this.selfStart = selfStart;
	}



	/**
	 * @return the helmetPrice
	 */
	public double getHelmetPrice() {
		return helmetPrice;
	}



	/**
	 * @param helmetPrice the helmetPrice to set
	 */
	public void setHelmetPrice(double helmetPrice) {
		this.helmetPrice = helmetPrice;
	}



	/**
	 * function to return "on road price"
	 */
	public double calculateOnRoadPrice() {
		return getPrice() * getRoadTax() * 100;

	}

}