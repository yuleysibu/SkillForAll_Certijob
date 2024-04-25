package com.certijob.ska.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.certijob.ska.pages.Login_Page;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Login_Test {
	Login_Page login_page;
	WebDriver driver;

	@BeforeAll
	void setUpBeforeClass() throws Exception {
		login_page = new Login_Page(driver);
		driver = login_page.ChromeDriver_connection();
		driver.manage().window().maximize();
		login_page.visit("https://skillsforall.com");
		
	}

	@AfterAll
	void tearDownAfterClass() throws Exception {
		//driver.quit();
	}

	@Test
	void loginUserSucceed() {
		WebDriverWait d_wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		d_wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("styleguideheader")));
		login_page.loginUser();
		WebDriverWait d_wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
		By lbl_welcome = By.xpath("//div[@id='marketplace-container']/div[1]/div[2]/div/div[1]/div[1]");
		d_wait1.until(ExpectedConditions.textToBePresentInElementLocated(lbl_welcome, "Welcome"));
		String text_welcome = login_page.getText_locator(lbl_welcome);
		assertEquals("Welcome,", text_welcome);
	}

}
