package com.shophunt.producttest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.shophunt.genericutilities.ExcelUtility;
import com.shophunt.genericutilities.FileUtility;
import com.shophunt.genericutilities.JavaUtility;
import com.shophunt.genericutilities.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InsertTheProductAsAnAdminTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		ExcelUtility elib = new ExcelUtility();
		FileUtility flib = new FileUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		WebDriver driver= null;
	
		//Step 1: read all the necessary common data
		String URL = flib.getPropertyKeyValue("url");
		String UN = flib.getPropertyKeyValue("username");
		String PWD = flib.getPropertyKeyValue("password");
		String BROWSER = flib.getPropertyKeyValue("browser");

		//Step 2: read the data from excel sheet
		String pr_name = elib.getExcelData("Sheet2", 3, 3);
		String pr_company = elib.getExcelData("Sheet2", 3, 4);
		String pr_price_bd = elib.getExcelData("Sheet2", 3, 5);
		String pr_price_ad = elib.getExcelData("Sheet2", 3, 6);
		String ship_price = elib.getExcelData("Sheet2", 3, 7);
		String dd_value = elib.getExcelData("Sheet2", 3, 8);
		String dd_subvalue = elib.getExcelData("Sheet2", 3, 9);
		String dd_stock = elib.getExcelData("Sheet2", 3, 10);

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
		driver.get(URL);

		//Step 4: login to app
		driver.findElement(By.id("inputEmail")).sendKeys(UN);
		driver.findElement(By.id("inputPassword")).sendKeys(PWD);
		driver.findElement(By.name("submit")).click();

		//Step 5: navigate to insert product
		driver.findElement(By.xpath("//a[@href='insert-product.php']")).click();

		//Step 6: insert product with mandatory fields
		WebElement ele = driver.findElement(By.name("category"));
		wlib.select(ele, dd_value);
		WebElement ele1 = driver.findElement(By.name("subcategory"));
		wlib.select(ele1, dd_subvalue);

		driver.findElement(By.name("productName")).sendKeys(pr_name);
		driver.findElement(By.name("productCompany")).sendKeys(pr_company);
		driver.findElement(By.name("productpricebd")).sendKeys(pr_price_bd);
		driver.findElement(By.name("productprice")).sendKeys(pr_price_ad);
		driver.findElement(By.name("productShippingcharge")).sendKeys(ship_price);
		
		WebElement ele2 = driver.findElement(By.name("productAvailability"));
		wlib.select(ele2, dd_stock);
		
		WebElement ele3 = driver.findElement(By.name("productimage1"));
		ele3.sendKeys("C:\\Users\\HP\\Desktop\\WingsofFire.jpg");
		WebElement ele4 = driver.findElement(By.name("productimage2"));
		ele4.sendKeys("C:\\Users\\HP\\Desktop\\WingsofFire.jpg");
		
		driver.findElement(By.name("submit")).click();
		
		WebElement msg = driver.findElement(By.xpath("//div[@class='alert alert-success']"));
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
