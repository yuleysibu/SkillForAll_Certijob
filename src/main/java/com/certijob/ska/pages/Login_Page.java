package com.certijob.ska.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.certijob.ska.base.Base;

public class Login_Page extends Base{

	private By btn_login = By.xpath("(//div[@class='headerMenuItem--C2-Ux'])[4]");
	private By tfield_email = By.id("username");
	private By btn_loginUser = By.id("kc-login");
	private By tfield_passw = By.id("password");
	
	
	
	
	
	
	public Login_Page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void loginUser()
	{
		click(btn_login);
		type("fcarlos@gmail.com", tfield_email);
		click(btn_loginUser);
		type("12345Dario*", tfield_passw);;
		click(btn_loginUser);
	}
}
