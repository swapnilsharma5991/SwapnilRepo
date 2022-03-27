package com.qa.Rediff.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.Rediff.Constants.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class base {
	public static Logger log =LogManager.getLogger(base.class.getName());
	

	public static WebDriver driver;
	public static Properties prop;
	//public static WebDriver driver;
	
	
public WebDriver initializeDriver() throws IOException
{	
  prop= new Properties();

  FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/qa/Rediff/config/data.properties");
  prop.load(fis);
  String browserName=prop.getProperty("browser");
  System.out.println(browserName);



//browser type
 if(browserName.equals("chrome"))
 {
	 System.setProperty("webdriver.chrome.driver", "C://Work//cdriver//chromedriver.exe");
	 driver= new ChromeDriver();
 }
 else if (browserName.equals("firefox"))
 {
	 driver= new FirefoxDriver();
 }
 else if (browserName.equals("IE"))
 {
   //	IE code
 }


 driver.manage().window().maximize();
 driver.manage().deleteAllCookies();
 driver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
 driver.manage().timeouts().implicitlyWait(Constants.IMPLECIT_WAIT, TimeUnit.SECONDS);
 driver.get(prop.getProperty("url"));
return driver;
}
}
