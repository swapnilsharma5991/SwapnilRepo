package tests;

import org.testng.annotations.Test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import com.qa.Rediff.base.base;
import com.qa.Rediff.pageObjects.Rediff_HomePage;
import com.qa.Rediff.pageObjects.Rediff_LoginPage;
import com.Rediff.Constants.Constants;
import utilities.TestUtil;

public class Rediff_LoginTest extends base {
	TestUtil ex;
	Rediff_HomePage homepage;
	Rediff_LoginPage logRP;
	String sheetName="sheet1";
	public static Logger log =LogManager.getLogger(base.class.getName());
	
	
	
	public Rediff_LoginTest() throws IOException {
		super();
		
	}

	
	@BeforeTest
	public void setUp() throws IOException{
	    initializeDriver();
		ex = new TestUtil();
		logRP=new Rediff_LoginPage();
		homepage=new Rediff_HomePage();
		
		
	}
	
	
	@Test
	public void rediffmethod1() throws IOException, InterruptedException, AWTException {
//		homepage.loginPageWindow();
//		logRP.validateRediffLogin(prop.getProperty("username"), prop.getProperty("password"));
//		log.info("loginRediffTest initiated");
		
		//mounica
		System.out.println("File process initiate");
		driver.findElement(By.id("wdgt-file-upload")).click();
		Robot r = new Robot();
		StringSelection filepath = new StringSelection("C:\\Users\\amite\\OneDrive\\Desktop\\Textfileupload\\SwapnilSharmaCV.docx");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null); //
			r.keyPress(KeyEvent.VK_CONTROL);//
			Thread.sleep(2000);
			r.keyPress(KeyEvent.VK_V);
			Thread.sleep(2000);
			r.keyRelease(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			System.out.println("File Uploaded successfully");
	}
//	@DataProvider
//	public Object[][] getRediffData() throws IOException, InvalidFormatException{
//		//Object data[][]=readExcel.getExcelData(sheetName, filePath1);
//		Object data[][]=TestUtil.getExcelData(sheetName, Constants.FORM_CREATE_TEST_DATA_SHEET_PATH);
//		
//		
//		return data;
//		}
//	
//	@Test(dataProvider="getRediffData")
//	public void rediffmethod1(String column1, String column2, String column3, String column4) throws IOException, InterruptedException {
//		logRP.createRediffform(column1, column2, column3, column4);	
//		log.info("loginRediffTest initiated");
//	}
	
	
	
	@AfterTest
	public void tearDown() throws InterruptedException {
		log.info("loginRediffTest initiated completed");
		Thread.sleep(1000);
		driver.quit();
	}
}
