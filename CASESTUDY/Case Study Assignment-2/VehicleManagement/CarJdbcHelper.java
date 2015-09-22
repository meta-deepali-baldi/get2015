package VehicleManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class CarJdbcHelper {
	private Statement statement; // statement reference
	private static String query ,insertQuery;
	
	static {
		query=  "CREATE TABLE IF NOT EXISTS Car"
				+ "("
				+ "car_id INT AUTO_INCREMENT PRIMARY KEY,"
				+ "ac int(1),"
				+ "power_steering int(1),"
				+ "accessory_kit int(1),"
				+ "vehicle_id INT,"
				+ "FOREIGN KEY (vehicle_id) REFERENCES Vehicle (vehicle_id) ON DELETE CASCADE"
				+ ")";
	
		insertQuery ="INSERT INTO Car ( ac, power_steering, accessory_kit, vehicle_id ) VALUES (?,?,?,?)";
		
	}
	
	public CarJdbcHelper() {
		statement=null;
	}


	public void createCarTable(Connection con) throws VehicleManagementException
	{
		try {
			statement = con.createStatement();
			statement.executeUpdate(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public static int insertInCarTable(Car objCar,Connection connection) throws VehicleManagementException
	{
		int countCar = 0;
		PreparedStatement ps = null;
		
		try 
		{
			ps = (PreparedStatement) connection.prepareStatement(insertQuery);
			/* set variable in prepared statement */
			ps.setBoolean(1, objCar.getAC());
			ps.setBoolean(2, objCar.getPowerSteering());
			ps.setBoolean(3, objCar.getAccessoryKit());
			ps.setInt(4, objCar.getVehicleId() );
			countCar = ps.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		} 
		return countCar;
	}
}
