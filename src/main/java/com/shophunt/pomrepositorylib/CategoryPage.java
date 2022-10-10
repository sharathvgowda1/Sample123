package com.shophunt.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryPage {
	
	@FindBy(xpath="//input[@placeholder='Enter category Name']")
	private WebElement categoryTxt;
	
	@FindBy(xpath="//textarea[@name='description']")
	private WebElement descriptionTxt;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement submitBtn;

	public WebElement getCategoryTxt() {
		return categoryTxt;
	}

	public WebElement getDescriptionTxt() {
		return descriptionTxt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	public CategoryPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void CategoryDetailsEntry(String CatName, String Desc)
	{
		categoryTxt.sendKeys(CatName);
		descriptionTxt.sendKeys(Desc);
		submitBtn.click();
	}
	

}
