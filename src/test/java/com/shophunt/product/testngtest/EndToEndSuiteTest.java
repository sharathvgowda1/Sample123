package com.shophunt.product.testngtest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
import com.shophunt.pomrepositorylib.CategoryPage;
import com.shophunt.pomrepositorylib.CreateAccount;
import com.shophunt.pomrepositorylib.InsertProductPage;
import com.shophunt.pomrepositorylib.MyAccount;
import com.shophunt.pomrepositorylib.MyCartPage;
import com.shophunt.pomrepositorylib.MyWishlistPage;
import com.shophunt.pomrepositorylib.TodayOrder;
import com.shophunt.pomrepositorylib.UserHome;
import com.shophunt.pomrepositorylib.UserLogPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EndToEndSuiteTest extends BaseClass{
	
	
	@Test
	public void insertTheProductAsAnAdmin() throws IOException, Throwable
	{
		ExcelUtility elib = new ExcelUtility();
		FileUtility flib = new FileUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		
	
		//Step: read all the necessary common data
		String URL = flib.getPropertyKeyValue("url");
		String UN = flib.getPropertyKeyValue("username");
		String PWD = flib.getPropertyKeyValue("password");
		String BROWSER = flib.getPropertyKeyValue("browser");


		//Step: launch the browser
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
		WebElement msg = driver.findElement(By.xpath("//div[@class='alert alert-success']")); 
		
		Assert.assertTrue(msg.isDisplayed());
		
	}

	
	
	
	@Test
	public void CreateCategoryAndVerifyInUserAdminModuleTest() throws IOException
	{
		ExcelUtility elib = new ExcelUtility();
		FileUtility flib = new FileUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();


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

		
		//Navigate to admin url
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
		
		String actResult = uh.categorySearch(search_cat);
		
		String expResult = cat_name;
		
		Assert.assertEquals(actResult, expResult);
				
	}
	
	
	
	@Test
	public void createUserAccountAndVerifyAdminModule() throws IOException
	{
		ExcelUtility elib = new ExcelUtility();
		FileUtility flib = new FileUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		
		//for random number
		 int ran = jlib.getRandomNumber();

		//Step 1: read all the necessary common data
		String URL = flib.getPropertyKeyValue("url2");
		String URLA = flib.getPropertyKeyValue("url23");
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

		//navigate to application
		driver.navigate().to(URL);
		
		//click on my account link on user home page
		UserHome uh = new UserHome(driver);
		uh.createAccount();
		
		//create an account in create account page
		CreateAccount ca = new CreateAccount(driver);
		ca.createUserAccount(u_name, u_mail+ran, u_mob, u_pwd, u_conpwd);
		
		wlib.swithToAlertWindowAndAccpect(driver, "You are successfully register");
		
		//login to user account
		uh.loginLinkClk();
		ca.loginAsUser(u_mail+ran, u_pwd);
		
		//logout as user
		uh.logoutAsUser();
		
		//navigate to admin module 
		driver.navigate().to(URLA);
		
		//login to user account
		AdminLogin al=new AdminLogin(driver);
		al.LoginAsAdmin(UNA, PWDA);
		
		//navigate to UserLog page 
		AdminHome ah = new AdminHome(driver);
		ah.UserLoginInfoClk();
		
		UserLogPage ulp = new UserLogPage(driver);
		wlib.select(ulp.getEntriesDd(), dd_value);
		
		ulp.searchName(u_mail);
		
		ulp.lastLoginInfo(search_name);
		
		String actResult = ulp.lastLoginInfo(search_name);
		
		String expResult = u_mail + ran;
		
		//validation
		
		Assert.assertEquals(actResult, expResult);
	
	}


	
	
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
