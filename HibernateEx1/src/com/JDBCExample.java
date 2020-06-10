package com;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class JDBCExample {
	public static void main(String[] args) {
		
		testDataSource();
		
		/*
		 * String dbURL = "jdbc:odbc:DB_DSM"; Connection conn; try {
		 * Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); conn =
		 * DriverManager.getConnection(dbURL); if (conn != null) {
		 * System.out.println("Connected"); } conn.close(); } catch (Exception e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); }
		 */
		
		// Create a variable for the connection string.
		/*
		 * String connectionUrl = "jdbc:odbc:DB_DSM";
		 * 
		 * try (Connection con = DriverManager.getConnection(connectionUrl); Statement
		 * stmt = con.createStatement();) { String SQL =
		 * "SELECT TOP 10 * FROM Person.Contact"; ResultSet rs = stmt.executeQuery(SQL);
		 * 
		 * // Iterate through the data in the result set and display it. while
		 * (rs.next()) { System.out.println(rs.getString("FirstName") + " " +
		 * rs.getString("LastName")); } } // Handle any errors that may have occurred.
		 * catch (SQLException e) { e.printStackTrace(); }
		 */
	}
	
	 public static void testDataSource() {

		// Create a variable for the connection string.
	        String connectionUrl = "jdbc:sqlserver://localhost;databaseName=DB_SERVER;user=db_user;password=db_12345678";

	        try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
	            String SQL = "SELECT TOP 10 * FROM Persons";
	            ResultSet rs = stmt.executeQuery(SQL);

	            // Iterate through the data in the result set and display it.
	            while (rs.next()) {
	                System.out.println(rs.getString("FirstName") + " " + rs.getString("LastName"));
	            }
	        }
	        // Handle any errors that may have occurred.
	        catch (SQLException e) {
	            e.printStackTrace();
	        }
	 }
}
