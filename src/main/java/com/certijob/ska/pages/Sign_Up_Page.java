package com.certijob.ska.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.certijob.ska.base.Base;

public class Sign_Up_Page extends Base{
	
	private WebDriver driver;
	private By btn_login = By.xpath("(//div[@class='headerMenuItem--C2-Ux'])[4]");

	public Sign_Up_Page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void Sign_up()
	{
		click(btn_login);
	}
}
