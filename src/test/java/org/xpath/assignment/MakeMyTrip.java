package org.xpath.assignment;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTrip {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver;
		
		Scanner s=new Scanner(System.in);
		System.out.println("Enter filter Name: - ");
		String name=s.next();
		
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		
		driver.findElement(By.xpath("//a[.='Search']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='bgProperties icon20 overlayCrossIcon']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//p[.='Popular Filters']/ancestor::div[@class='filterWrapper']/descendant::span[contains(.,'"+name+"')]"
				+ "/ancestor::div[@class='makeFlex hrtlCenter flexOne gap-x-10']/child::span[@class='customCheckbox']")).click();
	}

}
