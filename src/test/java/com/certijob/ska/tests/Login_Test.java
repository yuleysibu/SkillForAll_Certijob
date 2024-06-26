package com.certijob.ska.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;

import com.certijob.ska.pages.Login_Page;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Login_Test {
	Login_Page login_page;
	WebDriver driver;

	@BeforeAll
	void setUpBeforeClass() throws Exception {
		login_page = new Login_Page();
	}

	@BeforeEach
	void doBeforeEachTest() throws Exception
	{
		driver = login_page.ChromeDriver_connection();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		login_page.visit("https://skillsforall.com");
	}
	
	@AfterEach
	void doBeAfterEachTest() throws Exception
	{
		driver.quit();
	}

	@Test 
	void loginUserSucceed() {
		login_page.loginUser();
		String text_welcome = login_page.welcomeMessage();
		assertEquals("Welcome,", text_welcome);
	}
	
	@Test 
	void settingEmailValidAndPasswordInvalid()
	{
		login_page.passwInvalid();
		String error_mess_passw = login_page.invalidEmailAndPasswordMessage();
		assertEquals("Invalid username or password.", error_mess_passw);
	}

	@Test  
	void settingEmailInvalid()
	{
		login_page.emailInvalid();
		String error_mess_email = login_page.invalidEmailAndPasswordMessage();
		assertEquals("Invalid username or email.", error_mess_email);
	}
	
	@Test 
	void rememberUser()
	{
		login_page.loginWithRememberUser();;
		String text_welcome = login_page.welcomeMessage();
		assertEquals("Welcome,", text_welcome);		
		String btn_name = login_page.logout(); assertEquals("Login", btn_name);
		assertTrue(login_page.loginWithoutRememberUser(),"The required password was not saved correctly."); 
	}
}
