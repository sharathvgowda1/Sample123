package com.shophunt.product.testngtest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.shophunt.genericutilities.BaseClass;
import com.shophunt.genericutilities.ExcelUtility;
import com.shophunt.genericutilities.FileUtility;
import com.shophunt.genericutilities.JavaUtility;
import com.shophunt.genericutilities.WebDriverUtility;
import com.shophunt.pomrepositorylib.AdminHome;
import com.shophunt.pomrepositorylib.AdminLogin;
import com.shophunt.pomrepositorylib.InsertProductPage;

public class InsertProductTest extends BaseClass{
	
	@Test
	public void insertTheProductAsAnAdmin() throws IOException, Throwable
	{
		ExcelUtility elib = new ExcelUtility();
		FileUtility flib = new FileUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		
	
		//Step: read all the necessary common data
		String URL = flib.getPropertyKeyValue("url");
		String UN = flib.getPropertyKeyValue("username");
		String PWD = flib.getPropertyKeyValue("password");
		String BROWSER = flib.getPropertyKeyValue("browser");


		//Step: launch the browser
		driver.get(URL);

		//Step 4: login to app
		AdminLogin al = new AdminLogin(driver);
		al.LoginAsAdmin(UN, PWD);
		
		//Step 5: navigate to insert product
		AdminHome ah = new AdminHome(driver);
		ah.insertProductClk();
		
		//Step 6: insert product with mandatory fields
		InsertProductPage ipp = new InsertProductPage(driver);
		ipp.insertProduct();
		
		//verification
		WebElement msg = driver.findElement(By.xpath("//div[@class='alert alert-success']")); 
		
		Assert.assertTrue(msg.isDisplayed());
		
	}

}
