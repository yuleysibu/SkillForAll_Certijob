package com.certijob.ska.tests;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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
		signup_page = new Sign_Up_Page();
		driver=signup_page.ChromeDriver_connection();
	}
	
	@BeforeEach
	void doBeforeEachTest()
	{
		driver.manage().window().maximize();
		signup_page.visit("https://skillsforall.com");
	}

	@AfterAll
	void tearDownAfterClass() throws Exception {
			//driver.quit();
		}

	@Test
	void signUpSucceed() {	
		signup_page.Sign_up();
		String mess_welcome = signup_page.welcomeMessage();
		assertEquals("Welcome,", mess_welcome);
	}

}
