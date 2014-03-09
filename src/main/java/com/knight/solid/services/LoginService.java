package com.knight.solid.services;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.knight.solid.assertions.LoginAssertionsImpl;
import com.knight.solid.interfaces.Login;
import com.knight.solid.interfaces.LoginAssertion;
import com.knight.solid.interfaces.LoginPO;

public class LoginService implements Login
{
	private WebDriver driver;
	
	public LoginService(WebDriver driver)
	{
		this.driver = driver;
	}
	@Override
	public LoginAssertion assertions() 
	{
		return new LoginAssertionsImpl(driver);
	}
	@Override
	public LoginPO po()
	{
		return PageFactory.initElements(driver, LoginPO.class);
	}
	@Override
	public LoginService login() 
	{
		return this;
	}
}
