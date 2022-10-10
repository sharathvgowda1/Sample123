package org.testngPracticePrgs;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NavigationCitiesTest {
	
	@Test(dataProvider = "dataProvider_NavigationCityNames")
	public void navigateFromCitiesToCities(String src_city, String dst_city)
	{
		System.out.println("Start form " + src_city + ", to reach " + dst_city);
	}
	
	@DataProvider
	public Object[][] dataProvider_NavigationCityNames()
	{
		Object[][] objarr = new Object[5][2];
		objarr[0][0]= "Hassan";
		objarr[0][1]= "Bengaluru";
		
		objarr[1][0]= "Bengaluru";
		objarr[1][1]= "Chennai";
		
		objarr[2][0]= "Chennai";
		objarr[2][1]= "Pondicherry";
		
		objarr[3][0]= "Pondicherry";
		objarr[3][1]= "Andaman";
		
		objarr[4][0]= "Andaman";
		objarr[4][1]= "Pattaya";
		
		return objarr;
		
	}
}
