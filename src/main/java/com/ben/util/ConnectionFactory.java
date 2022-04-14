package com.ben.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection getConnection() {

		Connection conn = null;

		try {
			conn = DriverManager.getConnection(
					System.getenv("db_url"), 
					System.getenv("db_username"),
					System.getenv("db_password"));

		} catch (SQLException e1) {
			System.out.println("you messed up somewhere in the ConnectionFactory.java file");
			e1.printStackTrace();
		}

		return conn;

	}

}
