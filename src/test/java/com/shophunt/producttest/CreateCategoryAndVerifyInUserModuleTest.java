package com.shophunt.producttest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.shophunt.genericutilities.ExcelUtility;
import com.shophunt.genericutilities.FileUtility;
import com.shophunt.genericutilities.JavaUtility;
import com.shophunt.genericutilities.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCategoryAndVerifyInUserModuleTest {
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
		driver.findElement(By.id("inputEmail")).sendKeys(UNA);
		driver.findElement(By.id("inputPassword")).sendKeys(PWDA);
		driver.findElement(By.name("submit")).click();

		//create the category
		driver.findElement(By.xpath("//a[@href='category.php']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter category Name']")).sendKeys(cat_name);
		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys(cat_desc);
		driver.findElement(By.xpath("//button[@type='submit']")).click();

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
		driver.findElement(By.xpath("//ul[@class='widget widget-menu unstyled']/descendant::a[@href='logout.php']")).click();

		// navigate to application as an user
		driver.navigate().to(URLU);

		String cat_text = driver.findElement(By.xpath("//a[@class='dropdown-toggle' and contains(.,'Jewellery')]")).getText();
		
		//validation
		if(cat_name.equalsIgnoreCase(cat_text))
		{
			System.out.println("Test case is Pass");
		}
		else
		{
			System.out.println("Test case is fail");
		}
	}
}