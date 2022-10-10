package com.shophunt.product.pomtest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.shophunt.genericutilities.ExcelUtility;
import com.shophunt.genericutilities.FileUtility;
import com.shophunt.genericutilities.JavaUtility;
import com.shophunt.genericutilities.WebDriverUtility;
import com.shophunt.pomrepositorylib.AdminHome;
import com.shophunt.pomrepositorylib.AdminLogin;
import com.shophunt.pomrepositorylib.CategoryPage;
import com.shophunt.pomrepositorylib.UserHome;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OR_CreateCategoryAndVerifyInUserModuleTest {
	public static void main(String[] args) throws IOException {
		ExcelUtility elib = new ExcelUtility();
		FileUtility flib = new FileUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		WebDriver driver = null;


		//Step 1: read all the necessary common data
		String URLA = flib.getPropertyKeyValue("url4");
		String UNA = flib.getPropertyKeyValue("un4");
		String PWDA = flib.getPropertyKeyValue("pwd4");
		String URLU = flib.getPropertyKeyValue("url44");
		String BROWSER = flib.getPropertyKeyValue("browser4");

		//Step 2: read the data from excel sheet
		String cat_name = elib.getExcelData("Sheet2", 7, 3);
		String cat_desc = elib.getExcelData("Sheet2", 7, 4);
		String actual_txt = elib.getExcelData("Sheet2", 7, 5);
		String search_cat = elib.getExcelData("Sheet2", 7, 6);

		
		//Step 3: launch the browser
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
		driver.navigate().to(URLA);

		//login to admin account
		AdminLogin al = new AdminLogin(driver);
		al.LoginAsAdmin(UNA, PWDA);
		
		//create the category
		AdminHome ah = new AdminHome(driver);
		ah.createCategoryClk();
		
		CategoryPage cp = new CategoryPage(driver);
		cp.CategoryDetailsEntry(cat_name, cat_desc);
		
		String txt = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		System.out.println(txt);
		System.out.println(actual_txt);
		if(txt.contains(actual_txt))
		{
			System.out.println("Category is created succesfully");
		}
		else
		{
			System.out.println("Category is not created");
		}

		//logout from admin account
		ah.logoutAsAdmin();
		
		// navigate to application as an user
		driver.navigate().to(URLU);

		UserHome uh = new UserHome(driver);
		uh.categorySearch(search_cat);
		
		//validation
		if(cat_name.equalsIgnoreCase(search_cat))               //how to validate
		{
			System.out.println("Test case is Pass");
		}
		else
		{
			System.out.println("Test case is fail");
		}
	}
}