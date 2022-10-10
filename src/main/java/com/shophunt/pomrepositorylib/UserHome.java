package com.shophunt.pomrepositorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserHome {
	WebDriver driver;
	
	@FindBy(xpath="//a[@href='my-account.php']")
	private WebElement myAccountLink;
	
	@FindBy(xpath="//a[@href='my-wishlist.php']")
	private WebElement wishlistLink;
	
	@FindBy(xpath="//div[@class='cnt-account']/descendant::a[@href='my-cart.php' and .='My Cart']")
	private WebElement mycartLink;
	
	@FindBy(xpath="//a[@href='login.php']")
	private WebElement loginLink;
	
	@FindBy(name="product")
	private WebElement searchField;
	
	@FindBy(xpath="//button[@class='search-button']")
	private WebElement searchBtn;
	
	@FindBy(xpath="//a[@href='logout.php']")
	private WebElement logoutBtn;
	
	@FindBy(xpath = "(//div[@class='col-sm-6 col-md-4 wow fadeInUp animated']/child::div[@class='products']/descendant::a[@class='add-to-cart' and @title='Wishlist' ])[1]")
	private WebElement wishlistIcon;
	
	public WebElement getWishlistIcon() {
		return wishlistIcon;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public UserHome(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	public WebElement getMyAccountLink() {
		return myAccountLink;
	}

	public WebElement getWishlistLink() {
		return wishlistLink;
	}

	public WebElement getMycartLink() {
		return mycartLink;
	}

	public WebElement getLoginLink() {
		return loginLink;
	}

	public WebElement getSearchField() {
		return searchField;
	}
	
	public WebElement getSearchbtn() {
		return searchBtn;
	}

	
	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

	public void createAccount()
	{
		myAccountLink.click();
	}
	
	public void wishlistclk()
	{
		wishlistLink.click();
	}
	
	public void mycartClk()
	{
		mycartLink.click();
	}
	
	public void loginLinkClk()
	{
		loginLink.click();
	}
	
	
	public void searchProduct(String P_name)
	{
		searchField.sendKeys(P_name);
		searchBtn.click();
	}
	
	public void wishlistIconClk()
	{
		wishlistIcon.click();
	}
	
	public void logoutAsUser()
	{
		logoutBtn.click();
	}
	
	public String categorySearch(String category_name)
	{
	String cname = driver.findElement(By.xpath("//a[@class='dropdown-toggle' and contains(.,'"+category_name+"')]")).getText();
	return cname;
	}

}
