package com.crm.Product;

import java.io.IOException;
import org.testng.annotations.Test;
import com.crm.Generic_Utilities.BaseClass;
import com.crm.ObjectRepository.CreateNewProduct;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.ValidationAndVerification;

public class DeleteProductTest extends BaseClass {

	@Test
	public void deleteProductTest() throws IOException, InterruptedException
	{
		//Generic_Utilities classes
//		WebDriver_Utility wlib=new WebDriver_Utility();
//		File_Utility flib=new File_Utility();
//		Java_Utility jlib=new Java_Utility();
//		Excel_Utiity elib=new Excel_Utiity();
		
		//Generating random number using java utility class
		int ranNum = jlib.getRanDomNum();
		
		  //Operating with different Browsers is accessing from BaseClass
		
		  //Implicit Wait
//		  wlib.waitForPageLoad(driver);
	      
		  //Maximize the window
//	      driver.manage().window().maximize();
	      
	      //Retrieving data from property file 
//	      String url = flib.getPropertyKeyValue("url");
//	      String UserName =flib.getPropertyKeyValue("un");
//	      String PassWord =flib.getPropertyKeyValue("pw");
//	      
//	      driver.get(url);
//	      
//	      LoginPage log=new LoginPage(driver);
//		  log.login(UserName, PassWord);
	      
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
	        
//	        ProductInfo proInfo=new ProductInfo(driver);
//	        String title = proInfo.getSuccessMassage().getText();
//	 
//			Thread.sleep(2000);
//			if(title.contains(data))
//			{
//				System.out.println("Product is created and pass");
//			}
//			else
//			{
//				System.out.println("Product is not created and fail");  
//			}
	        
	        //Deleting the Product created
	        prod.getDeleteButton().click();


	        //Accepting the Alert Popup's 
	        wlib.switchToWindowAndAccept(driver);
	      
	        System.out.println("Product is deleted successfully");
	     
//	        hp.getAdmiBtn().click();
//			hp.getSignOutLink().click();
			
	}

}
