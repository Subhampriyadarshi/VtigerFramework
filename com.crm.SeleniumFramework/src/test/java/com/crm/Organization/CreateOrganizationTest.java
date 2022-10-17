package com.crm.Organization;

import java.io.IOException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.crm.Generic_Utilities.BaseClass;
import com.crm.ObjectRepository.CreateNewOrganization;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.ValidationAndVerification;


//@Listeners(com.crm.Generic_Utilities.ListenerImplimentationClass.class)
public class CreateOrganizationTest extends BaseClass {

	@Test(groups = "smokeTest")
	public void createOrganisationTest() throws IOException, InterruptedException
	{
		//Generic_Utilities classes
//		WebDriver_Utility wlib=new WebDriver_Utility();
//		File_Utility flib=new File_Utility();
//		Java_Utility jlib=new Java_Utility();
//		Excel_Utiity elib=new Excel_Utiity();
		
		//Generating random number using java utility class
		int ranNum = jlib.getRanDomNum();
		
		//Opening the Application for different Browsers is accessing from BaseClass
		
//		//Implicitly Wait
//		wlib.waitForPageLoad(driver);
//		//Maximize the window
//		driver.manage().window().maximize();
		
		//Retrieving data from property file
//		String URL = flib.getPropertyKeyValue("url");
//		String UserName = flib.getPropertyKeyValue("un");
//		String PassWord = flib.getPropertyKeyValue("pw");
				
//		driver.get(URL);
//		
//		LoginPage log=new LoginPage(driver);
//	    log.login(UserName, PassWord);
		
	    HomePage hp=new HomePage(driver);
	    hp.getOrgLink().click();
	    
	    // For intentionally failing the TestCase using HardAssert and take the screenshot 
	    //Assert.assertEquals(true, false); 
	    
		//Retrieving data from excel sheet
		String data = elib.getDataFromExcel("Organisation", 0, 0)+ranNum;
		
		CreateNewOrganization org=new CreateNewOrganization(driver);
		org.getCreateNewOrg().click();
		org.createOrgName(data);
	
//		SoftAssert soft=new SoftAssert();
//		soft.assertEquals(true, false);
//		soft.assertAll();
		
		org.getSaveButton().click();


		        //verifying title of the organization created
		        ValidationAndVerification orgInfo=new ValidationAndVerification(driver);
		        orgInfo.organizationValidation(driver, data);
		       
//		        String title = orgInfo.getSuccessMassage().getText(); 
//		       
//		        
//				Thread.sleep(2000);
//				if(title.contains(data))
//				{
//					System.out.println("Organization title is verified and pass");
//				}
//				else
//				{
//					System.out.println("title is not verified and fail");  
//				}
				
//				hp.getAdmiBtn().click();
//				hp.getSignOutLink().click();
						
	}
	
	//for regional regression testing
//	@Test(groups = "smokeTest")
//	public void modifyOrganisation()
//	{
//		System.out.println("modify the Organisation"); 
//	}

}
