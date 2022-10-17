package com.crm.Generic_Utilities;

import java.util.Random;

public class Java_Utility {
    /**
     * this is java 
     * @return
     */
	public int getRanDomNum()
	{
		Random ran=new Random();
		int RanNum = ran.nextInt(1000);
		return RanNum;
	}

}
