package org.testngPracticePrgs;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.shophunt.genericutilities.BaseClass;
import com.shophunt.genericutilities.ExcelUtility;
import com.shophunt.genericutilities.FileUtility;
import com.shophunt.genericutilities.JavaUtility;
import com.shophunt.genericutilities.WebDriverUtility;
import com.shophunt.pomrepositorylib.AdminHome;
import com.shophunt.pomrepositorylib.AdminLogin;
import com.shophunt.pomrepositorylib.CategoryPage;
import com.shophunt.pomrepositorylib.UserHome;

@Listeners(com.shophunt.genericutilities.ListenerImplementation.class)

public class CreateCategoryTest extends BaseClass {

	@Test
	public void CreateCategoryAndVerifyInUserAdminModuleTest() throws IOException, InterruptedException {

		ExcelUtility elib = new ExcelUtility();
		FileUtility flib = new FileUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();

		// Step 1: read all the necessary common data
		String URLA = flib.getPropertyKeyValue("url4");
		String UNA = flib.getPropertyKeyValue("un4");
		String PWDA = flib.getPropertyKeyValue("pwd4");
		String URLU = flib.getPropertyKeyValue("url44");

		// Step 2: read the data from excel sheet
		String cat_name = elib.getExcelData("Sheet2", 7, 3);
		String cat_desc = elib.getExcelData("Sheet2", 7, 4);
		String actual_txt = elib.getExcelData("Sheet2", 7, 5);
		String search_cat = elib.getExcelData("Sheet2", 7, 6);

		// Navigate to admin url
		driver.navigate().to(URLA);

		// login to admin account
		AdminLogin al = new AdminLogin(driver);
		al.LoginAsAdmin(UNA, PWDA);

	//	Assert.fail();
	//	SoftAssert s = new SoftAssert();
	//	s.assertEquals('A', 'B');
//		Thread.sleep(2000);

		// create the category
		AdminHome ah = new AdminHome(driver);
		ah.createCategoryClk();

		CategoryPage cp = new CategoryPage(driver);
		cp.CategoryDetailsEntry(cat_name, cat_desc);

//		s.assertEquals('A', 'B');

		String txt = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		System.out.println(txt);
		System.out.println(actual_txt);

		// s.assertEquals("A", "B");
		if (txt.contains(actual_txt)) {
			System.out.println("Category is created succesfully");
		} else {
			System.out.println("Category is not created");
		}

		// logout from admin account
		ah.logoutAsAdmin();

		// navigate to application as an user
		driver.navigate().to(URLU);

		UserHome uh = new UserHome(driver);
		uh.categorySearch(search_cat);

		String actResult = uh.categorySearch(search_cat);

		String expResult = cat_name;

		Assert.assertEquals(actResult, expResult);
		// s.assertAll();
	}

}
