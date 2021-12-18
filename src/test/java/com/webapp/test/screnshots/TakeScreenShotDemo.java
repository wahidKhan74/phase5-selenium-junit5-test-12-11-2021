package com.webapp.test.screnshots;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TakeScreenShotDemo {

	String siteUrl = "https://www.facebook.com/";
	String driverPath = "drivers/chromedriver";
	WebDriver driver;
	WebDriverWait wait;

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		driver.get(siteUrl);
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.close();
	}

	@Test
	@DisplayName("Facebook Login : Fields Validations.")
	public void testFieldsLogin() throws IOException {
		WebElement email = driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.id("pass"));
		WebElement submit = driver.findElement(By.name("login"));
		assertEquals(true, email.isDisplayed());
		assertEquals(true, password.isDisplayed());
		assertEquals(true, submit.isDisplayed());
		takeScreenShot("facebook-data-fields.png");
	}
	
	@Test
	@DisplayName("Facebook Login : Failure login.")
	public void testFailureLogin() throws IOException {
		WebElement email = driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.id("pass"));
		WebElement login = driver.findElement(By.name("login"));
		
		email.sendKeys("abc@gmail.com");
		password.sendKeys("abc@123");
		
		takeScreenShot("facebook-data-entry.png");
		login.submit();
		// Conditional timeouts
		// WebElement error = driver.findElement(By.cssSelector("#error_box > div.fsl.fwb.fcb"));
		WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#error_box > div.fsl.fwb.fcb")));
		assertEquals("Wrong Credentials", error.getText());
		
		// WebElement error2 = driver.findElement(By.cssSelector("#error_box > div:nth-child(2)"));
		WebElement error2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#error_box > div:nth-child(2)")));
		assertEquals("Invalid username or password", error2.getText());
		
		takeScreenShot("facebook-invalid-creds.png");
	}
	
	private void takeScreenShot(String filename) throws IOException {
		// type cast driver object to take screen shot
		TakesScreenshot tsc = (TakesScreenshot) driver;
		// take screen shot by getScreenshotAs method as file
		File src = tsc.getScreenshotAs(OutputType.FILE);
		// copy file src as file
		FileHandler.copy(src, new File("/home/wahidkhan74gmai/upload/"+filename));
	}
}
