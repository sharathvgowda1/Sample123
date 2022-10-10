package org.testngPracticePrgs;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class AccountManagementTest {
	
	@Test
	public void createAccount()
	{
		System.out.println("Account has been created");
	}
	
	@Test
	public void accountEdit()
	{
		Reporter.log("Account has been edited", true);
	}
	
	@Test
	public void accountDeleted()
	{
		System.out.println("Account has been deleted");
	}
	
	@Test
	public void createNomineeAccount()
	{
		System.out.println("Nominee account has been created for this account");
	}
}
