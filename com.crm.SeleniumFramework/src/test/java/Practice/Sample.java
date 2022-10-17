package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample 
{

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		String Key="webdriver.chrome.driver";
		String value="C:\\Users\\Admin\\.eclipse\\com.crm.SeleniumFramework\\chromedriver.exe";
		System.setProperty(Key, value);
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		//Retrieving data from property file
		FileInputStream fis=new FileInputStream("./Common_Data.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url");
		String UserName = pro.getProperty("un");
		String PassWord = pro.getProperty("pw");
		
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(UserName);
		driver.findElement(By.name("user_password")).sendKeys(PassWord);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//Retrieving data from excel sheet
		FileInputStream fis1=new FileInputStream("./Book2.xlsx");
		Workbook book=WorkbookFactory.create(fis1);
		Sheet sh=book.getSheet("Sheet1");
		Row row=sh.getRow(0);
		Cell cell = row.getCell(0);
		String val = cell.getStringCellValue();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(val);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		//verifying title of the organization created
		String title=driver.findElement(By.xpath("//span[contains(text(),'subham')]")).getText();
		Thread.sleep(2000);
		if(title.contains(val))
		{
			System.out.println("title is verified and pass");
		}
		else
		{
			System.out.println("title is not verified and fail");  
		}
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
	}

}
