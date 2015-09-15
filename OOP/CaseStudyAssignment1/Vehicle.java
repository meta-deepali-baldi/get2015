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
public class Vehicle {
	private String make; //Company name of Vehicle 
	private String model; //Model of Vehicle
	private int engineInCC; //Power of engine in cc
	private double fuelCapacity;//Fuel capacity of vehicle
	private double milage; //Milage of vehicle
	private double price; //price of vehicle
	private double roadTax; //RoadTax of vehicle
	
	/**
	 * @param make :instance variable of vehicle
	 * @param model :model no of vehicle
	 */
	public Vehicle(String make, String model) {

		this.make = make;
		this.model = model;
	}


	/**
	 * @return the make
	 */
	public String getMake() {
		return make;
	}


	/**
	 * @param make the make to set
	 */
	public void setMake(String make) {
		this.make = make;
	}


	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}


	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}


	/**
	 * @return the engineInCC
	 */
	public int getEngineInCC() {
		return engineInCC;
	}


	/**
	 * @param engineInCC the engineInCC to set
	 */
	public void setEngineInCC(int engineInCC) {
		this.engineInCC = engineInCC;
	}


	/**
	 * @return the fuelCapacity
	 */
	public double getFuelCapacity() {
		return fuelCapacity;
	}


	/**
	 * @param fuelCapacity the fuelCapacity to set
	 */
	public void setFuelCapacity(double fuelCapacity) {
		this.fuelCapacity = fuelCapacity;
	}


	/**
	 * @return the milage
	 */
	public double getMilage() {
		return milage;
	}


	/**
	 * @param milage the milage to set
	 */
	public void setMilage(double milage) {
		this.milage = milage;
	}


	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}


	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}


	/**
	 * @return the roadTax
	 */
	public double getRoadTax() {
		return roadTax;
	}


	/**
	 * @param roadTax the roadTax to set
	 */
	public void setRoadTax(double roadTax) {
		this.roadTax = roadTax;
	}

	/**
	 * function returning the parameters of object
	 */
	public String toString() { 
		return "make:" + getMake() + "," + "model:" + getModel();

	}

	/**
	 * function to be overwritten in derived class
	 */
	public double calculateOnRoadPrice() {
		return price + roadTax * 100;

	}

}