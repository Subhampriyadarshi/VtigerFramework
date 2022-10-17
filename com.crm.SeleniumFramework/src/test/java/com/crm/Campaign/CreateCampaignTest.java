package com.crm.Campaign;

import java.io.IOException;
import org.testng.annotations.Test;
import com.crm.Generic_Utilities.BaseClass;
import com.crm.ObjectRepository.CreateNewCampaign;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.ValidationAndVerification;

public class CreateCampaignTest extends BaseClass
{

	@Test(groups = {"regressionTest","smokeTest"})
	 public void createCampaignTest() throws IOException, InterruptedException 
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
		 
		 HomePage hp=new HomePage(driver);
		 hp.getMoreLink().click();
	        hp.getCampaignLink().click();
	     
			String data1 = elib.getDataFromExcel("Campaign", 0, 0)+ranNum;
			
			//Creating new Campaign
			CreateNewCampaign campaign=new CreateNewCampaign(driver);
			campaign.getCreateNewCampaign().click();
			campaign.createCampaignName(data1);  
		    
			campaign.getSaveButton().click();
			
			//Verifying the Campaign & Product created
			ValidationAndVerification campaignInfo=new ValidationAndVerification(driver);
			campaignInfo.campaignValidation(driver, data1);
			
//			CampaignInfo campaignInfo=new CampaignInfo(driver);
//			String title = campaignInfo.getSuccessMassage().getText();
//			
//			if(title.contains(data1))
//			{
//				System.out.println("campaign & product is created and pass");
//			}
//			else
//			{
//				System.out.println("fail");
//			}
			
//			hp.getAdmiBtn().click();
//			hp.getSignOutLink().click();
		 
	 }
	
}