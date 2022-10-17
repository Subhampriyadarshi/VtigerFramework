package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest1
{
	 @Test(dataProvider="dataProvider_test")
	  public void moduleDetails(String compName,String phno,String email) throws InterruptedException
	  {
		 String Key="webdriver.chrome.driver";
		 String value="C:\\Users\\Admin\\Downloads\\chromedriver.exe";
		 System.setProperty(Key, value);
		 WebDriver driver=new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 
		 driver.get("http://localhost:8888/");
		 driver.findElement(By.name("user_name")).sendKeys("admin");
		 driver.findElement(By.name("user_password")).sendKeys("admin");
		 driver.findElement(By.id("submitButton")).click();
		 
		 driver.findElement(By.linkText("Leads")).click();
		 driver.findElement(By.xpath("//img[@alt='Create Lead...']")).click();
		 driver.findElement(By.name("company")).sendKeys(compName);
		 driver.findElement(By.id("phone") ).sendKeys(phno);
		 driver.findElement(By.id("email")).sendKeys(email);
		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 
		 driver.quit();
		 Thread.sleep(2000);
	  }
		@DataProvider
	    public Object[][] dataProvider_test()
	    {
	    	Object[][] objArr=new Object[3][3];
	    	objArr[0][0]="XYZ";
	    	objArr[0][1]="7845125684";
	    	objArr[0][2]="XYZ@gmail.com";
	    	
	    	objArr[1][0]="ABC";
	    	objArr[1][1]="8445225684";
	    	objArr[1][2]="ABC@gmail.com";
	    	
	    	objArr[2][0]="MNP";
	    	objArr[2][1]="9454512584";
	    	objArr[2][2]="MNP@gmail.com";
	    	
	    	return objArr;
	    }
		 
}
