package org.xpath.assignment;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VtigerWebTableRowCount {

	public static void main(String[] args) throws IOException {
		WebDriver driver = null;

		//Step 1: read all the necessary common data
		FileInputStream fis = new FileInputStream(".\\Data\\commonData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String URL2 = prop.getProperty("url2");
		String UN2 = prop.getProperty("username2");
		String PWD2 = prop.getProperty("password2");
		String BROWSER2 = prop.getProperty("browser2");
		
		//Step 2: launch the browser
				if(BROWSER2.equalsIgnoreCase("chrome"))
				{
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
				}
				else if(BROWSER2.equalsIgnoreCase("firefox"))
				{
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
				}
				else
				{
					System.out.println("Invalid browser name");
				}
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.get(URL2);
				
				//Step 3: login to app
				driver.findElement(By.xpath("//input[@type='text']")).sendKeys(UN2);
				driver.findElement(By.xpath("//input[@type='password']")).sendKeys(PWD2);
				driver.findElement(By.xpath("//input[@type='submit']")).click();
				driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index' and contains(.,'Organizations')]")).click();
				
				//Step 4:to find the total row count of organizations
			/*	List<WebElement> lst = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr"));
				System.out.println(lst.size());
				
				//Step 5; to find total column count
				List<WebElement> lst1 = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[1]/td"));
				System.out.println(lst1.size());     */
				
				//Step6 fetch organization name
				List<WebElement> lst3 = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]"));
				
				for (WebElement wb : lst3) {
					System.out.println(wb.getText());
					
				}
				System.out.println("THIS IS THE CODE FROM MAIN wala CLASS");

	}

}
