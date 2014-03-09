package com.knight.solid.services;

import org.openqa.selenium.WebDriver;

import com.knight.solid.interfaces.Dashboard;
import com.knight.solid.interfaces.Login;
import com.knight.solid.interfaces.PageFactory;

public class Factory implements PageFactory
{
	private WebDriver driver;
	
	public Login login()
	{
		return new LoginService(driver);
	}
	public Dashboard dashboard()
	{
		return null; //new DashboardPO(driver);
	}
	/*public Index index()
	{
		return new Index(driver).index();
	}*/
	public Factory(WebDriver driver)
	{
		this.driver = driver;
	}
	
}
