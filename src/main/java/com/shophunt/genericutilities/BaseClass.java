package com.shophunt.genericutilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.shophunt.pomrepositorylib.AdminHome;
import com.shophunt.pomrepositorylib.AdminLogin;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver;
	public static WebDriver sdriver;

	// object creation for library files
	FileUtility flib = new FileUtility();
	ExcelUtility elib = new ExcelUtility();
	JavaUtility jlib = new JavaUtility();
	WebDriverUtility wlib = new WebDriverUtility();
	AdminLogin al = new AdminLogin(driver);
	AdminHome ah = new AdminHome(driver);

	@BeforeSuite
	public void connectToDB() {
		System.out.println("************Connect to DataBase*************");
	}
	
//for cross browser execution we use @Parameters
//	@Parameters("browser")
	
	@BeforeClass
	public void browserLaunch() throws IOException {
		System.out.println("Launch the browser");
		String browser = flib.getPropertyKeyValue("browser_name");
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		wlib.waitForElementInDOM(driver);
		sdriver = driver;
	}


	@AfterClass
	public void closeBrowser() {
		// to close the browser
		System.out.println("Close the browser");
		driver.quit();
	}

	@AfterSuite
	public void closeTheDBConnection() {
		// Close the DataBase connection
		System.out.println("*******DataBase Connection Closed********");
	}
}
