package tests;

import org.testng.annotations.Test;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import com.Rediff.Constants.Constants;
import com.qa.Rediff.base.base;
import com.qa.Rediff.pageObjects.Rediff_HomePage;
import com.qa.Rediff.pageObjects.Rediff_LoginPage;
import com.qa.Rediff.pageObjects.Rediff_ShoppingPage;

import utilities.TestUtil;

public class Rediff_ShoppingTest extends base {
	Rediff_HomePage homepage;
	Rediff_ShoppingPage shoppingpage;
	TestUtil ex;
	Rediff_LoginPage loginpage;
	String sheetName="shopping";
	public static Logger log =LogManager.getLogger(base.class.getName());
	
	
	public Rediff_ShoppingTest() throws IOException {
		super();
		
	}


	@BeforeTest
	public void setUp() throws IOException{
		
	    initializeDriver();
		ex = new TestUtil();
		loginpage=new Rediff_LoginPage();
		homepage=new Rediff_HomePage();
		shoppingpage = new Rediff_ShoppingPage();
		log.info("Before Test");
		
	}
	
	@Test(priority=1)
	public void Rediff_loginPageValidation() throws IOException, InterruptedException {
		homepage.loginPageWindow();
		homepage=loginpage.validateRediffLogin(prop.getProperty("username"), prop.getProperty("password"));
		log.info("loginRediff_Method");
	}
	
	@DataProvider
	public Object[][] getRediffData() throws IOException, InvalidFormatException{
		Object data[][]=TestUtil.getExcelData(sheetName, Constants.FORM_CREATE_TEST_DATA_SHEET_PATH);
		return data;
		}
	
	
	
	@Test(priority=2)
	public void rediffShoppingPage_validations() throws IOException, InterruptedException {
		shoppingpage=homepage.shoppingPageWindow();
		Assert.assertEquals(shoppingpage.validation1(), "Over 22,00,000+ Products");
		Assert.assertEquals(shoppingpage.validation2(), "Men's Lifestyle");
		Assert.assertEquals(shoppingpage.validation3(), "Women's Lifestyle");
		Assert.assertEquals(shoppingpage.validation4(), "Mobiles");
		 log.info("Successfully validated shoppingValidation!!!");
		
	}
	
	
	@Test(dataProvider="getRediffData", priority=3)
	public void rediffShoppingPage_Method(String Product) throws IOException, InterruptedException {
		shoppingpage.signInShopping_Rediff(Product);
		log.info("rediffShopping_Method");
	}
	
	
	@AfterTest
	public void tearDown() throws InterruptedException {
		log.info("tear Down: rediffShopping_Method");
		driver.quit();
	}

}
