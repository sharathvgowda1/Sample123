package com.shophunt.genericutilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTripCalenderPopup {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		
		driver.findElement(By.xpath("//input[@data-cy='toCity']")).click();
		driver.findElement(By.xpath("//input[@class='react-autosuggest__input react-autosuggest__input--open']")).sendKeys("Bali");
		driver.findElement(By.xpath("//p[contains(.,'Bali,')]")).click();  
		
		
		driver.findElement(By.xpath("//div[@class='fsw_inputBox dates inactiveWidget ']")).click(); 
		Thread.sleep(10000);
		try
		{
			driver.findElement(By.xpath("//div[@class='langCard  fixedCard bounceAni']/descendant::span[@class='langCardClose']")).click();
		}
		
		catch(Exception e)
		{
			System.out.println("Handeled");
			
		}
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='DayPicker-Month']/descendant::div[contains(.,'August')]/following-sibling::div[@class='DayPicker-Body']/descendant::div[@aria-label='Thu Aug 18 2022']")).click();
		
		Thread.sleep(10000);
		driver.findElement(By.xpath("//p[@class='latoBlack font12 greyText lineHeight16']")).click();

	 	WebElement ele = driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']"));
	 	ele.click();
	 	ele.click();
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//div[@class='DayPicker-Month']/descendant::div[contains(.,'November')]/following-sibling::div[@class='DayPicker-Body']/descendant::div[@aria-label='Sun Nov 13 2022']")).click();
		
		

	}

}
