package com.webapp.test.webelements;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdownTest {

	String siteUrl = "file:///home/wahidkhan74gmai/FSD_PG_Wokspace/phase5-selenium-junit5-test-12-11-2021/static/web-elements.html";
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
	@DisplayName("Select Dropdown exist test")
	public void testSelectDropdownExist() {
		WebElement dropdown  = driver.findElement(By.id("vehicle"));
		assertEquals(true, dropdown.isDisplayed());
		assertEquals(true, dropdown.isEnabled());
		assertEquals(false, dropdown.isSelected());
	}	
	
	@Test
	@DisplayName("Test first selected option from dropdown")
	public void testSelectDropdownOption() throws InterruptedException {
		WebElement dropdown  = driver.findElement(By.id("vehicle"));
		// map web element to select
		Select select = new Select(dropdown);
		// select bike as a selected option
		select.selectByVisibleText("Bike");
		WebElement selectedValue = select.getFirstSelectedOption();
		assertEquals(" Bike ", selectedValue.getText());
		Thread.sleep(3000);
	}
	
	
	@Test
	@DisplayName("Test 3rd index selected option from dropdown")
	public void test3rdIndexSelectDropdownOption() throws InterruptedException {
		WebElement dropdown  = driver.findElement(By.id("vehicle"));
		// map web element to select
		Select select = new Select(dropdown);
		// select bike as a selected option
		select.selectByIndex(3);
		WebElement selectedValue = select.getFirstSelectedOption();
		assertEquals(" Airplane ", selectedValue.getText());
		Thread.sleep(3000);
	}
	
	
	@Test
	@DisplayName("Test select option by value from dropdown")
	public void testSelectByValueDropdownOption() throws InterruptedException {
		WebElement dropdown  = driver.findElement(By.id("vehicle"));
		// map web element to select
		Select select = new Select(dropdown);
		// select bike as a selected option
		select.selectByValue("car");
		WebElement selectedValue = select.getFirstSelectedOption();
		assertEquals(" Car ", selectedValue.getText());
		Thread.sleep(3000);
	}
	
}
