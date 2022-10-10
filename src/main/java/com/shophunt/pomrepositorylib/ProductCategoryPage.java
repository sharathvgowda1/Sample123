package com.shophunt.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCategoryPage {
	
	@FindBy(xpath = "(//div[@class='col-sm-6 col-md-4 wow fadeInUp animated']/child::div[@class='products']/descendant::a[@class='add-to-cart' and @title='Wishlist' ])[1]")
	private WebElement wishlistIcon;

	public WebElement getWishlistIcon() {
		return wishlistIcon;
	}
	
	public ProductCategoryPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void wishListIconClk()
	{
		wishlistIcon.click();
	}

}
