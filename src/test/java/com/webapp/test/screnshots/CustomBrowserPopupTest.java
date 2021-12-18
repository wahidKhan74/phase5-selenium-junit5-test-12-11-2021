package com.webapp.test.screnshots;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class CustomBrowserPopupTest {

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
	@DisplayName("Amazon Test : Browser Location Popup Test")
	public void testLocationPopup() throws InterruptedException, IOException { 
		driver.findElement(By.id("nav-global-location-popover-link")).click();
		Thread.sleep(3000);
		takeScreenShot("amazon-location-popup.png");
		//swith from main window to popup window
		String mainWindow = driver.getWindowHandle();
		//list of external popups
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		
		while (itr.hasNext()) {
			String childWindow = itr.next();
			// switch to child window
			driver.switchTo().window(childWindow);
			// enter pin location
			driver.findElement(By.id("GLUXZipUpdateInput")).sendKeys("500001");
			// submit location
			driver.findElement(By.cssSelector("#GLUXZipUpdate > span > input")).click();
		}
		takeScreenShot("amazon-location-data.png");
		driver.switchTo().window(mainWindow);
		Thread.sleep(4000);
		takeScreenShot("amazon-location-value.png");
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
