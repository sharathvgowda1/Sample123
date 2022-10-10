package com.shophunt.pomrepositorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLogPage {
	WebDriver driver;
	
	@FindBy(xpath="//select[@name='DataTables_Table_0_length']")
	private WebElement entriesDd;
	
	@FindBy(xpath="//input[@type='text']")
	private WebElement searchTxt;
	
	public UserLogPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public String lastLoginInfo(String name)
	{
		String acc_name = driver.findElement(By.xpath("//table[@class='datatable-1 table table-bordered table-striped  display dataTable']/tbody/tr[last()]/td[contains(.,'"+name+"')]")).getText();
		return acc_name;
	}
	
	public void searchName(String mail)
	{
		searchTxt.sendKeys(mail);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getEntriesDd() {
		return entriesDd;
	}

	public WebElement getSearchTxt() {
		return searchTxt;
	}
	
	

}
