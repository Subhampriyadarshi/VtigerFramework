package com.crm.Generic_Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class File_Utility {

	/**
	 * this method is used to launch the application
	 * @param Key
	 * @return
	 * @throws IOException
	 */
	public String getPropertyKeyValue(String Key) throws IOException
	{
	  //FileInputStream fis=new FileInputStream("./Common_Data.properties");
		FileInputStream fis=new FileInputStream(ipathConstant.PROPERTYFILE_PATH);
		Properties pro=new Properties();
		pro.load(fis);
		String value = pro.getProperty(Key);
		
		return value;
		
	}

}
