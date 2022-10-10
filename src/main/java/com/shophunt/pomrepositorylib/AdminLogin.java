package com.shophunt.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLogin {
	
	@FindBy(id="inputEmail")
	private WebElement adminUnTxt;
	
	@FindBy(id="inputPassword")
	private WebElement adminPwdTxt;
	
	@FindBy(name="submit")
	private WebElement adminSubmitBtn;

	public WebElement getAdminUnTxt() {
		return adminUnTxt;
	}

	public WebElement getAdminPwdTxt() {
		return adminPwdTxt;
	}

	public WebElement getAdminSubmitBtn() {
		return adminSubmitBtn;
	}
	
	public AdminLogin(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void LoginAsAdmin(String UN, String PWD)
	{
		adminUnTxt.sendKeys(UN);
		adminPwdTxt.sendKeys(PWD);
		adminSubmitBtn.click();
	}

}
