package org.testngPracticePrgs;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NavigationCitiesWithThreeArgTest {
	
	@Test(dataProvider = "dataProvider_NavigationCityNames_WithExpenditure")
	public void navigateFromCitiesToCities(String src_city, String dst_city, int price)
	{
		System.out.println("Start form " + src_city + ", to reach " + dst_city + ", the expenditure cost is "+ price);
	}
	
	@DataProvider
	public Object[][] dataProvider_NavigationCityNames_WithExpenditure()
	{
		Object[][] objarr = new Object[5][3];
		objarr[0][0]= "Hassan";
		objarr[0][1]= "Bengaluru";
		objarr[0][2]= 2500;
		
		objarr[1][0]= "Bengaluru";
		objarr[1][1]= "Chennai";
		objarr[1][2]= 5000;
		
		objarr[2][0]= "Chennai";
		objarr[2][1]= "Pondicherry";
		objarr[2][2]= 5600;
		
		objarr[3][0]= "Pondicherry";
		objarr[3][1]= "Andaman";
		objarr[3][2]= 12000;
		
		objarr[4][0]= "Andaman";
		objarr[4][1]= "Pattaya";
		objarr[4][2]= 18000;
		
		return objarr;
		
	}

}
