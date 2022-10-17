package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganization 
{
	
  //Initialization
  public CreateNewOrganization(WebDriver driver)
  {
	  PageFactory.initElements(driver,this);
  }
  
  //Declaration
  @FindBy(xpath="//img[@alt='Create Organization...']")
  private WebElement createNewOrg;
  
  @FindBy(xpath="//input[@name='accountname']")
  private WebElement orgName;
  
  @FindBy(xpath = "//input[@title='Save [Alt+S]']")
  private WebElement saveButton;
  
  @FindBy(xpath = "(//input[@title='Delete [Alt+D]'])")
  private WebElement deleteButton;

   //Getter Methods
   public WebElement getCreateNewOrg() {
    	return createNewOrg;
   }

   public WebElement getOrgName() {
	    return orgName;
   }

   public WebElement getSaveButton() {
	    return saveButton;
   }
   
   public WebElement getDeleteButton() {
	return deleteButton;
}

//Business Logic
   public void createOrg()
   {
	   createNewOrg.click();
	   saveButton.click();
	   deleteButton.click();
   }  
   public void createOrgName(String data)
   {
	   orgName.sendKeys(data);
	  
   }
  
}
