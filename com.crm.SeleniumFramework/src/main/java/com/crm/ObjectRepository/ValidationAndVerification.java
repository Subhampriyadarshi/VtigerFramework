package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidationAndVerification
{
	
  public ValidationAndVerification(WebDriver driver)
  {
	PageFactory.initElements(driver,this);
  }
  @FindBy(xpath = "//span[@class='dvHeaderText']")
  private WebElement actualCampaignData;

  public WebElement getActualCampaignData() {
	  return actualCampaignData;
  }
  
  @FindBy(xpath = "//span[@class='dvHeaderText']")
  private WebElement actualOrganizationData;

  public WebElement getActualOrganizationData() {
		 return actualOrganizationData;
   }
  
  @FindBy(xpath = "//span[@class='lvtHeaderText']")
	 private WebElement actualProductData;

	public WebElement getActualProductData() {
		return actualProductData;
	}	

//Business logic for Campaign
 public void campaignValidation(WebDriver driver,String data1)
 {
	String title = actualCampaignData.getText();
	
	if(title.contains(data1))
	{
		System.out.println("Campaign is created and pass");
	}
	else
	{
		System.out.println("Campaign is not created and fail");  
	}

 }
  //Business logic for Organization
  public void organizationValidation(WebDriver driver,String data)	
  {
    String title = actualOrganizationData.getText(); 
  
	if(title.contains(data))
	{
		System.out.println("Organization title is verified and pass");
	}
	else
	{
		System.out.println("title is not verified and fail");  
	}
  }
  
  //Business logic for Product
  public void productValidation(WebDriver driver,String data)
  {
	  String title = actualProductData.getText();
		 
		if(title.contains(data))
		{
			System.out.println("Product is created and pass");
		}
		else
		{
			System.out.println("Product is not created and fail");  
		}
  }
 }
