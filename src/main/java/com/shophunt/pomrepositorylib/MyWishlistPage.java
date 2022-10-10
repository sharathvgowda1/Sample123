package com.shophunt.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyWishlistPage {
	
	@FindBy(xpath = "(//th[.='my wishlist']/ancestor::table[@class='table']/tbody/descendant::a[.='Add to cart'])[1]")
	private WebElement addToCartLink;

	public WebElement getAddToCartLink() {
		return addToCartLink;
	}
	
	public MyWishlistPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void addToCartLinkClk()
	{
		addToCartLink.click();
	}
	

}
