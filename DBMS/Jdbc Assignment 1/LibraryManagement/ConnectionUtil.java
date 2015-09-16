package LibraryManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Deepali
 */
public class ConnectionUtil {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/library_database";
	private static final String USER = "root";
	private static final String PASSWORD = "mysql";
			
	private Connection con = null; 
	
	/**
	 * @return :connection object
	 */
	public Connection getConnection() {
		
		/* register driver */
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		/* open connection */
	try {
			con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
}
