package VehicleManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class BikeJdbcHelper {
	private Statement statement; // statement reference
	private static String query ,insertQuery;
	static {
		query= "CREATE TABLE IF NOT EXISTS Bike"
				+ "("
				+ "bike_id INT AUTO_INCREMENT PRIMARY KEY,"
				+ "self_start int(1),"
				+ "helmet_price DOUBLE,"
				+ "vehicle_id INT,"
				+ "FOREIGN KEY (vehicle_id) REFERENCES Vehicle (vehicle_id) ON DELETE CASCADE"
				+ ")";
		
		insertQuery = "INSERT INTO Bike ( self_start, helmet_price, vehicle_id ) VALUES (?,?,?)";
	}
	public BikeJdbcHelper() {
		statement = null;
	}

	public void createBikeTable(Connection connection)
			throws VehicleManagementException {
		
		try {
			statement = connection.createStatement();
			statement.executeUpdate(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static int insertInBikeTable(Bike objBike, Connection con)
			throws VehicleManagementException {
		int countBike = 0;
		PreparedStatement ps = null;
		

		try {
			ps = (PreparedStatement) con.prepareStatement(insertQuery);
			/* set variable in prepared statement */
			ps.setBoolean(1, objBike.getSelfStart());
			ps.setDouble(2, objBike.getHelmetPrice());
			ps.setInt(3, objBike.getVehicleId());
			countBike = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return countBike;
	}

}
