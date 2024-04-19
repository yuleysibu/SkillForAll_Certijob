package com.certijob.ska.base;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	private WebDriver driver;
	
	public Base(WebDriver driver) 
	{
		this.driver = driver;	
	}
	
	public WebDriver FirefoxDriver_connection()
	{
		/*
		 * // Especifica la ubicación del chromedriver.exe String chromedriverPath =
		 * "./src/test/resources/chromedriver/chromedriver.exe"; // Establece la
		 * ubicación del chromedriver System.setProperty("webdriver.chrome.driver",
		 * chromedriverPath);
		 *         driver = new ChromeDriver();       
		 */
		String geckodriverPath = "./src/test/resources/geckodriver/geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", geckodriverPath);
        System.setProperty("webdriver.http.factory", "jdk-http-client");
		driver= new FirefoxDriver();
        return driver;            
	}
	
	public WebDriver ChromeDriver_connection()
	{
		String chromedriverPath = "./src/test/resources/chromedriver/chromedriver.exe"; 
		// Establece la ubicación del chromedriver 
		System.setProperty("webdriver.chrome.driver",chromedriverPath);
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        ChromeOptions options = new ChromeOptions(); 
        options. setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); 
        driver = new ChromeDriver(options);
        return driver;            
	}
	
	public WebElement findElement(By locator)
	{
		return driver.findElement(locator);	
	}
	
	public List<WebElement> findElements(By locator)
	{
		return driver.findElements(locator);	
	}
	
	public String getText(WebElement element)
	{
		return element.getText();
	}
	
	public String getText_locator(By locator)
	{
		return driver.findElement(locator).getText();
	}
	
	public void type(String text, By locator)
	{
		driver.findElement(locator).sendKeys(text);
	}
	
	public void click(By locator)
	{
		driver.findElement(locator).click();
	}
	
	public Boolean isDisplayed(By locator)
	{
		try
		{
			return driver.findElement(locator).isDisplayed();		
		}
		catch(NoSuchElementException e)
		{
			return false;
		}
	}
	
	public void visit(String url)
	{
		driver.get(url);
	}
}
