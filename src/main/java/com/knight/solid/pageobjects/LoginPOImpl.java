package com.knight.solid.pageobjects;

import java.util.Arrays;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.knight.solid.interfaces.Dashboard;
import com.knight.solid.interfaces.Login;
import com.knight.solid.interfaces.LoginPO;
import com.knight.solid.interfaces.User;
import com.knight.solid.services.DashboardService;
import com.knight.solid.services.LoginService;

public class LoginPOImpl extends BasePO implements LoginPO
{
	private final String title = "page title";
	
	@FindBy(id = "") 	private WebElement usernameTextBox;
	@FindBy(id = "")	private WebElement passwordTextbox;
	@FindBy(id = "")	private WebElement loginButton;
	@FindBy(id = "")	private WebElement errorMessageLabel;
	
	@Override
	public Dashboard loginAs(User user) 
	{
		inputTextInWebElement(usernameTextBox, user.getUsername());
		inputTextInWebElement(passwordTextbox, user.getPassword());
		loginButton.click();
		return new DashboardService(getDriver());
	}
	
	@Override
	public Login loginWithFailure(User user) 
	{
		usernameTextBox.sendKeys(user.getUsername());
		passwordTextbox.sendKeys(user.getPassword());
		loginButton.click();
		return new LoginService(getDriver());
	}
	@Override
	public void isLoaded() 
	{
		getWaits().wait30Seconds().until(ExpectedConditions.titleIs(title));
		getWaits().wait60Seconds().until(ExpectedConditions.visibilityOfAllElements(
				Arrays.asList(
							usernameTextBox,
							passwordTextbox,
							loginButton
							)));
	}
	@Override
	public String getTitle()
	{
		return title;
	}
	@Override
	public String getDisplayedErrorMessage() 
	{
		return getDisplayedErrorMessage(errorMessageLabel);
	}
	public LoginPOImpl(WebDriver driver)
	{
		super(driver);
	}
}
