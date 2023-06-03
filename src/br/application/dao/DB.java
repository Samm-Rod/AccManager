package br.application.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
	
	private static final String USENAME = "root";
	private static final String PASSWORD = "Summer1945.";
	private static final String URL_DB = "jdbc:mysql://localhost:3306/passmanager";
	private static Connection conn;
	
	
	// Get Connection 
	public static Connection getConnect(){
			
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL_DB, USENAME,PASSWORD);
			System.out.println("Connected !");
		} catch (Exception e) {
			throw new DBException(e.getMessage());
		}
		
		return conn;
	}
	
	public static void closeConnection() {
		if(conn != null) {
			try {
				conn.close();
			}catch(SQLException e) {
				throw new DBException(e.getMessage());
			}
		}
	}
	
	public static void closeResultSet(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			}catch(SQLException e) {
				throw new DBException(e.getMessage());
			}
		}
	}
	
	public static void closeStatement(Statement st) {
		if(st != null) {
			try {
				st.close();
			}catch(SQLException e) {
				throw new DBException(e.getMessage());
			}
		}
	}
	

}
