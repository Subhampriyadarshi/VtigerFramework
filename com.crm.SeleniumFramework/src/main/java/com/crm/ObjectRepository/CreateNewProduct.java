package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProduct 
{
   public CreateNewProduct(WebDriver driver)
   {
	   PageFactory.initElements(driver, this);
   }
   
   @FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
   private WebElement createNewProd;
   
   @FindBy(xpath = "//input[@name='productname']")
   private WebElement prodName;
   
   @FindBy(xpath = "(//input[@title='Save [Alt+S]'])")
   private WebElement saveButton; 
   
   @FindBy(xpath = "(//input[@title='Delete [Alt+D]'])")
   private WebElement deleteButton;
   
   public WebElement getCreateNewProd() {
	   return createNewProd;
   }

   public WebElement getProdName() {
	   return prodName;
   }

   public WebElement getSaveButton() {
	   return saveButton;
   }
   
   public WebElement getDeleteButton() {
	return deleteButton;
}

//Business logic  
   public void createOrg()
   {
	   createNewProd.click();
	   saveButton.click();
	   deleteButton.click();
   }
   
   public void createProdName(String data)
   {
	   prodName.sendKeys(data);
   }

}
