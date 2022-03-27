package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.Rediff.base.base;

public class TestUtil extends base{

	public static Workbook book;
	public static Sheet sheet; 
	
	public static Select select;
	public static Actions actions;
	public static Alert alert;
	public static Logger log =LogManager.getLogger(base.class.getName());
	
	//clickOn
      public static void clickOn(WebDriver driver, WebElement element, int timeout) {
    	  
    	
	  new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
	  element.click();
      }
      
      //clear text
      public static void clear(WebElement element) {
    	  
      	
    	  //new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
    	  element.click();
          }
    
    
    //Send keys
        public static void sendKeys(WebDriver driver, WebElement element, int timeout, String value) {
    	
    	new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
    	element.sendKeys(value);
        }
    
    
    //Select by drop down value
        public static void selectValueFromDropDownByValue(WebElement element, String value) {
    	
    	select = new Select(element);
    	select.selectByValue(value);
    	
        }
        
      //selectByVisibleText 
        public static void selectDropDownbyVisibleText(WebElement element, String value) {
    	
    	select = new Select(element);
    	select.selectByVisibleText(value);
    	
        }
        
     //navigate previous page
        public static void navigateBack() {
        	//driver.navigate().back();
        }
        
        
      //navigate forward page
        public static void navigateForward() {
        	//driver.navigate().forward();
        }
        
    //Accept Alert pop up
        public static void acceptAlertPopup() throws InterruptedException{
        	try {
        		alert = driver.switchTo().alert();
        		System.out.println(alert.getText());
        		Thread.sleep(2000);
        		alert.accept();
        		log.info("Alert Accepted");
        	    }
        	catch(Exception e) {
        		System.out.println("Alert Error : acceptAlertPopup()");
        	    }
        }
        
        
        //Dismiss Alert pop up
        public static void dismissAlertPopup() throws InterruptedException{
        	try {
        		alert = driver.switchTo().alert();
        		System.out.println(alert.getText());
        		Thread.sleep(2000);
        		alert.dismiss();
        		//Log.info("Alert Dismissed");
        	    }
        	catch(Exception e) {
        		System.out.println("Alert Error : acceptAlertPopup()");
        	    }
        }
        
        
        //get page Title
        public static String getWindowTitle(WebDriver driver) {
        	return driver.getTitle();
        	 
        }
        
      //Maximize window
        public static void getMaximizeWindow(WebDriver driver) {
        	
        	 driver.manage().window().maximize();
        	 
        }
        
        
        //Get Required String/Value/ID
        public static String getCustomized_String_Value_ID(String AlertID, int startpos, int endpos) {
        	String alertID= AlertID.substring(startpos, endpos);
			return alertID;
        	
        }
        
        //To match given Value with LISTOFELEMENTS and click on it
        public static void clickOnMatchValue(List<WebElement> listOfElements, String valueToBeMatched) {
        	
        	for(WebElement element : listOfElements) {
        		if(element.getText().equalsIgnoreCase(valueToBeMatched)) {
        			element.click();
        			return;
        		}
        	}
        }
        
        
        //To print all Values and Select a required value from Drop Down
        public static void printAllDDValue_ClickRequiredValue(String xpathValue, String value){
        	
        	List<WebElement> list = driver.findElements(By.xpath(xpathValue));
        	System.out.println("Count of DropDown Values :"+list.size() );
        	
        	for(int i=0; i<list.size();i++) {
        		System.out.println(list.get(i).getText());
        		if(list.get(i).getText().equals(value)) {
        			list.get(i).click();
        			break;
        		}
        	}
        	
        }
    
	
        //Select Radio button
        public static void selectRadioButton(String btn_Radio, String value) {
        	List<WebElement> list = driver.findElements(By.xpath(btn_Radio));
        	System.out.println("Count of DropDown Values :"+list.size() );
        	
        	for(int i=0; i<list.size();i++) {
        		//System.out.println(list.get(i).getText());
        		if(list.get(i).getText().equals(value)) {
        			list.get(i).click();
        			break;
        		}
        	}
        	
        }
	
        
   // To check Element is Displayed or not
        public static void isElementDisplayed(WebElement element) {
        	boolean elementDisplayed= element.isDisplayed();
        	
        	if(elementDisplayed) {
        		System.out.println(element+" "+"object is Displayed");
        	}
        	else {
        		System.out.println(element+" "+"object is not Displayed");
        	}
        }
        
     // To check Element is Enabled or not
        public static void isElementEnabled(WebElement element) {
        	boolean elementEnabled= element.isEnabled();
        	
        	if(elementEnabled) {
        		System.out.println(element+" "+"object is Enabled");
        	}
        	else {
        		System.out.println(element+" "+"object is not Enabled");
        	}
        }
        
        
        
        
        
// *****************************Excel sheet handling************************************//
        
public static Object[][] getExcelData(String sheetName, String filePath1) throws InvalidFormatException{
	
		
		FileInputStream file=null;
		
		    try {
			    file = new FileInputStream(filePath1);
			    System.out.println("File is :"+file.toString());
		        }
		    catch(FileNotFoundException e) {
			  e.printStackTrace();
		        }
		    try {
		    	
		    	//book=new XSSFWorkbook(file);
		    	//book=new XSSFWorkbook(file);
		    	book=WorkbookFactory.create(file);
		    }
		    catch(IOException e) {
		    	e.printStackTrace();
		    }
		    sheet=book.getSheet(sheetName);
		    
		    
		    Object data[][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		    
		    for(int i=0;i<sheet.getLastRowNum();i++) {
		    	
		    	for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
		    		data[i][k]=sheet.getRow(i+1).getCell(k).toString();
		    		System.out.println("Testdata :"+data[i][k]);
		    	}
		    }
		    
		    //Log.info("Data Extracted from Excel sheet successfully");
		return data;
		
		
	}

//****************************************Extent Report*************************************//

// Extend Report 1
  public static String getSystemDate()
  {
	  DateFormat dateFormat= new SimpleDateFormat("_ddMMyyyy_HHmmss");
	  Date date = new Date();
	  return dateFormat.format(date);
  }
  
  

 // Extend Report 2
   public static String getScreenShot(WebDriver driver, String screenshotName) throws IOException
   {
 	  String dateName= new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
 	  TakesScreenshot ts = (TakesScreenshot) driver;
 	  File source = ts.getScreenshotAs(OutputType.FILE);
 	  
 	  String destination = System.getProperty("user.dir") + "\\Screenshots\\" + screenshotName + dateName + ".png";
 	  File finalDestination = new File(destination);
 	  FileUtils.copyFile(source, finalDestination);
 	  return destination;
 	 
   }
   
   
   
   // *******************************ACTIONS*************************************//
  
   
   //simply MouseOver
   public static void moveToElement(WebDriver driver, WebElement element) {
	   actions = new Actions(driver);
	   actions.moveToElement(element).build().perform();
   }
   
   //MouseOver and Click
   public static void clickOnElementUsingActions(WebDriver driver, WebElement element) {
	   actions = new Actions(driver);
	   actions.moveToElement(element).click().perform();
   }
   
 //MouseOver and Double click
   public static void doubleClickusingActions(WebDriver driver, WebElement element) {
	   actions = new Actions(driver);
	   actions.doubleClick(element).click().perform();
   }
   
   //MouseOver and Right Click
   public static void rightClickusingActions(WebDriver driver, WebElement element) {
	   actions = new Actions(driver);
	   actions.contextClick(element).build().perform();
   }
   
 //Scroll Up
   public static void scrollUpUsingActions(WebDriver driver) {
	   actions = new Actions(driver);
	   actions.sendKeys(Keys.PAGE_UP).build().perform();
   }
  
 //Scroll down
   public static void scrollDownUsingActions(WebDriver driver) {
	   actions = new Actions(driver);
	   actions.sendKeys(Keys.PAGE_DOWN).build().perform();
   }
  
  
  
  
  // Handle Multiple Windows // Switch between Multiple window
   
   public static void switchWindow(WebDriver driver, String firstWindow, String secondWindow) {
	   
	   Set<String> windowHandles = driver.getWindowHandles();
	   
	   for(String windows : windowHandles) {
		   
		   if(!windows.equals(firstWindow) && !windows.equals(secondWindow)) {
			   
			   driver.switchTo().window(windows);
		   }
		   
	   }
   }
  
  
  
  
  
  
  
  
  
  
	
}
