package com.shophunt.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHome {
	
	@FindBy(xpath="//a[@href='#togglePages']")
	private WebElement orderMgmtLink;
	
	@FindBy(xpath="//a[@href='todays-orders.php']")
	private WebElement todayOrderLink;
	
	@FindBy(xpath="//a[@href='category.php']")
	private WebElement createCategoryLink;
	
	@FindBy(xpath="//a[@href='insert-product.php']")
	private WebElement insertProductLink;
	
	@FindBy(xpath="//a[@href='user-logs.php']")
	private WebElement userLoginInfoLink;
	
	@FindBy(xpath="//ul[@class='widget widget-menu unstyled']/descendant::a[@href='logout.php']")
	private WebElement logoutLink;
	
	public AdminHome(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrderMgmtLink() {
		return orderMgmtLink;
	}

	public WebElement getTodayOrderLink() {
		return todayOrderLink;
	}

	public WebElement getCreateCategoryLink() {
		return createCategoryLink;
	}

	public WebElement getInsertProductLink() {
		return insertProductLink;
	}

	public WebElement getUserLoginInfoLink() {
		return userLoginInfoLink;
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}

	public void ordermgmtClk()
	{
		orderMgmtLink.click();
	}
	
	public void todayOrderClk()
	{
		todayOrderLink.click();
	}
	
	public void createCategoryClk()
	{
		createCategoryLink.click();
	}
	
	public void insertProductClk()
	{
		insertProductLink.click();
	}
	
	public void UserLoginInfoClk()
	{
		userLoginInfoLink.click();
	}
	
	public void logoutAsAdmin()
	{
		logoutLink.click();
	}

}
