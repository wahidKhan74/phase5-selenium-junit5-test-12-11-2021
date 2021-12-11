package com.webapp.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleHompageTest {
	// step1: formulate a test url & driver path
	String siteUrl = "https://www.google.com/";
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
	@DisplayName("Test Google Home Page Correct Title")
	public void testGoogleHomePage() {
		// step5: evaluate test
		String expectedTitle = "Google";
		String actualTitle = driver.getTitle();
		Assertions.assertEquals(expectedTitle, actualTitle);
	}

	@Test
	@DisplayName("Test Google Home Page Incorrect Title")
	public void testGoogleHomePage2() {
		// step5: evaluate test
		Assertions.assertEquals(false, "Xyz".equals(driver.getTitle()));
	}

	@Test
	@DisplayName("Test Google Home Page Source URL")
	public void testGoogleHomePage3() {
		// step5: evaluate test
		Assertions.assertEquals(siteUrl, driver.getCurrentUrl());
	}

	@Test
	@DisplayName("Test Google Search Test")
	public void testGoogleHomePage4() {
		// find search box
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("selenium documentations");
		searchBox.submit();

		// step5: evaluate test
		String expectedTitle = "selenium documentations - Google Search";
		String actualTitle = driver.getTitle();
		
		Assertions.assertEquals(expectedTitle, actualTitle);
	}
}
