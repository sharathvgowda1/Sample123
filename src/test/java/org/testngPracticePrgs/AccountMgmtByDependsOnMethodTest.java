package org.testngPracticePrgs;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class AccountMgmtByDependsOnMethodTest {
	
	@Test
	public void createAccount()
	{
		System.out.println("Account has been created");
		int[] arr = {1, 2, 3};
		System.out.println(arr[2]);
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
	
	@Test(dependsOnMethods = "createAccount")
	public void createNomineeAccount()
	{
		System.out.println("Nominee account has been created for this account");
	}

}
