package com.java.todo.connector;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

public class ConnectorFactory {
	static Connection con = null;
	static String url = "jdbc:mysql://localhost:3306/todo";
	static String un = "root";
	static String pwd = "Akash@1654";
	public static Connection requestConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url,un,pwd);
		return con;
	}
	public static Date getSQLDate(LocalDate date) {
		return java.sql.Date.valueOf(date);
	}

	public static LocalDate getUtilDate(Date sqlDate) {
		return sqlDate.toLocalDate();
	}
}
