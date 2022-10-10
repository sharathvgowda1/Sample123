package com.shophunt.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount {

	@FindBy(xpath = "//input[@type='email']")
	private WebElement buyermail;
	
	@FindBy(xpath = "//input[@id='contactno']")
	private WebElement buyercontact;
	
	@FindBy(xpath = "//div[@class='header-top-inner']/descendant::a[@href='my-account.php']")
	private WebElement myaccountlink;
	
	public WebElement getMyaccountlink() {
		return myaccountlink;
	}

	public WebElement getBuyermail() {
		return buyermail;
	}

	public WebElement getBuyercontact() {
		return buyercontact;
	}

	public MyAccount(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void myAccountClk()
	{
		myaccountlink.click();
	}
}
