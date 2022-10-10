package org.testngPracticePrgs;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.shophunt.genericutilities.ExcelUtility;

public class NavCityWithExcelTest {
	
	ExcelUtility elib = new ExcelUtility();
	
	@Test(dataProvider = "dataProvider_NavigationCityNames")
	public void navigateFromCitiesToCities(String src_city, String dst_city)
	{
		System.out.println("Start form " + src_city + ", to reach " + dst_city);
	}
	
	@DataProvider
	public Object[][] dataProvider_NavigationCityNames() throws EncryptedDocumentException, IOException
	{
		Object[][] objarr = new Object[5][2];
		objarr[0][0]= elib.getExcelData("Sheet3", 1, 0);
		objarr[0][1]= elib.getExcelData("Sheet3", 0, 0);
		
		objarr[1][0]= elib.getExcelData("Sheet3", 0, 0);
		objarr[1][1]= elib.getExcelData("Sheet3", 2, 0);
		
		objarr[2][0]= elib.getExcelData("Sheet3", 2, 0);
		objarr[2][1]= elib.getExcelData("Sheet3", 3, 0);
		
		objarr[3][0]= elib.getExcelData("Sheet3", 3, 0);
		objarr[3][1]= elib.getExcelData("Sheet3", 4, 0);
		
		objarr[4][0]= elib.getExcelData("Sheet3", 4, 0);
		objarr[4][1]= elib.getExcelData("Sheet3", 5, 0);
		
		return objarr;
		
	}

}
