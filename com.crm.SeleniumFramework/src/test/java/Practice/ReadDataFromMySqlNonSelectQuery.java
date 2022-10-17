package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.jdbc.Driver;

public class ReadDataFromMySqlNonSelectQuery {

	public static void main(String[] args) throws SQLException
	{
		  //step 1: Register or load the Mysql database
				Driver driver=new Driver();
				DriverManager.registerDriver(driver);
				
				
		  //step 2: Get connect to database
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_yantra","root","root");
				
		  //step 3: create sql statement
				Statement stat =  conn.createStatement();
				
				String query = "insert into student(first_name,last_name,address)values('neha','priyadarshi','india')";
				String query1 = "insert into student(first_name,last_name,address)values('rahul','priyadarshi','india')";
				
		 //step 4: Execute query
				int result = stat.executeUpdate(query);
				int result1 = stat.executeUpdate(query1);

				if(result==1 && result1==1)
				{
					System.out.println("User is created");
				}
				else
				{
					System.out.println("User is not created");
				}
				

	}

}
