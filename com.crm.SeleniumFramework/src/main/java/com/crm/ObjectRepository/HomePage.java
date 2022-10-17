package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
  
	@FindBy(xpath="(//a[text()='Organizations'])")
	private WebElement orgLink;
	
	@FindBy(xpath="//a[text()='Products']")
	private WebElement prodLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/menuDnArrow.gif']")
	private WebElement moreLink;
	@FindBy(xpath="//a[@name='Campaigns']")
	private WebElement campaignLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement admiBtn;
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signOutLink;
	
	public WebElement getOrgLink() {
		return orgLink;
	}
	
	public WebElement getProdLink() {
		return prodLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getCampaignLink() {
		return campaignLink;
	}

	public WebElement getAdmiBtn() {
		return admiBtn;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}
	
	public void homePage()
	{
		orgLink.click();
		prodLink.click();
		moreLink.click();
		campaignLink.click();
		admiBtn.click();
		signOutLink.click();
	}
}
