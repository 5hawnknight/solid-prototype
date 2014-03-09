package com.knight.solid.pageobjects;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.knight.solid.interfaces.DashboardPO;
import com.knight.solid.interfaces.Person;
import com.knight.solid.interfaces.PersonProfile;

public class DashboardPOImpl extends BasePO implements DashboardPO
{
	private final String title = "Dashboard title";
	
	@FindBy(id = "") private WebElement firstNameTextBox;
	@FindBy(id = "") private WebElement lastNameTextBox;
	@FindBy(id = "") private WebElement submitButton;
	@FindBy(id = "") private WebElement searchResultsTable;
	
	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public void isLoaded() {
		getWaits().wait60Seconds().until(ExpectedConditions.visibilityOfAllElements(
				Arrays.asList(
							firstNameTextBox,
							lastNameTextBox,
							submitButton
							)));
		
	}

	@Override
	public PersonProfile searchForPerson(Person person) {
		
	for (WebElement personInRow : searchResultsTable.findElements(By.cssSelector("tbody tr")))
	{
		if (StringUtils.containsIgnoreCase(personInRow.getText(), person.getLastName())) 
		{
			List<WebElement> rowLinks = personInRow.findElements(By.cssSelector("a"));
			for (WebElement link : rowLinks)
			{
				if (StringUtils.equalsIgnoreCase(link.getText(), person.getLastName()))
				{
					link.click();
					return null; //next page object
				}
			}
		}
	}
	return null;

}
	public DashboardPOImpl(WebDriver driver) {
		super(driver);
	}
}
