package utils;

import java.util.Date;

public class CommonUtils {
	
	public static final int IMPLICIT_WAIT_TIME = 10;
	public static final int PAGE_LOAD_TIME = 15;
	public static final int EXPLICIT_WAIT_BASIC_TIME = 25;
	
	public  String getEmailWithTimeAndDateStamp() {
		
		Date date =  new Date();
		return "amotoori"+date.toString().replace(" ","_").toString().replace(":","_")+"@gmail.com";
		
	}

}
