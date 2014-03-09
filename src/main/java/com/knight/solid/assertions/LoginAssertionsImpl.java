package com.knight.solid.assertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.knight.solid.interfaces.LoginAssertion;
import com.knight.solid.interfaces.LoginPO;
import com.knight.solid.library.Waits;

public class LoginAssertionsImpl implements LoginAssertion 
{
	private LoginPO po;
	private Waits waits;
	
	@Override
	public LoginAssertion isLoaded() 
	{
		po.isLoaded();
		return this;
	}
	public LoginAssertion verifyInValidUserMessage()
	{
		final String message = "Invalid User Message";
		Assert.assertEquals(message, po.getDisplayedErrorMessage());
		return this;
	}
	@Override
	public LoginPO po() 
	{
		return po;
	}
	public LoginAssertionsImpl(WebDriver driver) 
	{
		this.po = PageFactory.initElements(driver, LoginPO.class);
		this.waits = new Waits(driver);
	}
}
