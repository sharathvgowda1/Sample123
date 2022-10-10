

package org.shophunt.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class FetchDataFromDatabasePractice {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		//create the object from DB driver class
		Driver dbDriver= new Driver();

		//register the driver to JDBC
		DriverManager.registerDriver(dbDriver);
		Connection connection= null;

		//establish the connection by using url, un and pwd
		try { connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shophunt", "root", "root");

		//create the statement
		Statement statement = connection.createStatement();

		//execute the query
		statement.executeUpdate("create table EmpDetails(empId int(4) not null unique, empName varchar(30), phone_number int(10) not null unique, Address varchar(50));");
		System.out.println("Table created");
		}
		finally{
			connection.close();
			System.out.println("Connection closed");
		}

	}

}
