package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewCampaign 
{
	
  //Initialization	
  public CreateNewCampaign(WebDriver driver)
  {
	  PageFactory.initElements(driver, this);
  }
  
  //Declaration
  
  @FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
  private WebElement createNewCampaign;
  
  @FindBy(xpath = "//input[@name='campaignname']")
  private WebElement campaignName;
  
  @FindBy(xpath = "(//input[@title='Save [Alt+S]'])")
  private WebElement saveButton;
  
  @FindBy(xpath = "//input[@title='Delete [Alt+D]']")
  private WebElement deleteButton;

  //Getter Methods
  
public WebElement getCreateNewCampaign() {
	return createNewCampaign;
}

public WebElement getCampaignName() {
	return campaignName;
}

public WebElement getSaveButton() {
	return saveButton;
}

public WebElement getDeleteButton() {
	return deleteButton;
}

// Business logic 
public void creatCampaign()
{
	createNewCampaign.click();
	saveButton.click();
	deleteButton.click();
}

public void createCampaignName(String data1)
{
    campaignName.sendKeys(data1);	
}
    
}
