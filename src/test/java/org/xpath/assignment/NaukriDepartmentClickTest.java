package org.xpath.assignment;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NaukriDepartmentClickTest {

	public static void main(String[] args) {
		WebDriver driver = null;
		
		Scanner sc  = new Scanner(System.in);
		System.out.println("Enter the depatment name " );
		String dname = sc.nextLine();
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.naukri.com/jobs-in-india?clusters=functionalAreaGid&functionAreaIdGid=5&functionAreaIdGid=8");
		
		driver.findElement(By.xpath("\r\n"
				+ "\r\n"
				+ "//span[contains(.,'Department')]/ancestor::div[@class='filterContainer bgWhite br4']/descendant::span[@class='ellipsis fleft' and contains(.,'"+dname+"')]")).click();

	}

}
