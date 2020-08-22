package com.vastika.groupc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabase {
	public static final String CREATE_DB_SQL = "create database project1_db";
	public static final String DRIVER_NAME="com.mysql.cj.jdbc.Driver";
	public static final String URL= "jdbc:mysql://localhost:3306/?serverTimezone=UTC";
	public static final String USER_NAME="root";
	public static final String PASSWORD= "root";

	public static void main(String[] args) {
		
		try(Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
				Statement statement= connection.createStatement();
				){
			statement.executeUpdate(CREATE_DB_SQL);
			System.out.println("Database created!");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
