package com.certijob.ska.tests;


import static org.junit.jupiter.api.Assertions.assertEquals;

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
		signup_page.Sign_up(driver);
		String text_confirm = signup_page.getText_locator(text_term_cond);
		assertEquals("Terms & Conditions", text_confirm);
		//*[@id="marketplace-container"]/div[1]/div[2]/div/div[1]/div[1] obtener el text Welcome
	}

}
