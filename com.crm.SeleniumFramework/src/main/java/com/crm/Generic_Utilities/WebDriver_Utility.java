package com.crm.Generic_Utilities;

import java.util.Set;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriver_Utility {

	/**
	 * wait for page to load before identifying any synchronized in DOM
	 * @param driver
	 * @author Subham
	 */
	public void waitForPageLoad(WebDriver driver)
	{
      driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	/**
	 * used to wait for element to be clickable in GUI, and check for specific element for every 500mliseconds
	 * @param driver
	 * @param Element
	 * @author Subham
	 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement Element)
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(Element));
	}
	/**
	 * used to switch any window based on window title
	 * @param driver
	 * @param partialWindowTitle
	 * @author Subham
	 */
	public void switchToWindow(WebDriver driver,String partialWindowTitle)
	{
		Set<String> set=driver.getWindowHandles();
		Iterator<String> it=set.iterator();
		while(it.hasNext())
		{
			String wID = it.next();
			driver.switchTo().window(wID);
			String currentWindowTitle = driver.getTitle();
			if(currentWindowTitle.contains(partialWindowTitle))
			{
				break;
			}
		}
	}
	/**
	 * used to switch to alert window & click on OK button
	 * @param driver
	 * @param expectedMsg
	 * @author Subham
	 */
	public void switchToWindowAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * used to Switch to Alert Window & click on cancel button
	 * @param driver
	 * @param expectedMsg
	 * @author Subham
	 */
	public void switchToAlertWindowAndCancel(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * used to switch to frame window based on Index
	 * @param driver
	 * @param index
	 * @author Subham
	 */
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * used Switch to FrameWindom based on id or name attribute 
	 * @param driver
	 * @param id_name_attribute
	 * @author Subham
	 */
	public void switchToFrame(WebDriver driver,String id_name_attribute)
	{
		driver.switchTo().frame(id_name_attribute);
	}
	
	/**
	 * used to select the value from the dropDown based on index
	 * @param element
	 * @param index
	 * @author Subham
	 */
	public void select(WebElement element,int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	
	/**
	 * used to select the value from the dropDown based on value/option avilable in GUI
	 * @param element
	 * @param text
	 * @author Subham
	 */
	public void select(WebElement element,String text)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	
	/**
	 * used to place mouse cursor on specified element
	 * @param driver
	 * @param element
	 * @author Subham
	 */
	public void mouseOverOnElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * used to right click on specified element
	 * @param driver
	 * @param element
	 * @author Subham
	 */
	public void rightClickOnElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	
	/**
	 * used to 
	 * @param driver
	 * @param javaScript
	 * @author Subham
	 */
	public void excuteJavaScript(WebDriver driver,String javaScript)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeAsyncScript(javaScript, null);
	}
	
	/**
	 * used for customized wait
	 * @param element
	 * @throws Throwable
	 * @author Subham
	 */
	public void waitAndClick(WebElement element) throws Throwable
	{
		int count=0;
		while(count<20)
		{
			try
			{
				element.click();
				break;
			}
			catch(Throwable e)
			{
				Thread.sleep(1000);
				count++;
			}
		}
	}
}















