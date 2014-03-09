package com.knight.solid.pageobjects;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.impl.Log4JLogger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import com.knight.solid.library.Waits;

/**
 * @author shawnknight
 */
public abstract class BasePO
{
	private WebDriver driver;
	private Log4JLogger log = new Log4JLogger(this.getClass().getName());
	private Waits waits;	

	
	protected void selectRadioButtonWebElement(String pageOption1, 
			String pageOption2, WebElement pageOption1WebElement, WebElement pageOption2WebElement, String data) 
	{
		if (StringUtils.equalsIgnoreCase(pageOption1, data)) {
			pageOption1WebElement.click();
		}
		else if (StringUtils.equalsIgnoreCase(pageOption2, data)) {
			pageOption2WebElement.click(); 
		}
	}
	/**
	 * Populates text into web element
	 * @param webElement
	 * @param textString
	 */
	protected void inputTextInWebElement(WebElement webElement, String text)
	{
		if (StringUtils.isNotBlank(text)) //Checks if a String is not empty (""), not null and not whitespace only
		{
			webElement.clear();
			webElement.sendKeys(text);
		}
	}
	/**
	 * Reads the value from the web element
	 * @param webElement
	 * @return String
	 */
	protected String readTextInWebElement(WebElement webElement)
	{
		if (StringUtils.equalsIgnoreCase(null, webElement.getAttribute("value"))) {
			return webElement.getText();
		}
		else {
			return webElement.getAttribute("value");
		}
	}
	/**
	 * Selects the option from the web element
	 * @param webElement
	 * @param option
	 */
	protected void selectOptionInWebElement(WebElement webElement, String option)
	{
		Select select = new Select(webElement);
		select.selectByVisibleText(option);
	}
	/**
	 * Reads the first option in drop down list
	 * @param webElement
	 * @return
	 */
	protected String readFirstSelectedOptionInWebElement(WebElement webElement)
	{
		Select select = new Select(webElement);
		return select.getFirstSelectedOption().getText();
	}
	/**
	 * Checks if the web element is displayed
	 * @param webElement
	 * @return
	 */
	protected boolean isWebElementDisplayed(WebElement webElement)
	{
		boolean isDisplayed;
		try
		{
			isDisplayed = webElement.isDisplayed();
		} 
		catch (NoSuchElementException nse)
		{
			isDisplayed = false;
		}
		return isDisplayed;
	}
	/**
	 * Checks if the web element is enabled
	 * @param webElement
	 * @return
	 */
	protected boolean isWebElementEnabled(WebElement webElement)
	{
		boolean isEnabled;
		try
		{
			isEnabled = webElement.isEnabled();
		} 
		catch (NoSuchElementException nse)
		{
			isEnabled = false;
		}
		return isEnabled;
	}
	/**
	 * Checks if the web element is selected
	 * @param webElement
	 * @return
	 */
	protected boolean isWebElementSelected(WebElement webElement)
	{
		boolean isSelected;
		try
		{
			isSelected = webElement.isSelected();
		} 
		catch (NoSuchElementException nse)
		{
			isSelected = false;
		}
		return isSelected;
	}
	
	/**
	 * Clicks pagination link on the page
	 * 
	 * @param webElementList
	 * @param page
	 */
	protected void clickPaginationLink(List<WebElement> webElementList, String page)
	{
		for (WebElement element : webElementList)
		{
			if (StringUtils.equalsIgnoreCase(element.getText(), page))
			{
				element.click();
				break;
			}
		}
	}
	/**
	 * Is pagination link enabled 
	 * 
	 * @param webElementList
	 * @param page
	 * @return boolean
	 */
	protected boolean isPaginationLinkEnabled(List<WebElement> webElementList, String page)
	{
		for (WebElement element : webElementList)
		{
			if (StringUtils.equalsIgnoreCase(element.getText(), page))
			{
				return element.isEnabled();
			}
		}
		return false;
	}
	/**
	 * Checks for error message on the page
	 * @param webElement
	 * @return 
	 */
	protected boolean isErrorMessageDisplayed(WebElement webElement)
	{
		boolean isDisplayed = false;
		try
		{
			waits.wait60Seconds().until(ExpectedConditions.visibilityOf(webElement));
			if (StringUtils.trimToEmpty(webElement.getText()).length() > 0)
				isDisplayed = true;
		} 
		catch (TimeoutException te)
		{
			isDisplayed = false;
		} 
		catch (NoSuchElementException nse)
		{
			isDisplayed = false;
		} 
		catch (Exception e)
		{
			isDisplayed = false;
			log.info(e);
		}
		return isDisplayed;
	}
	/**
	 * Returns displayed error message on the page
	 * @param webElement
	 * @return 
	 */
	protected String getDisplayedErrorMessage(WebElement webElement)
	{
		waits.wait60Seconds().until(ExpectedConditions.visibilityOf(webElement));
		return StringUtils.trimToEmpty(readTextInWebElement(webElement));
	}
	/**
	 * Accepts dialog boxes
	 * @param browser
	 */
	protected void acceptAlertPopUpWindow()
	{
		try
		{
			waits.wait60Seconds().until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
		catch (NoSuchElementException nse)
		{
			log.info(nse);
		} 
		catch (Exception e)
		{
			log.info(e);
		}
	}
	/**
	 * 
	 * @param browser
	 */
	public BasePO(WebDriver driver)
	{
		this.driver = driver;
		this.waits = new Waits(driver);
	}
	public WebDriver getDriver()
	{
		return driver;
	}
	public Waits getWaits()
	{
		return waits;
	}
}