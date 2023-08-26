package com.easy;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class implicitWaitConcept {
	public static void main(String[] args) throws InterruptedException  {
		// Create a new instance of the Chrome driver
		WebDriver driver = new ChromeDriver();

		//Object action;
		Actions action = new Actions(driver);
				
		// Storing the Application Url in the String variable
		String baseUrl = "https://www.flipkart.com/samsung-mobile-store?otracker=nmenu_sub_Electronics_0_Samsung";
		//Launch the WebPage
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//implicit wait
		//Selenium will wait for atmost 40 seconds for page loading
		//if page loaded before 40 seconds, system will perform next activity
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		action.moveToElement(driver.findElement(By.linkText("Baby & Kids"))).build().perform();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElement(By.linkText("Outdoor Toys")).click();
		
	}
}
	
