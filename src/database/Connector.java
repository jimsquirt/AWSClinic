package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connector {

	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://localhost/aws_clinic";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "";
	private static Connector connector;
	private static Connection connect = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;

	private Connector() {
		establishConnection();
	}

	public static Connector getInstance() {
		if (connector == null) {
			connector = new Connector();
		}
		return connector;

	}

	private void establishConnection() {
		connect = getDBConnection();
	}

	public void selectQuery(String n) throws SQLException {
		try {
			statement = connect.prepareStatement(n);
			resultSet = statement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void searchPetByNameProc(String n) throws SQLException {
		try {
			statement = connect.prepareCall("{call searchpetbyname("+n+")}");
			resultSet = statement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ResultSet getResultSet() {
		return resultSet;
	}

	public void updateQuery(String n) throws SQLException {
		try {
			statement = connect.prepareStatement(n);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static Connection getDBConnection() {
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {

			connect = DriverManager.getConnection(DB_CONNECTION, DB_USER,
					DB_PASSWORD);
			return connect;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connect;

	}

}