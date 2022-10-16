package com.login.util;
import java.sql.Connection;
import java.sql.DriverManager;
public class DBConnection {

	public static Connection createConnection()
	{
		
 	Connection con = null;
	String url = "jdbc:mysql://localhost:3306/customermanagement?zeroDateTimeBehaviour=convertToNull";
	String username = "root";
	String password = "password";
	 
	try
	{
	try
	{
	Class.forName("com.mysql.jdbc.Driver");
	}
	catch (ClassNotFoundException e)
	{
	e.printStackTrace();
	}
	con = DriverManager.getConnection(url, username, password);
	System.out.println("Post establishing a DB connection - "+con);
	}
	catch (Exception e)
	{
	e.printStackTrace();
	}
	 
	return con;
	}
	}