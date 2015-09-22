/**
 * Assignment 1:

Create a Vehicle table with attributes defined in Vehicle class. Also create Car and Bike tables with specific attributes. Add metadata attributes (id, created_by, created_time, etc.) attributes in table and update the classes.
Write a program to take XML as input to create Bike/Car using XMLParsing.
 *
 */
package VehicleManagement;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Deepali
 *
 */
public class VehicleReadTest {
	private static String FILEPATH = "./src/vehicles/vehicle.xml"; //Xml file to read
	
	public static void main(String args[]) throws VehicleManagementException {
	    int choice;
		char mainChoice;

		MenuClass menuClass = new MenuClass(); 
		Utility utility = new Utility();

	    VehicleJdbcHelper vehicleJdbcHelper=new VehicleJdbcHelper();
		do {
			// Menu
			menuClass.menuForVehicleManagement();;
			// Taking choice
			choice = utility.checkingChoice();
			switch (choice) {
			case 1://To Create Table in database
				vehicleJdbcHelper.createVehicleTable();
				System.out.println(" Table created in database");
				break;
			case 2://To add metadata Attributes
				 vehicleJdbcHelper.addMetaDataAttribute();
				 System.out.println("Attributes added in database");
				break;
			case 3://To insert data using xml File
				XmlParser xmlParser = new XmlParser();
			    List<Vehicle> vehicleList = xmlParser.readConfig(FILEPATH);
			    for (Vehicle vehicle : vehicleList) 
			    {
			      System.out.println(vehicle);
			      // insert in table
			      String string = vehicleJdbcHelper.insertInVehicleTable(vehicle);
			      System.out.println(string);
			    }
				break;
			case 4: //to delete Tables
			    vehicleJdbcHelper.deleteVehicleTables();
			    System.out.println("Tables deleted ");
			    break;
			default:
				System.out.println("Enter correct choice");
			}
			mainChoice = utility.checkingString();
		} while (mainChoice == 'Y');

		try {//closing connection
			vehicleJdbcHelper.getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// close connection
	}
}
