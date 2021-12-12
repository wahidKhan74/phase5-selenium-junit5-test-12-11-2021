package com.webapp.test.extenal.webelements;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlertTest {


	String siteUrl = "file:///home/wahidkhan74gmai/FSD_PG_Wokspace/phase5-selenium-junit5-test-12-11-2021/static/alert-web-elements.html";
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
	@DisplayName("Alert dailog test")
	public void testAlertDailogWindow() throws InterruptedException {
		driver.findElement(By.cssSelector("body > p:nth-child(2) > button")).click();
		//switch to sub window alert
		Alert alert = driver.switchTo().alert();
		assertEquals("Do you really want to proceed ??", alert.getText());
		Thread.sleep(3000);
		alert.accept();
	}
	
	@Test
	@DisplayName("Confirmation dailog test with accept")
	public void testConfirmDailogWindow() throws InterruptedException {
		driver.findElement(By.cssSelector("body > p:nth-child(4) > button")).click();
		//switch to sub window alert
		Alert confirm = driver.switchTo().alert();
		assertEquals("Please confirm the action is right ??", confirm.getText());
		Thread.sleep(3000);
		// confirmation with ok button click
		confirm.accept();
	}
	
	@Test
	@DisplayName("Confirmation dailog test with cancel")
	public void testConfirmDailogWindowCancel() throws InterruptedException {
		driver.findElement(By.cssSelector("body > p:nth-child(4) > button")).click();
		//switch to sub window alert
		Alert confirm = driver.switchTo().alert();
		assertEquals("Please confirm the action is right ??", confirm.getText());
		Thread.sleep(3000);
		// confirmation with cancel button click
		confirm.dismiss();
	}
	
	
	@Test
	@DisplayName("Prompt dailog test with accept")
	public void testPromptDailogWindow() throws InterruptedException {
		driver.findElement(By.cssSelector("body > p:nth-child(6) > button")).click();
		//switch to sub window alert
		Alert prompt = driver.switchTo().alert();
		assertEquals("Please enter your name", prompt.getText());
		prompt.sendKeys("John Smith");
		Thread.sleep(3000);
		// confirmation with cancel button click
		prompt.accept();
	}
}
