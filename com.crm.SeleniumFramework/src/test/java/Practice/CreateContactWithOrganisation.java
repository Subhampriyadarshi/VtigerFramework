package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateContactWithOrganisation {

	public static void main(String[] args) throws IOException, InterruptedException
	{
		 String key = "webdriver.chrome.driver";
	     String value = "C:\\Users\\Admin\\.eclipse\\com.crm.SeleniumFramework\\chromedriver.exe";
	     System.setProperty(key, value);
	     WebDriver driver=new ChromeDriver();
	     driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	     driver.manage().window().maximize();
	     
	     //retrieving the data from property file
	     FileInputStream fis=new FileInputStream("Common_Data.properties");
	     Properties p=new Properties();
	     p.load(fis);
	     String url=p.getProperty("url");
	     String username = p.getProperty("un");
	     String password = p.getProperty("pw");
	     
	        driver.get(url);
			driver.findElement(By.name("user_name")).sendKeys(username);
			driver.findElement(By.name("user_password")).sendKeys(password);
			driver.findElement(By.id("submitButton")).click();
			
			//Organization data
			 driver.findElement(By.linkText("Organizations")).click();
		      driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		      
		            Random ran=new Random();
				    int RanNum=ran.nextInt(1000);
		    		FileInputStream fis1=new FileInputStream("./Book2.xlsx");
		    		Workbook book=WorkbookFactory.create(fis1);
		    		Sheet sh=book.getSheet("Organisation");
		    		Row row=sh.getRow(0);
		    		Cell cell = row.getCell(0);
		    		String organisationName = cell.getStringCellValue()+RanNum;
		    		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(organisationName);
		    		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
			
			//Contact data
		    Thread.sleep(2000);
			driver.findElement(By.linkText("Contacts")).click();
			driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
			driver.findElement(By.name("salutationtype")).click();
			driver.findElement(By.xpath("//option[@value='Mr.']")).click();
			
			Sheet sh1=book.getSheet("ContactName");
			Row row1=sh1.getRow(0);
			Cell cel=row1.getCell(0);
			Cell cel1=row1.getCell(1);
			String firstName=cel.getStringCellValue()+RanNum;
			String lastName = cel1.getStringCellValue()+RanNum;
			
			driver.findElement(By.name("firstname")).sendKeys(firstName);
			driver.findElement(By.name("lastname")).sendKeys(lastName);
			
			driver.findElement(By.xpath("//img[@title='Select']")).click();
			
			//window switching
			Set<String> allId= driver.getWindowHandles();
			Iterator<String> it=allId.iterator();
			while(it.hasNext())
			{
				String wid = it.next();
				driver.switchTo().window(wid);
				if(driver.getTitle().contains("Accounts&action"))
				{
					break;
				}
			}
			
			driver.findElement(By.id("search_txt")).sendKeys(organisationName);
			driver.findElement(By.name("search")).click();
	     
			//Dynamic Xpath
			driver.findElement(By.xpath("//a[text()='"+organisationName+"']")).click();
			
			
			//switch back window
			Set<String> allId1=driver.getWindowHandles();
			Iterator<String> it1=allId1.iterator();
			while(it1.hasNext())
			{
				String wid = it1.next();
				driver.switchTo().window(wid);
				if(driver.getTitle().contains("Contacts&action"))
				{
					break;
				}
			}	
		   driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		   Thread.sleep(2000);
		   String actData = driver.findElement(By.cssSelector("span.dvHeaderText")).getText();
			if(actData.contains(firstName))
			{
				System.out.println("Contact & Organisation is created and pass");
			}
			else
			{
				System.out.println("fail");
			}
			
	driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		   
	}
}


