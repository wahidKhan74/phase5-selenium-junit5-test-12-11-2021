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

class AmazonTest {

	// step1: formulate a test url & driver path
	String siteUrl = "https://www.amazon.in/";
	String driverPath = "drivers/chromedriver";
	WebDriver driver;

	@BeforeEach
	void setUp() throws Exception {
		// step2: set selenium system properties
		System.setProperty("webdriver.chrome.driver", driverPath);
		// step3: instantiate selenium web-driver
		driver = new ChromeDriver();
		// step4: launch browser
		driver.get(siteUrl);
	}

	@AfterEach
	void tearDown() throws Exception {
		// step6: close driver
		driver.close();
	}

	@Test
	@DisplayName("Amazon Test : Homepage Title ")
	void testHomepageTitleValidation() {
		String expected = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String actual = driver.getTitle();
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("Amazon Test : Homepage Soruce URl ")
	void testHomepageSoruceUrl() {
		assertEquals(siteUrl, driver.getCurrentUrl());
	}

	@Test
	@DisplayName("Amazon Test : Search Data")
	public void testSearchData() {
		// find search box
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys("Ipohne 12 max pro");
		searchBox.submit();
		String expected = "Amazon.in : Ipohne 12 max pro";
		String actual = driver.getTitle();
		assertEquals(expected, actual);
	}
}
