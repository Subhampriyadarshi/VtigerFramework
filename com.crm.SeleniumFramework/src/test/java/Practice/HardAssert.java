package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssert
{
	@Test
   public void createCustomerTest()
   { 
	   
	   System.out.println("step1");
	   System.out.println("step2");
	   Assert.assertEquals("A", "A");
	   System.out.println("step3");
	   System.out.println("step4");
   }
	@Test
	public void modifyCustomerTest()
	{
		System.out.println("----------------");
		System.out.println("step1");
		System.out.println("step2");
		System.out.println("step3");
	}
}
