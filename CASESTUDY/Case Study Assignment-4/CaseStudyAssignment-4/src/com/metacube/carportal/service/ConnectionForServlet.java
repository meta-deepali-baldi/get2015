/**
 * 
 */
package com.metacube.carportal.service;

import java.sql.Connection;

import com.metacube.carportal.db.helper.CarPortalDao;
import com.metacube.carportal.dbconfig.ConnectionFactory;
import com.metacube.carportal.exception.CarDekhoException;

/**
 * @author Deepali
 *
 */
public class ConnectionForServlet {

	/**Getting Connection For Servlet
	 * @return :connection
	 */
	public static Connection getConnectionForServlet() {
		Connection connection = null;
		// getting connection
		try {
			connection = ConnectionFactory.getConnection();
			if (connection == null) {
				connection = new ConnectionFactory().createConnection();//creating Connection if connection is null
				new CarPortalDao(connection);
			}
		} catch (CarDekhoException e) {
			e.printStackTrace();
		}
		return connection;

	}
}
