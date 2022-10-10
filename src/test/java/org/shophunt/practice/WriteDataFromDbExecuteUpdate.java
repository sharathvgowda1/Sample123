package org.shophunt.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class WriteDataFromDbExecuteUpdate {

	public static void main(String[] args) throws SQLException {
		
		//create object for driver
		Driver driverRef = new Driver();
		Connection conn = null;
		
		//register the driver
		DriverManager.registerDriver(driverRef);
		
		//establish the connection - provide database name
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shophunt", "root", "root");
		
		//create the statement
		Statement state = conn.createStatement();
		
		//execute the query
		String query = "insert into empdetails values(333, 'Abhilash', 9873215, 'Gadag');";
		int result = state.executeUpdate(query);
		System.out.println(result);
		
		//validate
		if(result==1)
		{
			System.out.println("data added successfully");
		}
		else
		{
			System.out.println("data not added");
		}
		
		//close connection
		conn.close();
		System.out.println("connection closed");

	}

}
