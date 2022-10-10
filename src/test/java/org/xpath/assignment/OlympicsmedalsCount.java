package org.xpath.assignment;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OlympicsmedalsCount {

	public static void main(String[] args) {
		WebDriver driver = null;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the athlete name: ");
		String name = sc.nextLine();

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://olympics.com/");

		try 
		{
			WebElement gold = driver.findElement(By.xpath("//span[contains(.,'"+name+"')]"
					+ "/ancestor::li[@class='b2p-list__item position-relative']"
					+ "/descendant::span[@class='result-medal result-medal--gold']"));
			System.out.println("Number of Gold Medals Won---"+gold.getText());
		}
		catch(Exception e)
		{
			System.out.println("No Gold Medal Has Won");
		}

		try {
			WebElement silver = driver.findElement(By.xpath("//span[contains(.,'"+name+"')]"
					+ "/ancestor::li[@class='b2p-list__item position-relative']"
					+ "/descendant::span[@class='result-medal result-medal--silver']"));
			System.out.println("Number of Silver Medals Won---"+silver.getText());
		}
		catch(Exception e){

			System.out.println("No Silver Medal Has Won");

		}


		try {
			WebElement bronze = driver.findElement(By.xpath("//span[contains(.,'"+name+"')]"
					+ "/ancestor::li[@class='b2p-list__item position-relative']"
					+ "/descendant::span[@class='result-medal result-medal--bronze']"));
			System.out.println("Number of Bronze Medals Won---"+bronze.getText());
		}
		catch(Exception e){

			System.out.println("No Bronze Medal Has Won");

		}




	}

}
