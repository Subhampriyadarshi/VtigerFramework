package com.crm.Campaign;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.Generic_Utilities.BaseClass;
import com.crm.Generic_Utilities.Excel_Utiity;
import com.crm.Generic_Utilities.File_Utility;
import com.crm.Generic_Utilities.Java_Utility;
import com.crm.Generic_Utilities.WebDriver_Utility;

import com.crm.ObjectRepository.CreateNewCampaign;
import com.crm.ObjectRepository.CreateNewProduct;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.ValidationAndVerification;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignWithProductTest extends BaseClass {

	@Test(groups = {"regressionTest","smokeTest"})
	 public void createCampaignWithProductTest() throws IOException, InterruptedException 
	 {
		
		 //Generic_Utilities classes
//		 WebDriver_Utility wlib=new WebDriver_Utility();
//		 File_Utility flib=new File_Utility();
//		 Java_Utility jlib=new Java_Utility();
//		 Excel_Utiity elib=new Excel_Utiity();
		 
		 //Generating random number using java utility class
		 int ranNum = jlib.getRanDomNum();
     
	     //Opening the Application for different Browsers is accessing from BaseClass	 
    
         //Implicit wait
//         wlib.waitForPageLoad(driver);
         //Maximize the window 
//         driver.manage().window().maximize();
     
         //retrieving the data from property file
//       String URL = flib.getPropertyKeyValue("url");
//		 String UserName = flib.getPropertyKeyValue("un");
//		 String PassWord = flib.getPropertyKeyValue("pw");
//     
//       driver.get(URL);
//        
//       LoginPage log=new LoginPage(driver);
//       log.login(UserName, PassWord);
     
		 //Product link
         HomePage hp=new HomePage(driver);
         hp.getProdLink().click(); 	
		
		 String data = elib.getDataFromExcel("Product", 0, 0)+ranNum;
		
		 //creating new Product
		 CreateNewProduct prod=new CreateNewProduct(driver);
	     prod.getCreateNewProd().click();
	     prod.createProdName(data);
	     prod.getSaveButton().click();
		
		        //Campaign link
		        hp.getMoreLink().click();
		        hp.getCampaignLink().click();
		     
				String data1 = elib.getDataFromExcel("Campaign", 0, 0)+ranNum;
				
				//Creating new Campaign
				CreateNewCampaign campaign=new CreateNewCampaign(driver);
				campaign.getCreateNewCampaign().click();
				campaign.createCampaignName(data1);
								
			    driver.findElement(By.xpath("//img[@title='Select']")).click();
				
				//window switching from campaign to product	 
				wlib.switchToWindow(driver, data);
				
				driver.findElement(By.id("search_txt")).sendKeys(data);
				driver.findElement(By.name("search")).click();
				
				//Dynamic Xpath
				driver.findElement(By.xpath("//a[text()='"+data+"']")).click();
				
				//switch back window from product to campaign
				wlib.switchToWindow(driver, data1);
				
				campaign.getSaveButton().click();

				Thread.sleep(2000);
				
				//Verifying the Campaign & Product created
				ValidationAndVerification campaignInfo=new ValidationAndVerification(driver);
				campaignInfo.campaignValidation(driver, data1);
				
//				CampaignInfo campaignInfo=new CampaignInfo(driver);
//				String title = campaignInfo.getSuccessMassage().getText();
//				
//				if(title.contains(data1))
//				{
//					System.out.println("campaign & product is created and pass");
//				}
//				else
//				{
//					System.out.println("fail");
//				}
				
//				hp.getAdmiBtn().click();
//				hp.getSignOutLink().click();
		    
	}

}
