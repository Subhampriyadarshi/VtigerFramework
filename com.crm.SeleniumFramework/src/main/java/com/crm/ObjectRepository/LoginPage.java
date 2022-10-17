package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	//Initialization 
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//Declaration
	@FindBy(name="user_name")
	private WebElement userNameTextField;
	
	@FindBy(name="user_password") 
	private WebElement passWordTextField;
	
	@FindBy(id="submitButton")
	private WebElement submitbutton;
	

	public WebElement getUserNameTextField() {
		return userNameTextField;
	}

	public WebElement getPassWordTextField() {
		return passWordTextField;
	}

	public WebElement getSubmitbutton() {
		return submitbutton;
	}
	
	//Business logic
	/**
	 * this method is used to login the application
	 * @param UserName
	 * @param PassWord
	 */
	public void login(String UserName,String PassWord)
	{
		userNameTextField.sendKeys(UserName);
		passWordTextField.sendKeys(PassWord);
		submitbutton.click();
	}
	
	
}
