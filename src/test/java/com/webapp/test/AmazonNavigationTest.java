package com.webapp.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonNavigationTest {

	String siteUrl = "https://www.amazon.in/";
	String driverPath = "drivers/chromedriver";
	WebDriver driver;

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(siteUrl);
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.close();
	}
	
	@Test
	@DisplayName("Amazon Test : Mobile Navigation Link")
	public void testMobileNavLink() throws InterruptedException {
		// find mobile link 
		WebElement mobileLink = driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(2)"));
		mobileLink.click();
		String expected ="Mobile Phones: Buy New Mobiles Online at Best Prices in India | Buy Cell Phones Online - Amazon.in";
		String actual = driver.getTitle();
		Thread.sleep(3000);
		assertEquals(expected, actual);
	}
	
	
	@Test
	@DisplayName("Amazon Test : BestSeller Navigation Link")
	public void testBestSellerNavLink() throws InterruptedException {
		// find mobile link 
		WebElement sellerLink = driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(3)"));
		sellerLink.click();
		String expected ="Amazon.in Bestsellers: The most popular items on Amazon";
		String actual = driver.getTitle();
		Thread.sleep(3000);
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("Amazon Test : Electronics Navigation Link")
	public void testElectronicsNavLink() throws InterruptedException {
		// find mobile link 
		WebElement electroLink = driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(4)"));
		electroLink.click();
		String expected ="Electronics Store: Buy Electronics products Online at Best Prices in India at Amazon.in";
		String actual = driver.getTitle();
		Thread.sleep(3000);
		assertEquals(expected, actual);
	}

}
