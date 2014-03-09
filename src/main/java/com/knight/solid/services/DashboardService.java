package com.knight.solid.services;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.knight.solid.assertions.DashboardAssertionsImpl;
import com.knight.solid.interfaces.DashboardPO;
import com.knight.solid.interfaces.DashboardAssertions;
import com.knight.solid.interfaces.Dashboard;

public class DashboardService implements Dashboard
{
	private WebDriver driver;

	@Override
	public DashboardAssertions assertions() 
	{
		return new DashboardAssertionsImpl(driver);
	}
	@Override
	public DashboardPO po() 
	{
		return PageFactory.initElements(driver, DashboardPO.class);
	}
	public DashboardService dashboard() 
	{
		assertions().isLoaded();
		return this;
	}
	public DashboardService(WebDriver driver) 
	{
		this.driver = driver;
	}
}
