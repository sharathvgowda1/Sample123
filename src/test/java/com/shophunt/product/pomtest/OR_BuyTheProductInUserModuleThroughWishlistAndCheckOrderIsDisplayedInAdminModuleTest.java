package com.shophunt.product.pomtest;

import java.io.IOException;

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
import com.shophunt.pomrepositorylib.MyCartPage;
import com.shophunt.pomrepositorylib.MyWishlistPage;
import com.shophunt.pomrepositorylib.TodayOrder;
import com.shophunt.pomrepositorylib.UserHome;

import io.github.bonigarcia.wdm.WebDriverManager;


public class OR_BuyTheProductInUserModuleThroughWishlistAndCheckOrderIsDisplayedInAdminModuleTest {

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
		String dd_value = elib.getExcelData("Sheet2", 1, 14);
		String mail_id = elib.getExcelData("Sheet2", 1, 15);
		
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
		UserHome uh = new UserHome(driver);
		uh.loginLinkClk();
		
		CreateAccount ca = new CreateAccount(driver);
		ca.loginAsUser(UN1, PWD1);
		

		//search and buy the product
		uh.searchProduct(PR_NAME);
		uh.wishlistIconClk();
		uh.wishlistclk();
		
		
		MyWishlistPage mw = new MyWishlistPage(driver);
		mw.addToCartLinkClk();
		
		uh.mycartClk();
		
		MyCartPage mc = new MyCartPage(driver);
		mc.enterBillAddFeilds();
		
		wlib.swithToAlertWindowAndAccpect(driver, "Billing Address has been updated");
		
		mc.shipAddFeilds();
		

		wlib.swithToAlertWindowAndAccpect(driver, "Shipping Address has been updated");
		
		mc.checkOutClk();
		
		//logout as user
		uh.logoutAsUser();
		
		//login to admin modulexpath
		driver.navigate().to(URL11);
		
		AdminLogin al = new AdminLogin(driver);
		al.LoginAsAdmin(UN2, PWD2);
		
		AdminHome ah = new AdminHome(driver);
		ah.ordermgmtClk();
		ah.todayOrderClk();
		
		
		//validation
		TodayOrder to = new TodayOrder(driver);
		wlib.select(to.getSearchEntityDd(), dd_value);
		
		to.searchBuyerTxt(mail_id);
		
		to.searchLastOrder(mail_id);
		
		
		//logout as an admin
		ah.logoutAsAdmin();
		
		if(UN1.contains(mail_id))
		{
			System.out.println("Test Case is Pass");
		}
		else
		{
			System.out.println("Test Case id Fail");
		}	  
	}
}
