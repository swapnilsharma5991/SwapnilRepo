package com.Rediff.Constants;

public class Constants {
	
	public static final String CHROME_DRIVER_PATH =System.getProperty("user.dir")+"/Drivers/chromedriver.exe";
	public static final String IE_DRIVER_PATH =System.getProperty("user.dir")+"/Drivers/chromedriver.exe";
	public static final String FF_DRIVER_PATH =System.getProperty("user.dir")+"/Drivers/chromedriver.exe";
	
	
	public static final long PAGE_LOAD_TIMEOUT=100;
	public static final long IMPLECIT_WAIT=15;
	public static final long EXPLECIT_WAIT=15;
	
	public static final int SHORT_WAIT=3000;
	public static final int MEDIUM_WAIT=6000;
	public static final int LONG_WAIT=10000;
	
	public static final String LOGIN_PAGE_TITLE="Rediff";
	public static final String HOME_PAGE_TITLE="Rediff Home";
	

	public static final String FORM_CREATE_TEST_DATA_SHEET_PATH = System.getProperty("user.dir")+"/src/main/java/com/qa/Rediff/TestData/Book2.xlsx";
}
