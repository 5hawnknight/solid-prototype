package com.knight.solid.assertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.knight.solid.interfaces.DashboardAssertions;
import com.knight.solid.interfaces.DashboardPO;
import com.knight.solid.library.Waits;

public class DashboardAssertionsImpl implements DashboardAssertions 
{
	private DashboardPO po;
	private Waits waits;
	
	@Override
	public DashboardAssertions isLoaded() 
	{
		po.isLoaded();
		return this;
	}
	@Override
	public DashboardPO po()
	{
		return po;
	}
	public DashboardAssertionsImpl(WebDriver driver) {
		this.po = PageFactory.initElements(driver, DashboardPO.class);
		this.waits = new Waits(driver);
	}
}
