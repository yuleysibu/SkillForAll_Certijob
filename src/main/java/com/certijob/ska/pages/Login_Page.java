package com.certijob.ska.pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.certijob.ska.base.Base;

public class Login_Page extends Base{

	private By header_menu = By.id("styleguideheader");
	private By btn_login = By.xpath("(//div[@class='headerMenuItem--C2-Ux'])[3]");
	private By tfield_email = By.id("username");
	private By btn_loginUser = By.id("kc-login");
	private By tfield_passw = By.id("password");
	private By alert_mess = By.className("alert__message");
	private By lbl_welcome = By.xpath("//div[@class='text-weight-400 text-size-20 text-white']");
	private By check_rembUser = By.id("rememberMe");
	private By btn_avatar = By.xpath("//img[@src='/sfa-assets/images/svg/user.svg']");
	private By btn_log_out = By.id("logoutButton");
	
/*	public Login_Page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}*/

	public void loginUser()
	{
		WebDriverWait d_wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		d_wait.until(ExpectedConditions.visibilityOfElementLocated(header_menu));
		click(btn_login);
		type("fcarlos@gmail.com", tfield_email);
		click(btn_loginUser);
		type("12345Dario*", tfield_passw);;
		click(btn_loginUser);
		WebDriverWait d_wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
		d_wait1.until(ExpectedConditions.textToBePresentInElementLocated(lbl_welcome, "Welcome"));
	}
	
	public String welcomeMessage()
	{
		String text_welcome = getText_locator(lbl_welcome);
		return text_welcome;
	}
	
	public void passwInvalid()
	{
		headerMenuVisible();
		click(btn_login);
		type("fcarlos@gmail.com", tfield_email);
		click(btn_loginUser);
		type("password_incorrect", tfield_passw);
		click(btn_loginUser);
	}
	
	public String invalidEmailAndPasswordMessage()
	{
		String inv_message = getText_locator(alert_mess);
		return inv_message;		
	}
	
	public void emailInvalid()
	{
		headerMenuVisible();
		click(btn_login);
		type("fcarlos", tfield_email);
		click(btn_loginUser);
	}
	
	private void headerMenuVisible()
	{
		WebDriverWait d_wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		d_wait.until(ExpectedConditions.visibilityOfElementLocated(header_menu));
	}
	
	public void loginWithRememberUser()
	{
		headerMenuVisible();
		click(btn_login);
		type("fcarlos@gmail.com", tfield_email);
		click(check_rembUser);
		click(btn_loginUser);
		type("12345Dario*", tfield_passw);;
		click(btn_loginUser);
		WebDriverWait d_wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
		d_wait1.until(ExpectedConditions.textToBePresentInElementLocated(lbl_welcome, "Welcome"));		
	}
	
	
	public String logout()
	{
		click(btn_avatar);
		click(btn_log_out);
		headerMenuVisible();
		return getText(findElement(btn_login)); 
	}
	
	public Boolean loginWithoutRememberUser()
	{
		headerMenuVisible();
		click(btn_login);
		type("fcarlos@gmail.com", tfield_email);
		click(btn_loginUser);
		if(getText(findElement(tfield_passw)).isEmpty())
		{
			System.out.println("The required password was not saved correctly.");
			return false;
		}
		else
		{
			click(btn_loginUser);
			WebDriverWait d_wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
			d_wait1.until(ExpectedConditions.textToBePresentInElementLocated(lbl_welcome, "Welcome"));
			return true;
		}
	}
	
	public void closeWindow()
	{
		String parentwindowHandle = driver.getWindowHandle();
		// Wait for the new window or tab to open
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));

		Set<String> allWindowsHandles = driver.getWindowHandles();
		System.out.println(allWindowsHandles.size());
		/*for(String windowHandle: allWindowsHandles)
		{
			System.out.println("cerre");
			if(!windowHandle.equals(parentwindowHandle))
			{
				driver.switchTo().window(windowHandle);
				driver.close();
				System.out.println("cerre vetana");
			}
		}*/
	}

}
