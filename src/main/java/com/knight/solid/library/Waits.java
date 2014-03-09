package com.knight.solid.library;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits 
{
	private WebDriver driver;
	private WebDriverWait wait30;
	private WebDriverWait wait60;
	private WebDriverWait wait90;
	private final int thirdySeconds  = 30;
	private final int sixtySeconds 	 = 60;
	private final int nintetySeconds = 90;
	
	public Waits(WebDriver driver)
	{
		this.driver = driver;
		this.wait30 = new WebDriverWait(driver, thirdySeconds);
		this.wait60 = new WebDriverWait(driver, sixtySeconds);
		this.wait90 = new WebDriverWait(driver, nintetySeconds);
	}
	public WebDriverWait wait30Seconds()
	{
		return wait30;
	}
	public WebDriverWait wait60Seconds()
	{
		return wait60;
	}
	public WebDriverWait wait90Seconds()
	{
		return wait90;
	}
	public ExpectedCondition<Boolean> jQueryActiveConnectionsFinish()
	{
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() 
		{
			public Boolean apply(WebDriver wd) 
			{
				/**
				 * use with java 6
				 */
				return (Boolean) ((JavascriptExecutor)driver).executeScript("return jQuery.active == 0");	
				/**
				 * use with java 7
				 */
				//long numberOfAjaxConnections = (long) ((JavascriptExecutor) wd).executeScript("return jQuery.active");
				//		 return numberOfAjaxConnections < 1;
			}
		};
		return expectation;
	}
}
