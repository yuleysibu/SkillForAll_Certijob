package com.certijob.ska.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.certijob.ska.base.Base;

public class Sign_Up_Page extends Base{
	
	private By btn_login = By.xpath("//div[@class='headerMenuItem--C2-Ux']//button[text()='Login']");
	private By link_sign_up = By.xpath("//div[@id='kc-registration']/span/a");
	private By cbox_country = By.id("selectCountry");
	private By cbox_yearbirth = By.id("yearOfBirth");
	private By cbox_monthbirth = By.id("selectMonth");
	private By btn_continue = By.xpath("//button[@class='btn btn--large btn-b2c half-margin']");
	private By tfield_fname = By.id("firstName");
	private By tfield_lname = By.id("lastName");
	private By tfield_email = By.id("email");
	private By tfield_password = By.id("password");
	private By tfield_passw_conf = By.id("password-confirm");
	private By btn_create = By.xpath("//div[@id='kc-form-buttons']/input");
	private By checkb_term_cond = By.xpath("//div[@id='modal-large']/div/div/div[2]/div[2]/div/label/span[1]");
	private By btn_term_cond = By.xpath("//div[@id='modal-large']/div/div/div[3]/div/button[1]");
	private By lbl_welcome = By.xpath("//div[@class='text-weight-400 text-size-20 text-white']");

	
	
	/*public Sign_Up_Page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}*/
	
	public void Sign_up()
	{
		WebDriverWait d_wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		d_wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("styleguideheader")));
		click(btn_login);
		// Desplazar el scroll hacia abajo
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 1000)");
		click(link_sign_up);
		selected_cbox_country();
		selected_yearbirth();
		selected_monthbirth();
		js.executeScript("window.scrollBy(0, 1000)");
		click(btn_continue);
		WebDriverWait dwait = new WebDriverWait(driver, Duration.ofSeconds(20));
		dwait.until(ExpectedConditions.elementToBeClickable(tfield_fname));
		type("Carlos", tfield_fname);
		type("Ferreira", tfield_lname);
		type("ferr_carlos@gmail.com", tfield_email);
		type("12345Dario*", tfield_password);
		type("12345Dario*", tfield_passw_conf);
		click(btn_create);
		WebDriverWait d_wait2 = new WebDriverWait(driver, Duration.ofSeconds(40));
		d_wait2.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@id='modal-large']/div/div/div[1]/div"), "Terms & Conditions"));
		js.executeScript("window.scrollBy(0, 1000)");
		click(checkb_term_cond);
		click(btn_term_cond);
		WebDriverWait d_wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
		d_wait1.until(ExpectedConditions.textToBePresentInElementLocated(lbl_welcome, "Welcome"));
	}
	
	public String selected_cbox_country()
	{
		Select select_cbox_country = new Select(findElement(cbox_country));
		select_cbox_country.selectByVisibleText("Uruguay");
		return getText(select_cbox_country.getFirstSelectedOption());
	}
	
	public String selected_yearbirth()
	{
		Select select_cbox_yearbirth = new Select(findElement(cbox_yearbirth));
		select_cbox_yearbirth.selectByVisibleText("1990");
		return getText(select_cbox_yearbirth.getFirstSelectedOption());
	}
	
	public String selected_monthbirth()
	{
		Select select_cbox_monthbirth = new Select(findElement(cbox_monthbirth));
		select_cbox_monthbirth.selectByVisibleText("May");
		return getText(select_cbox_monthbirth.getFirstSelectedOption());
	}
	
	public String welcomeMessage()
	{
		WebDriverWait d_waitwm = new WebDriverWait(driver, Duration.ofSeconds(20));
		d_waitwm.until(ExpectedConditions.textToBePresentInElementLocated(lbl_welcome, "Welcome"));
		String text_welcome = getText_locator(lbl_welcome);
		return text_welcome;
	}
	

}
