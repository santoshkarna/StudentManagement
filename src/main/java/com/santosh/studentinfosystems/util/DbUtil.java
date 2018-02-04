package com.santosh.studentinfosystems.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {

	private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private static final String DB_NAME = "servlet_crud_demo";
	private static final String URL = "jdbc:mysql://localhost:3306/";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "root";

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName(DRIVER_NAME);
		Connection con = DriverManager.getConnection(URL + DB_NAME, USER_NAME, PASSWORD);
		return con;
	}
}
