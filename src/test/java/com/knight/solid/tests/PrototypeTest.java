package com.knight.solid.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.knight.solid.builder.UserBuilderImpl;

public class PrototypeTest extends Tests
{
	@BeforeClass
	public void setup()
	{
		String url = "http://www.google.com";
		WebDriver driver = new FirefoxDriver();
		driver.get(url);
		setDriver(driver);
		
		user = new UserBuilderImpl().build();
	}
	@Test
	public void test() 
	{
		page()
			.login()
				.po().loginAs(user)
			.dashboard()
				.po().searchForPerson(person);
			
		
		
		
	}
	@AfterClass
	public void teardown()
	{
		getDriver().quit();
	}
}
