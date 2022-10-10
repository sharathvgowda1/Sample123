package com.shophunt.pomrepositorylib;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shophunt.genericutilities.ExcelUtility;

public class MyCartPage {
	


	ExcelUtility elib = new ExcelUtility();
	
	public void enterBillAddFeilds() throws EncryptedDocumentException, IOException
	{
		billAddTxt.clear();
		billAddTxt.sendKeys(elib.getExcelData("Sheet2", 1, 6));
		billStateTxt.clear();
		billStateTxt.sendKeys(elib.getExcelData("Sheet2", 1, 7));
		billCityTxt.clear();
		billCityTxt.sendKeys(elib.getExcelData("Sheet2", 1, 8));
		billPinCodeTxt.clear();
		billPinCodeTxt.sendKeys(elib.getExcelData("Sheet2", 1, 9));
		billUpdatebtn.click();
	}
	
	public void shipAddFeilds() throws EncryptedDocumentException, IOException
	{
		shipAddTxt.clear();
		shipAddTxt.sendKeys(elib.getExcelData("Sheet2", 1, 10));
		shipStateTxt.clear();
		shipStateTxt.sendKeys(elib.getExcelData("Sheet2", 1, 11));
		shipCityTxt.clear();
		shipCityTxt.sendKeys(elib.getExcelData("Sheet2", 1, 12));
		shipPincodeTxt.clear();
		shipPincodeTxt.sendKeys(elib.getExcelData("Sheet2", 1, 13));
		shipUpdateBtn.click();
	}
	
	@FindBy(xpath = "//textarea[@name='billingaddress']")
	private WebElement billAddTxt;
	
	@FindBy(id = "bilingstate")
	private WebElement billStateTxt;
	
	@FindBy(id = "billingcity")
	private WebElement billCityTxt;
	
	@FindBy(id = "billingpincode")
	private WebElement billPinCodeTxt;
	
	@FindBy(xpath = "//span[.='Shipping Address']/ancestor::table[@class='table table-bordered']/descendant::button[.='Update']")
	private WebElement billUpdatebtn;
	
	@FindBy(xpath = "//textarea[@name='shippingaddress']")
	private WebElement shipAddTxt;
	
	@FindBy(id = "shippingstate")
	private WebElement shipStateTxt;
	
	@FindBy(id = "shippingcity")
	private WebElement shipCityTxt;
	
	@FindBy(id = "shippingpincode")
	private WebElement shipPincodeTxt;
	
	@FindBy(xpath = "//span[.='Billing Address']/ancestor::table[@class='table table-bordered']/descendant::button[@type='submit']")
	private WebElement shipUpdateBtn;
	
	@FindBy(xpath = "//button[.='PROCCED TO CHEKOUT']")
	private WebElement checkOutBtn;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement paymentSubmitBtn;

	public WebElement getBillAddTxt() {
		return billAddTxt;
	}

	public WebElement getBillStateTxt() {
		return billStateTxt;
	}

	public WebElement getBillCityTxt() {
		return billCityTxt;
	}

	public WebElement getBillPinCodeTxt() {
		return billPinCodeTxt;
	}

	public WebElement getBillUpdatebtn() {
		return billUpdatebtn;
	}

	public WebElement getShipAddTxt() {
		return shipAddTxt;
	}

	public WebElement getShipStateTxt() {
		return shipStateTxt;
	}

	public WebElement getShipCityTxt() {
		return shipCityTxt;
	}

	public WebElement getShipPincodeTxt() {
		return shipPincodeTxt;
	}

	public WebElement getShipUpdateBtn() {
		return shipUpdateBtn;
	}

	public WebElement getCheckOutBtn() {
		return checkOutBtn;
	}

	public WebElement getPaymentSubmitBtn() {
		return paymentSubmitBtn;
	}
	
	public MyCartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void checkOutClk()
	{
		checkOutBtn.click();
	}
	
	public void paymentSubBtnClk()
	{
		paymentSubmitBtn.click();
	}
	
}
