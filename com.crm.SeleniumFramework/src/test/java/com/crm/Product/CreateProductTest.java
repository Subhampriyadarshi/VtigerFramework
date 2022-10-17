package com.crm.Product;

import java.io.IOException;
import org.testng.annotations.Test;
import com.crm.Generic_Utilities.BaseClass;
import com.crm.ObjectRepository.CreateNewProduct;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.ValidationAndVerification;


public class CreateProductTest extends BaseClass {
 
	@Test(groups = "regressionTest")
	public void createProductTest() throws IOException, InterruptedException 
	{
		//Generic Utility class
//		WebDriver_Utility wlib=new WebDriver_Utility();
//		File_Utility flib=new File_Utility();
//		Java_Utility jlib=new Java_Utility();
//		Excel_Utiity elib=new Excel_Utiity();
		
		//Generating random number using java utility class
		int ranNum = jlib.getRanDomNum();
		
		//Opening Browser for different platform is accessing from BaseClass
		
		//Implicit Wait
//		wlib.waitForPageLoad(driver);
		
		//Maximize the window
//		driver.manage().window().maximize();
		
		//Retrieving data from property file
//		String URL = flib.getPropertyKeyValue("url");
//		String UserName = flib.getPropertyKeyValue("un");
//		String PassWord = flib.getPropertyKeyValue("pw");
//		
//		driver.get(URL);
//		
//		LoginPage log=new LoginPage(driver);
//		log.login(UserName, PassWord);
		   //Retrieving data from home page for clicking product link
		   HomePage hp=new HomePage(driver);
		   hp.getProdLink().click();
	
		        //Retrieving data from excel sheet
		       
		        String data = elib.getDataFromExcel("Product", 0, 0)+ranNum;
		        
		        CreateNewProduct prod=new CreateNewProduct(driver);
		        prod.getCreateNewProd().click();
		        prod.createProdName(data);
		        prod.getSaveButton().click();
		       
		        //Verifying the Product Created
		        ValidationAndVerification proInfo=new ValidationAndVerification(driver);
		        proInfo.productValidation(driver, data);
//		        String title = proInfo.getSuccessMassage().getText();
//		 
//				Thread.sleep(2000);
//				if(title.contains(data))
//				{
//					System.out.println("Product is created and pass");
//				}
//				else
//				{
//					System.out.println("Product is not created and fail");  
//				}
				
//			    hp.getAdmiBtn().click();
//				hp.getSignOutLink().click();
				
		
	}
	
	

}
