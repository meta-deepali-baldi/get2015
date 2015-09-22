package VehicleManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Deepali
 *
 */

public class VehicleJdbcHelper {
	private static String query, alterQuery, createQuery, insertQuery,createDatabase,useDatabase,deleteQuery; //Query Strings
	private Connection connection;// Connection reference
	private Statement statement; // statement reference

	static {
		query = "ALTER TABLE Vehicle ADD created_by VARCHAR(20)";
		alterQuery = "ALTER TABLE Vehicle ADD created_time TIMESTAMP DEFAULT NOW()";
		createDatabase="CREATE DATABASE IF NOT EXISTS vehicle_management_system";
		useDatabase="USE vehicle_management_system";
		createQuery = "CREATE TABLE IF NOT EXISTS Vehicle" + "("
				+ "vehicle_id INT AUTO_INCREMENT PRIMARY KEY, "
				+ "make VARCHAR(20), " + "model VARCHAR(20), "
				+ "engine_in_cc DOUBLE, " + "fuel_capacity DOUBLE,"
				+ "milage DOUBLE," + "price DOUBLE," + "road_tax DOUBLE"
				+ " )";
		insertQuery = "INSERT INTO Vehicle (vehicle_id, make, model, engine_in_cc, fuel_capacity, milage, price, road_tax, created_by) VALUES (?,?,?,?,?,?,?,?,?)";
		deleteQuery="drop schema vehicle_management_system";
	}

	/**
	 * Constructor
	 */
	public VehicleJdbcHelper() {
		connection = null;
		statement = null;
		ConnectionUtil conUtil = new ConnectionUtil();
		try {
			connection = conUtil.getConnection();
		} catch (VehicleManagementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	/**
	 * @return the connection
	 */
	public Connection getConnection() {
		return connection;
	}


	/**
	 * @param connection the connection to set
	 */
	public void setConnection(Connection connection) {
		this.connection = connection;
	}


	/**Add metadata To Tables
	 * @throws VehicleManagementException
	 */
	public void addMetaDataAttribute() throws VehicleManagementException {

		try {
			statement = connection.createStatement();
			statement.execute(query);
			statement = connection.createStatement();
			statement.execute(alterQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**Create Vehicle Table
	 * @return :if table created or not
	 * @throws VehicleManagementException
	 */
	public boolean createVehicleTable() throws VehicleManagementException {
		boolean bool = false;

		try {
			statement = connection.createStatement();
			statement.execute(createDatabase);
			statement.execute(useDatabase);
			statement.execute(createQuery);
			CarJdbcHelper carJdbcHelper=new CarJdbcHelper();
			carJdbcHelper.createCarTable(connection);
			BikeJdbcHelper bikeJdbcHelper=new BikeJdbcHelper();
			bikeJdbcHelper.createBikeTable(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bool;
	}

	/**To insert in vbehicle Table
	 * @param objVehicle :object to insert
	 * @return :if object inserted or not
	 * @throws VehicleManagementException
	 */
	public String insertInVehicleTable(Vehicle objVehicle)
			throws VehicleManagementException {
		int countVehicle = 0, countCar = 0, countBike = 0;
		String str = null;
		PreparedStatement ps = null;
		try {
			ps = (PreparedStatement) connection.prepareStatement(insertQuery);
			/* set variable in prepared statement */
			ps.setInt(1, objVehicle.getVehicleId());
			ps.setString(2, objVehicle.getMake());
			ps.setString(3, objVehicle.getModel());
			ps.setDouble(4, objVehicle.getEngineInCC());
			ps.setDouble(5, objVehicle.getFuelCapacity());
			ps.setDouble(6, objVehicle.getMilage());
			ps.setDouble(7, objVehicle.getPrice());
			ps.setDouble(8, objVehicle.getRoadTax());
			ps.setString(9, objVehicle.getCreatedBy());
			countVehicle = ps.executeUpdate();
			if (countVehicle > 0) {
				if (objVehicle instanceof Car) {
					countCar = CarJdbcHelper.insertInCarTable((Car) objVehicle, connection);
					if (countCar > 0)
						str = "Car created Successfully";
					else
						str = "Could not create Car";
				} else if (objVehicle instanceof Bike) {
					countBike = BikeJdbcHelper
							.insertInBikeTable(((Bike) objVehicle), connection);
					if (countBike > 0)
						str = "Bike created Successfully";
					else
						str = "Could not create Bike";
				}
			} else
				str = "Could not create vehicle";
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return str;
	}

	/**function to delete all tables
	 * @throws VehicleManagementException
	 */
	public void deleteVehicleTables() throws VehicleManagementException {

		try {
			statement = connection.createStatement();
			statement.executeUpdate(deleteQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
