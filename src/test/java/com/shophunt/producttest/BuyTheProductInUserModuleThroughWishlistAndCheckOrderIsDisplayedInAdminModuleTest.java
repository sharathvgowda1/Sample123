package com.shophunt.producttest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.shophunt.genericutilities.ExcelUtility;
import com.shophunt.genericutilities.FileUtility;
import com.shophunt.genericutilities.JavaUtility;
import com.shophunt.genericutilities.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BuyTheProductInUserModuleThroughWishlistAndCheckOrderIsDisplayedInAdminModuleTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver = null;
		ExcelUtility elib = new ExcelUtility();
		FileUtility flib = new FileUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();

		//read all the  common necessary data
		String URL1 = flib.getPropertyKeyValue("url1");
		String URL11 = flib.getPropertyKeyValue("url11");
		String BROWSER1 = flib.getPropertyKeyValue("browser1");
		String UN2 = flib.getPropertyKeyValue("username1");
		String PWD2 = flib.getPropertyKeyValue("password1");

		//read all the test data from excel
		String UN1 = elib.getExcelData("Sheet2", 1, 3);
		String PWD1 = elib.getExcelData("Sheet2", 1, 4);
		String PR_NAME = elib.getExcelData("Sheet2", 1, 5);
		String B_add = elib.getExcelData("Sheet2", 1, 6);
		String B_state = elib.getExcelData("Sheet2", 1, 7);
		String B_city = elib.getExcelData("Sheet2", 1, 8);
		String B_pin = elib.getExcelData("Sheet2", 1, 9);
		String S_add = elib.getExcelData("Sheet2", 1, 10);
		String S_state = elib.getExcelData("Sheet2", 1, 11);
		String S_city = elib.getExcelData("Sheet2", 1, 12);
		String S_pin = elib.getExcelData("Sheet2", 1, 13);

		//launch the browser
		if(BROWSER1.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(BROWSER1.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else
		{
			System.out.println("invalid browser type");
		}
		driver.manage().window().maximize();
		wlib.waitForElementInDOM(driver);
		driver.navigate().to(URL1);

		//login to application
		driver.findElement(By.xpath("//a[@href='login.php']")).click();
		driver.findElement(By.name("email")).sendKeys(UN1);
		driver.findElement(By.name("password")).sendKeys(PWD1);
		driver.findElement(By.name("login")).click();

		//search and buy the product
		driver.findElement(By.name("product")).sendKeys(PR_NAME);
		driver.findElement(By.xpath("//button[@class='search-button']")).click();
		driver.findElement(By.xpath("//a[@href='category.php?pid=21&&action=wishlist']")).click();	
		driver.findElement(By.xpath("//a[@href='my-wishlist.php']")).click();
		driver.findElement(By.xpath("//a[@href='my-wishlist.php?page=product&action=add&id=21']")).click();
		driver.findElement(By.xpath("//div[@class='cnt-account']/descendant::a[@href='my-cart.php' and .='My Cart']")).click();	
		WebElement ele = driver.findElement(By.xpath("//textarea[@name='billingaddress']"));
		ele.clear();
		ele.sendKeys(B_add);
		WebElement ele1 = driver.findElement(By.id("bilingstate"));
		ele1.clear();
		ele1.sendKeys(B_state);
		WebElement ele3 = driver.findElement(By.id("billingcity"));
		ele3.clear();
		ele3.sendKeys(B_city);
		WebElement ele4 = driver.findElement(By.id("billingpincode"));
		ele4.clear();
		ele4.sendKeys(B_pin);
		driver.findElement(By.xpath("//span[.='Shipping Address']/ancestor::table[@class='table table-bordered']/descendant::button[.='Update']")).click();
		
		wlib.swithToAlertWindowAndAccpect(driver, "Billing Address has been updated");
		
		WebElement ele5 = driver.findElement(By.xpath("//textarea[@name='shippingaddress']"));
		ele5.clear();
		ele5.sendKeys(S_add);
		WebElement ele6 = driver.findElement(By.id("shippingstate"));
		ele6.clear();
		ele6.sendKeys(S_state);
		WebElement ele7 = driver.findElement(By.id("shippingcity"));
		ele7.clear();
		ele7.sendKeys(S_city);
		WebElement ele8 = driver.findElement(By.id("shippingpincode"));
		ele8.clear();
		ele8.sendKeys(S_pin);
		driver.findElement(By.xpath("//span[.='Billing Address']/ancestor::table[@class='table table-bordered']/descendant::button[@type='submit']")).click();
	
		wlib.swithToAlertWindowAndAccpect(driver, "Shipping Address has been updated");
		
		driver.findElement(By.xpath("//button[.='PROCCED TO CHEKOUT']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		//logout as user
		driver.findElement(By.xpath("//a[@href='logout.php']")).click();
		
		//login to admin module
		driver.navigate().to(URL11);
		driver.findElement(By.id("inputEmail")).sendKeys(UN2);
		driver.findElement(By.id("inputPassword")).sendKeys(PWD2);
		driver.findElement(By.name("submit")).click();
		
		driver.findElement(By.xpath("//a[@href='#togglePages']")).click();
		driver.findElement(By.xpath("//a[@href='todays-orders.php']")).click();
		
		//validation
		WebElement res1 = driver.findElement(By.xpath("//table/tbody/tr[1]/td[.='ram123@gmail.com/9876543210']"));
		String val = res1.getText();
		System.out.println(val);
		System.out.println(UN1);
		
		//logout as an admin
		driver.findElement(By.xpath("//ul[@class='widget widget-menu unstyled']/descendant::a[@href='logout.php']")).click();
		
		if(val.contains(UN1))
		{
			System.out.println("Test Case is Pass");
		}
		else
		{
			System.out.println("Test Case id Fail");
		}	
	}

}
