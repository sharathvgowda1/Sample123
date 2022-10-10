package com.shophunt.pomrepositorylib;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shophunt.genericutilities.ExcelUtility;
import com.shophunt.genericutilities.WebDriverUtility;

public class InsertProductPage {
	
	ExcelUtility elib = new ExcelUtility();
	WebDriverUtility wlib = new WebDriverUtility();
	
	public void insertProduct() throws Throwable, IOException
	{
		
		wlib.select(categoryDd, elib.getExcelData("Sheet2", 3, 8));
		wlib.select(subCategoryDd, elib.getExcelData("Sheet2", 3, 9));
		productNameTxt.sendKeys(elib.getExcelData("Sheet2", 3, 3));
		productCompanyTxt.sendKeys(elib.getExcelData("Sheet2", 3, 4));
		productPriceBdTxt.sendKeys(elib.getExcelData("Sheet2", 3, 5));
		productPriceAdTxt.sendKeys(elib.getExcelData("Sheet2", 3, 6));
		shipChargeTxt.sendKeys(elib.getExcelData("Sheet2", 3, 7));
		wlib.select(productAvailDd, elib.getExcelData("Sheet2", 3, 10));
		pImage1.sendKeys(elib.getExcelData("Sheet2", 3, 11));
		pImage2.sendKeys(elib.getExcelData("Sheet2", 3, 12));
		submitBtn.click(); 
		
	}
	
	@FindBy(name="category")
	private WebElement categoryDd;
	
	@FindBy(name="subcategory")
	private WebElement subCategoryDd;
	
	@FindBy(name="productName")
	private WebElement productNameTxt;
	
	@FindBy(name="productCompany")
	private WebElement productCompanyTxt;
	
	@FindBy(name="productpricebd")
	private WebElement productPriceBdTxt;
	
	@FindBy(name="productprice")
	private WebElement productPriceAdTxt;
	
	@FindBy(name="productShippingcharge")
	private WebElement shipChargeTxt;
	
	@FindBy(name="productAvailability")
	private WebElement productAvailDd;
	
	@FindBy(name="productimage1")
	private WebElement pImage1;
	
	@FindBy(name="productimage2")
	private WebElement pImage2;
	
	@FindBy(name="submit")
	private WebElement submitBtn;

	public WebElement getCategoryDd() {
		return categoryDd;
	}

	public WebElement getSubCategoryDd() {
		return subCategoryDd;
	}

	public WebElement getProductNameTxt() {
		return productNameTxt;
	}

	public WebElement getProductCompanyTxt() {
		return productCompanyTxt;
	}

	public WebElement getProductPriceBdTxt() {
		return productPriceBdTxt;
	}

	public WebElement getProductPriceAdTxt() {
		return productPriceAdTxt;
	}

	public WebElement getShipChargeTxt() {
		return shipChargeTxt;
	}

	public WebElement getProductAvailDd() {
		return productAvailDd;
	}

	public WebElement getpImage1() {
		return pImage1;
	}

	public WebElement getpImage2() {
		return pImage2;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public InsertProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
}
