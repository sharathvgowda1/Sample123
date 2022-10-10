package org.shophunt.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws IOException {

		//Step 1:- use the File Input Stream to load the property file
		FileInputStream fis = new  FileInputStream(".\\Data\\commonData.properties");
		
		//Step 2:-create object of properties and load the file
		Properties prop = new Properties();
		prop.load(fis);
		
		//Step 3:- Provide the key to read the value
		String URL = prop.getProperty("url");
		System.out.println(URL);
		
		String UN = prop.getProperty("username");
		System.out.println(UN);
		
		String pwd = prop.getProperty("password");
		System.out.println(pwd);
	}

}
