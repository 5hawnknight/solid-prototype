package com.knight.solid.tests;

import org.openqa.selenium.WebDriver;

import com.knight.solid.interfaces.Person;
import com.knight.solid.interfaces.User;
import com.knight.solid.services.Factory;

public class Tests 
{
	private WebDriver driver;
	protected User user;
	protected Person person;
	
	protected Factory page() 
	{
		return new Factory(driver);
	}
	public WebDriver getDriver() 
	{
		return driver;
	}
	public void setDriver(WebDriver driver)
	{
		this.driver = driver;
	}
}
