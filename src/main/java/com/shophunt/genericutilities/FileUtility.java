package com.shophunt.genericutilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *  it contains External File specific libraries
 * @author Deepak
 *
 */
public class FileUtility{

	/**
	 *   its used return the value from the property file based on key
	 * @param key
	 * @return value
	 * @throws IOException 
	 * @throws Throwable
	 */

	public String getPropertyKeyValue(String key) throws IOException  {

		FileInputStream fis = new FileInputStream(IConstants.PropPath);
		Properties prop = new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);
		return value;

	}


}
