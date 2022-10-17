package Practice;

import org.testng.annotations.Test;

public class SampleTestNG 
{
	@Test
   public void createCustomer()
   {
	   System.out.println("customer details created");
	   int[]arr= {1,2,3};
	   System.out.println(arr[5]);
   }
	@Test(dependsOnMethods="createCustomer")
   public void modifyCustomer()
   {
	   System.out.println("customer details modified");
   }
	@Test(dependsOnMethods="createCustomer")
   public void deleteCustomer()
   {
	   System.out.println("customer details deleted");
   }
}
