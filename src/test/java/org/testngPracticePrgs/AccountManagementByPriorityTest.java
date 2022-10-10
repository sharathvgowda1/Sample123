package org.testngPracticePrgs;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class AccountManagementByPriorityTest {
	
	// the default value of priority is 0 but if we put a priority in negative integer it works on ascending order
	//If priority value is same then it execute based on Alphabetical order(ASCII) values 
	
	@Test(priority = -1)
	public void createAccount()
	{
		System.out.println("Account has been created");
	}
	
	@Test(priority = 1)
	public void accountEdit()
	{
		Reporter.log("Account has been edited", true);
	}
	
	@Test(priority = 2)
	public void accountDeleted()
	{
		System.out.println("Account has been deleted");
	}
	
	@Test(priority = 0)
	public void createNomineeAccount()
	{
		System.out.println("Nominee account has been added for this account");
	}

}
