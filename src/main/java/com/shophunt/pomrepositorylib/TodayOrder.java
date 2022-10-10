package com.shophunt.pomrepositorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TodayOrder {
	
	WebDriver driver;

	@FindBy(xpath = "//select[@name='DataTables_Table_0_length']")
	private WebElement searchEntityDd;
	
	@FindBy(xpath = "//input[@type='text']")
	private WebElement searchTxt;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getSearchEntityDd() {
		return searchEntityDd;
	}

	public WebElement getSearchTxt() {
		return searchTxt;
	}

	public TodayOrder(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public String searchLastOrder(String buyer_mail) 
	{
		 String cust_name = driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr[last()]/td[contains(.,'"+buyer_mail+"')]")).getText();
		 return cust_name;
		 
	}
	
	public void searchBuyerTxt(String name)
	{
		searchTxt.sendKeys(name);
	}
	
}
