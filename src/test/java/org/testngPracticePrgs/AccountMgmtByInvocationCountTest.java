package org.testngPracticePrgs;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class AccountMgmtByInvocationCountTest {

	//the default value of invocation count is 1
	//if we put the invocation count less then 1, then that case will be skipped off
	@Test
	public void createAccount()
	{
		System.out.println("Account has been created");
	}
	
	@Test(invocationCount = 2)
	public void accountEdit()
	{
		Reporter.log("Account has been edited", true);
	}
	
	@Test
	public void accountDeleted()
	{
		System.out.println("Account has been deleted");
	}
	
	@Test(invocationCount = 4)
	public void createNomineeAccount()
	{
		System.out.println("Nominee account has been created for this account");
	}
}
