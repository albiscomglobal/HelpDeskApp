package com.login.dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
import com.login.bean.LoginBean;
import com.login.util.DBConnection;

public class LoginDao {

	public String authenticateUser(LoginBean loginBean)
	{
	 String userName = loginBean.getUserName();
	 String password = loginBean.getPassword();
	 
	 Connection con ;
	 Statement statement ;
	 ResultSet resultSet ;
	 
	 String userNameDB = "";
	 String passwordDB = "";
	 String roleDB = "";
	 
	 try
	 {
	 con = DBConnection.createConnection();
	 statement = con.createStatement();
	 resultSet = statement.executeQuery("select username,password,role from user");
	 
	 while(resultSet.next())
	 {
	 userNameDB = resultSet.getString("username");
	 passwordDB = resultSet.getString("password");
	 roleDB = resultSet.getString("role");
	 
	 if(userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("Admin"))
	 return "Admin_Role";
	 else if(userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("MedicalLab"))
	 return "MedicalLab_Role";
	 else if(userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("Radiology"))
	 return "Radiology_Role";
	 
	 else if(userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("Reception"))
		 return "Reception_Role";
	 
	 else if(userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("Account"))
		 return "Account_Role";
	 else if(userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("wellness"))
		 return "wellness_Role";
	 
	 else if(userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("super"))
		 return "superadmin_Role";
	 }
	 }
	 catch(SQLException e)
	 {
	 e.printStackTrace();
	 }
	 return "Invalid user credentials";
	}
	}