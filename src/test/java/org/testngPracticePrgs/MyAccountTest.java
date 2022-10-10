package org.testngPracticePrgs;

import java.io.IOException;

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
import com.shophunt.pomrepositorylib.UserHome;
import com.shophunt.pomrepositorylib.UserLogPage;

public class MyAccountTest extends BaseClass{
	
	@Test(retryAnalyzer = com.shophunt.genericutilities.RetryAnalyserImplementation.class)
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
	//	Assert.assertEquals('A', 'B');
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
}


