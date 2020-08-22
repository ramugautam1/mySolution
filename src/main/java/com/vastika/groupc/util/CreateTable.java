package com.vastika.groupc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
	
	

		public static final String CREATE_TRANSACTION_TBL_SQL = "create table transaction_tbl(deposit_amount float, withdraw_amount float, account_info_id bigint)";
		
		public static final String CREATE_ACCOUNT_BALANCE_TBL_SQL= "create table account_balance_tbl(account_info_id bigint, balance float)";
		
		public static final String CREATE_ACCOUNT_INFO_TBL_SQL = "create table account_info_tbl(id bigint not null, account_name varchar(50), password varchar(50), address varchar(50), mobile_no bigint,unique_id_type varchar(50), primary key(id))";
		
		public static final String DRIVER_NAME="com.mysql.cj.jdbc.Driver";
		public static final String URL= "jdbc:mysql://localhost:3306/project1_db?serverTimezone=UTC";
		public static final String USER_NAME="root";
		public static final String PASSWORD= "root";

		public static void main(String[] args) {
			
			try(Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
				Statement statement= connection.createStatement();
					){
				statement.executeUpdate(CREATE_ACCOUNT_INFO_TBL_SQL);
				System.out.println("Table 'account_info_tbl' created!");
				
				statement.executeUpdate(CREATE_ACCOUNT_BALANCE_TBL_SQL);
				System.out.println("Table 'account_balance_tbl' created!");
				
				statement.executeUpdate(CREATE_TRANSACTION_TBL_SQL);
				System.out.println("Table 'transaction_tbl' created!");

				
			} catch (SQLException e) {
				
				e.printStackTrace();
				
			}


		}
}
