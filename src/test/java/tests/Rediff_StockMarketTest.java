package tests;

import org.testng.annotations.Test;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import com.Rediff.Constants.Constants;
import com.qa.Rediff.base.base;
import com.qa.Rediff.pageObjects.Rediff_HomePage;
import com.qa.Rediff.pageObjects.Rediff_LoginPage;
import com.qa.Rediff.pageObjects.Rediff_ShoppingPage;
import com.qa.Rediff.pageObjects.Rediff_StockMarketPage;

import utilities.TestUtil;

public class Rediff_StockMarketTest extends base {
	Rediff_HomePage homepage;
	Rediff_StockMarketPage stockmarket;
	TestUtil ex;
	Rediff_LoginPage loginpage;
	String sheetName="stockmarket";
	public static Logger log =LogManager.getLogger(base.class.getName());
	
	
	public Rediff_StockMarketTest() throws IOException {
		super();
		
	}


	@BeforeTest
	public void setUp() throws IOException{
		
		initializeDriver();
		ex = new TestUtil();
		loginpage=new Rediff_LoginPage();
		homepage=new Rediff_HomePage();
		stockmarket = new Rediff_StockMarketPage();
		log.info("Before Test");
		
	}
	
	@Test(priority=1)
	public void loginRediff_Method() throws IOException, InterruptedException {
		homepage.loginPageWindow();
		homepage=loginpage.validateRediffLogin(prop.getProperty("username"), prop.getProperty("password"));
		log.info("loginRediff_Method");
	}
	
	@DataProvider
	public Object[][] getRediffData() throws IOException, InvalidFormatException{
		Object data[][]=TestUtil.getExcelData(sheetName, Constants.FORM_CREATE_TEST_DATA_SHEET_PATH);
		return data;
		}
	
	
	
	@Test(dataProvider="getRediffData", priority=2)
	public void stockMarket_method(String sharename) throws IOException, InterruptedException {
		stockmarket=homepage.stockMarketWindow();
		stockmarket.getSharePriceDetails(sharename);
		log.info("stockMarket_method");
	}
	
	
	
	@AfterTest
	public void tearDown() throws InterruptedException {
		log.info("tear Down: stockMarket_method");
		driver.quit();
	}

}
