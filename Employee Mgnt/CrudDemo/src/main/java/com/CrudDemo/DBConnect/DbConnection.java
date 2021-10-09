package com.CrudDemo.DBConnect;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	
	private String url = "jdbc:mysql://localhost:3306/db1";
	private String uname = "root";
	private String passw = "Aditya@20";
	
	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, uname, passw);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
}
