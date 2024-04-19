package com.certijob.ska.tests;


import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.certijob.ska.pages.Sign_Up_Page;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Sign_Up_Test {
	
	private WebDriver driver;
	private Sign_Up_Page signup_page;

	@BeforeAll
	void setUpBeforeClass() throws Exception {
		signup_page = new Sign_Up_Page(driver);
		driver=signup_page.ChromeDriver_connection();
		driver.manage().window().maximize();
		signup_page.visit("https://skillsforall.com");
	}

	@AfterAll
	void tearDownAfterClass() throws Exception {
		//driver.quit();
		}

	@Test
	void test() {
		WebDriverWait d_wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		d_wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("styleguideheader")));
		signup_page.Sign_up();
	}

}
