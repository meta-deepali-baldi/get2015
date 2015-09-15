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
public class Car extends Vehicle {
	private boolean AC;//car has AC or not
	private boolean powerSteering; //car has powerSteering or not
	private boolean accessoryKit; //car has accessoryKit or not


	/**
	 * @param make :instance variable of vehicle
	 * @param model :model no of vehicle
	 */
	public Car(String make, String model) {
		super(make, model);
	}


	/**
	 * @return the aC
	 */
	public boolean isAC() {
		return AC;
	}


	/**
	 * @param aC the aC to set
	 */
	public void setAC(boolean aC) {
		AC = aC;
	}


	/**
	 * @return the powerSteering
	 */
	public boolean isPowerSteering() {
		return powerSteering;
	}


	/**
	 * @param powerSteering the powerSteering to set
	 */
	public void setPowerSteering(boolean powerSteering) {
		this.powerSteering = powerSteering;
	}


	/**
	 * @return the accessoryKit
	 */
	public boolean isAccessoryKit() {
		return accessoryKit;
	}


	/**
	 * @param accessoryKit the accessoryKit to set
	 */
	public void setAccessoryKit(boolean accessoryKit) {
		this.accessoryKit = accessoryKit;
	}


	/**
	 *  Over written function from base class
	 */
	public double calculateOnRoadPrice() {
		return getPrice() * getRoadTax() * 100;

	}

}