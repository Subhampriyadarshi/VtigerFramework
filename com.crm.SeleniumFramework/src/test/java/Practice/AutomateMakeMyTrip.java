package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomateMakeMyTrip {

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
	     String url=p.getProperty("url1");
	     driver.get(url);
	     
	     //closing the popups
	     driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
	      
	     //From
	     String srcCity = "Mumbai, India";
	     WebElement src=driver.findElement(By.xpath("//input[@id='fromCity']"));
	     src.sendKeys("'"+srcCity+"'");
	     driver.findElement(By.xpath("//p[text()='"+srcCity+"']")).click();
 		
	     //To
	     String desCity="Patna, India";
	     WebElement des=driver.findElement(By.xpath("//input[@id='toCity']"));
	     des.sendKeys("'"+desCity+"'");
	     driver.findElement(By.xpath("//p[text()='"+desCity+"']")).click();
	     
	     driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
	     Thread.sleep(2000);
	     
	     String month="September 2022";
	     String date="29";
	     
	     //Dynamic xpath for departure
	     WebElement depart = driver.findElement(By.xpath("//div[text()='"+month+"']"+"/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']"));
	     depart.click();
	     
	     driver.findElement(By.xpath("//span[text()='RETURN']")).click();
	     Thread.sleep(2000);
	    
	     String month1 = "October";
	     String date1 = "12";
	     
	     //Dynamic xpath for return
	     WebElement returns=driver.findElement(By.xpath("//div[text()='"+month1+"']"+"/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date1+"']"));
         returns.click();
         
         driver.findElement(By.xpath("//span[text()='Travellers & CLASS']")).click();
         
         String adult = "adults-2";
         String children = "children-1";
         String infant = "infants-1";
         String Class = "Economy/Premium Economy";
         driver.findElement(By.xpath("//li[@data-cy='"+adult+"']")).click();
         driver.findElement(By.xpath("//li[@data-cy='"+children+"']")).click();
         driver.findElement(By.xpath("//li[@data-cy='infants-1']")).click();
         driver.findElement(By.xpath("//li[text()='Economy/Premium Economy']")).click();
         driver.findElement(By.xpath("//button[text()='APPLY']")).click();
         
         //Navigating to Hotels
         driver.findElement(By.xpath("(//a[@class='makeFlex hrtlCenter column'])[1]")).click();
         driver.findElement(By.id("city")).click();
	}
	    

}
