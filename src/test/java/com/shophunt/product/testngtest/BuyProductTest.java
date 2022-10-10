package com.shophunt.product.testngtest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.shophunt.genericutilities.BaseClass;
import com.shophunt.genericutilities.ExcelUtility;
import com.shophunt.genericutilities.FileUtility;
import com.shophunt.genericutilities.JavaUtility;
import com.shophunt.genericutilities.WebDriverUtility;
import com.shophunt.pomrepositorylib.AdminHome;
import com.shophunt.pomrepositorylib.AdminLogin;
import com.shophunt.pomrepositorylib.CreateAccount;
import com.shophunt.pomrepositorylib.MyAccount;
import com.shophunt.pomrepositorylib.MyCartPage;
import com.shophunt.pomrepositorylib.MyWishlistPage;
import com.shophunt.pomrepositorylib.TodayOrder;
import com.shophunt.pomrepositorylib.UserHome;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BuyProductTest extends BaseClass{
	
	@Test
	public void buyTheProductAndVerifyInAdminModule() throws IOException
	{
		
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
		String dd_value = elib.getExcelData("Sheet2", 1, 14);
		String mail_id = elib.getExcelData("Sheet2", 1, 15);
		
		//launch the browser
		
		driver.manage().window().maximize();
		driver.navigate().to(URL1);

		//login to application
		UserHome uh = new UserHome(driver);
		uh.loginLinkClk();
		
		CreateAccount ca = new CreateAccount(driver);
		ca.loginAsUser(UN1, PWD1);
		
		MyAccount ma = new MyAccount(driver);
		ma.myAccountClk();
		String mail = ma.getBuyermail().getAttribute("value");
		System.out.println(mail);
		String mob_num = ma.getBuyercontact().getAttribute("value");
		System.out.println(mob_num);
		String expResult = mail+"/"+mob_num;
		System.out.println(expResult);
		

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
		
		//login to admin module
		driver.navigate().to(URL11);
		
		AdminLogin al = new AdminLogin(driver);
		al.LoginAsAdmin(UN2, PWD2);
		
		AdminHome ah = new AdminHome(driver);
		ah.ordermgmtClk();
		ah.todayOrderClk();
		
		
		TodayOrder to = new TodayOrder(driver);
		wlib.select(to.getSearchEntityDd(), dd_value);
		
		to.searchBuyerTxt(mail_id);
		
		String actResult = to.searchLastOrder(mail_id);
		
		
		//logout as an admin
		ah.logoutAsAdmin();
		
		//validation
		Assert.assertEquals(expResult, actResult);
	}

}
