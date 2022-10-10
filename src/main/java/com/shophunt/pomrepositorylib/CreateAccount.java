package com.shophunt.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccount {
	
	@FindBy(id="fullname")
	private WebElement fullnameTxt;
	
	@FindBy(id="email")
	private WebElement emailTxt;
	
	@FindBy(id="contactno")
	private WebElement contactTxt;
	
	@FindBy(id="password")
	private WebElement pwdTxt;
	
	@FindBy(id="confirmpassword")
	private WebElement conpwdTxt;
	
	@FindBy(id="submit")
	private WebElement submitBtn;
	
	@FindBy(name="email")
	private WebElement userMailTxt;
	
	@FindBy(name="password")
	private WebElement userPassword;
	
	@FindBy(name="login")
	private WebElement loginBtn;
	
	public WebElement getUserMailTxt() {
		return userMailTxt;
	}

	public void setUserMailTxt(WebElement userMailTxt) {
		this.userMailTxt = userMailTxt;
	}

	public WebElement getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(WebElement userPassword) {
		this.userPassword = userPassword;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public void setLoginBtn(WebElement loginBtn) {
		this.loginBtn = loginBtn;
	}

	public CreateAccount(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getFullnameTxt() {
		return fullnameTxt;
	}

	public WebElement getEmailTxt() {
		return emailTxt;
	}

	public WebElement getContactTxt() {
		return contactTxt;
	}

	public WebElement getPwdTxt() {
		return pwdTxt;
	}

	public WebElement getConpwdTxt() {
		return conpwdTxt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	public void createUserAccount(String F_name, String Email, String C_no, String pwd, String C_pwd)
	{
		fullnameTxt.sendKeys(F_name);
		emailTxt.sendKeys(Email);
		contactTxt.sendKeys(C_no);
		pwdTxt.sendKeys(pwd);
		conpwdTxt.sendKeys(C_pwd);
		submitBtn.click();
	}
	
	public void loginAsUser(String U_name, String U_pwd)
	{
		userMailTxt.sendKeys(U_name);
		userPassword.sendKeys(U_pwd);
		loginBtn.click();
	}
	
}
