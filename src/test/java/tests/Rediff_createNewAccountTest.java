package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import com.qa.Rediff.base.base;
import com.qa.Rediff.pageObjects.Rediff_HomePage;
import com.qa.Rediff.pageObjects.Rediff_LoginPage;
import com.qa.Rediff.pageObjects.Rediff_createNewAccount;
import com.Rediff.Constants.Constants;
import utilities.TestUtil;

public class Rediff_createNewAccountTest extends base {
	TestUtil ex;
	Rediff_HomePage homepage;
	Rediff_LoginPage loginpage;
	Rediff_createNewAccount createnewaccount;
	String sheetName="createAccount";
	public static Logger log =LogManager.getLogger(base.class.getName());
	
	
	
	public Rediff_createNewAccountTest() throws IOException {
		super();
		
	}

	
	@BeforeTest
	public void setUp() throws IOException{
		initializeDriver();
		ex = new TestUtil();
		loginpage=new Rediff_LoginPage();
		homepage=new Rediff_HomePage();
		createnewaccount=new Rediff_createNewAccount();
		
		
	}
	
	
	@Test(priority=1)
	public void rediffmethod1() throws IOException, InterruptedException {
		homepage.loginPageWindow();
		loginpage.validateRediffLogin(prop.getProperty("username"), prop.getProperty("password"));
		log.info("loginRediffTest initiated");
		
	}
	@DataProvider
	public Object[][] getRediffData() throws IOException, InvalidFormatException{
		Object data[][]=TestUtil.getExcelData(sheetName, Constants.FORM_CREATE_TEST_DATA_SHEET_PATH);
		
		
		return data;
		}
	
	@Test(dataProvider="getRediffData", priority=2)
	public void rediffmethod2(String fullName, String rediffID, String password, String retypePassword, 
			String alternateEmailAddress, String mobile, String country) throws IOException, InterruptedException {
		
		createnewaccount=homepage.createnNewAccountWindow();
		createnewaccount.createRediffForm(fullName, rediffID, password, retypePassword, alternateEmailAddress, 
				 mobile, country);	
		log.info("loginRediffTest initiated");
	}
	
	
	
	@AfterTest
	public void tearDown() throws InterruptedException {
		log.info("loginRediffTest initiated completed");
		Thread.sleep(1000);
		driver.quit();
	}
}
