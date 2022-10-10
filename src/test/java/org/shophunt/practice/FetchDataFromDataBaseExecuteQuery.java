package org.shophunt.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class FetchDataFromDataBaseExecuteQuery {

	public static void main(String[] args) throws SQLException {
		
		//create object of driver
		Driver driverRef = new Driver();
		Connection conn = null;
		
		//register the driver
		DriverManager.registerDriver(driverRef);
		
		//establish the connection - provide database name
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shophunt", "root", "root");
		
		//create statement
		Statement state = conn.createStatement();
		
		//execute query- provide table name
		String query = "select * from empdetails;";
		String expname = "SHARATH";
		ResultSet result = state.executeQuery(query);
		boolean flag = false;
		while(result.next())
		{
			String actname = result.getString(2);
			if(actname.equalsIgnoreCase(expname))
			{
				System.out.println(actname);
				flag = true;  //flag rising
				break;
			}
		}
		if(flag)
		{
			System.out.println("data present");
		}
		else
		{
			System.out.println("data not present");
		}
		
		//validate
		//close connection
		conn.close();
		

	}

}
