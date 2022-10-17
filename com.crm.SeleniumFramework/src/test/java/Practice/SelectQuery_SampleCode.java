package Practice;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import com.mysql.jdbc.Driver;

public class SelectQuery_SampleCode {

	public static void main(String[] args) throws SQLException
	{
      Connection conn=null;
      try {
    	  Driver driverRef=new Driver();
    	  //step1: load/register mysql db
    	  DriverManager.registerDriver(driverRef);
    	  
    	  //step2: connect to db
    	  conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test_yantra","root","root");
    	  System.out.println("connection is done");
    	  
    	  //step3: create query statement
    	  Statement stat=conn.createStatement();
    	  String query = "select * from employee";
    	  
    	  //step4: execute the query
    	  ResultSet resultset=stat.executeQuery(query);
    	  while(resultset.next())
    	  {
    		  System.out.println(resultset.getInt(1)+"\t"+resultset.getString(2)+"\t"+resultset.getString(3)+"\t"+resultset.getString(4)+"\t"+resultset.getInt(5));  
    	  }  
      }catch (Exception e) {
      } finally {
    	  //step5: close the connection
    	  conn.close();
    	  System.out.println("==========close db connection=========");
      }
	}
}
