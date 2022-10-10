package com.shophunt.product.pomtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.shophunt.genericutilities.ExcelUtility;
import com.shophunt.genericutilities.FileUtility;
import com.shophunt.genericutilities.JavaUtility;
import com.shophunt.genericutilities.WebDriverUtility;
import com.shophunt.pomrepositorylib.AdminHome;
import com.shophunt.pomrepositorylib.AdminLogin;
import com.shophunt.pomrepositorylib.InsertProductPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OR_InsertTheProductAsAnAdminTest {

	public static void main(String[] args) throws Throwable {
		ExcelUtility elib = new ExcelUtility();
		FileUtility flib = new FileUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		WebDriver driver= null;
	
		//Step: read all the necessary common data
		String URL = flib.getPropertyKeyValue("url");
		String UN = flib.getPropertyKeyValue("username");
		String PWD = flib.getPropertyKeyValue("password");
		String BROWSER = flib.getPropertyKeyValue("browser");


		//Step: launch the browser
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("Invalid browser name");
		}
		driver.manage().window().maximize();
		wlib.waitForElementInDOM(driver);
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
		WebElement msg = driver.findElement(By.xpath("//div[@class='alert alert-success']"));    //is it possible to put this xpath in POM class
		if(msg.isDisplayed())
		{
			System.out.println("Test case is pass");
		}
		else
		{
			System.out.println("Test case is fail");
		}
	}

}
