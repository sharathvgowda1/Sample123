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
import com.shophunt.pomrepositorylib.AdminHome;
import com.shophunt.pomrepositorylib.AdminLogin;
import com.shophunt.pomrepositorylib.CreateAccount;
import com.shophunt.pomrepositorylib.UserHome;
import com.shophunt.pomrepositorylib.UserLogPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateUserAccountAndVerifyInAdminModuleTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		ExcelUtility elib = new ExcelUtility();
		FileUtility flib = new FileUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		WebDriver driver = null;
		
	
		 int ran = jlib.getRandomNumber();

		//Step 1: read all the necessary common data
		String URL = flib.getPropertyKeyValue("url2");
		String URLA = flib.getPropertyKeyValue("url23");
		String BROWSER = flib.getPropertyKeyValue("browser2");
		String UNA = flib.getPropertyKeyValue("username2");
		String PWDA = flib.getPropertyKeyValue("password2");


		//Step 2: read the data from excel sheet
		String u_name = elib.getExcelData("Sheet2", 5, 3);
		String u_mail = elib.getExcelData("Sheet2", 5, 4);
		String u_mob = elib.getExcelData("Sheet2", 5, 5);
		String u_pwd = elib.getExcelData("Sheet2", 5, 6);
		String u_conpwd = elib.getExcelData("Sheet2", 5, 7);
		String dd_value = elib.getExcelData("Sheet2", 5, 8);
		String search_name = elib.getExcelData("Sheet2", 5, 9);

		
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
		driver.navigate().to(URL);
		
		//create user account
		
		UserHome uh = new UserHome(driver);
		uh.createAccount();
		
		CreateAccount ca = new CreateAccount(driver);
		ca.createUserAccount(u_name, u_mail+ran, u_mob, u_conpwd, u_pwd);
		
		
		
	/*	driver.findElement(By.xpath("//a[@href='my-account.php']")).click();
		driver.findElement(By.id("fullname")).sendKeys(u_name);
		driver.findElement(By.id("email")).sendKeys(u_mail +"_"+ ran);
		driver.findElement(By.id("contactno")).sendKeys(u_mob );
		driver.findElement(By.id("password")).sendKeys(u_pwd);
		driver.findElement(By.id("confirmpassword")).sendKeys(u_conpwd);
		driver.findElement(By.id("submit")).click();                              */
		
		wlib.swithToAlertWindowAndAccpect(driver, "You are successfully register");
		
		uh.loginLinkClk();
		ca.loginAsUser(u_mail+ran, u_pwd);
		
	/*	driver.findElement(By.xpath("//a[@href='login.php']")).click();
		driver.findElement(By.name("email")).sendKeys(u_mail + ran);
		driver.findElement(By.name("password")).sendKeys(u_pwd);
		driver.findElement(By.name("login")).click();            */
		
		//logout as user
		driver.findElement(By.xpath("//a[@href='logout.php']")).click();
		
		//navigate to admin module and login as admin
		driver.navigate().to(URLA);
		
		AdminLogin al=new AdminLogin(driver);
		al.LoginAsAdmin(UNA, PWDA);
		
		
	/*	driver.findElement(By.id("inputEmail")).sendKeys(UNA);
		driver.findElement(By.id("inputPassword")).sendKeys(PWDA);
		driver.findElement(By.name("submit")).click();                      */
		
		AdminHome ah = new AdminHome(driver);
		ah.UserLoginInfoClk();
		UserLogPage ulp = new UserLogPage(driver);
		
	/*	driver.findElement(By.xpath("//a[@href='user-logs.php']")).click();
		WebElement ele = driver.findElement(By.xpath("//select[@name='DataTables_Table_0_length']"));     */
		wlib.select(ulp.getEntriesDd(), dd_value);
		
		ulp.searchName(u_mail);
		
	//	driver.findElement(By.xpath("//input[@type='text']")).sendKeys(u_mail +"_"+ ran);
		
		ulp.lastLoginInfo(search_name);
	//	String umail = driver.findElement(By.xpath("//table[@class='datatable-1 table table-bordered table-striped  display dataTable']/tbody/tr[last()]/td[contains(.,'"+search_name+"')]")).getText();
	//	System.out.println(umail);
		String mail = u_mail + ran ;
		System.out.println(mail);
		 
		 //verification
		 if(mail.contains(search_name))
		 {
			 System.out.println("Test case is pass");
		 }
		 else
		 {
			 System.out.println("Test case is fail");
		 }

		
	}

}
