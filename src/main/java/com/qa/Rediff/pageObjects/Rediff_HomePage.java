package com.qa.Rediff.pageObjects;

import java.io.IOException;
import java.util.Set;

import com.Rediff.Constants.*;
import com.qa.Rediff.base.base;
import utilities.TestUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Rediff_HomePage extends base{
	public static Logger log =LogManager.getLogger(base.class.getName());
	
	
	@FindBy(xpath="//a[@title='Lightning fast free email']")
	WebElement Link_Rediffmail;
	
	@FindBy(xpath="(//a[text()='Shopping'])[1]")
	WebElement link_Shopping;
	
	@FindBy(xpath="//a[text()='Sign In']")
	WebElement link_SignIn;
	
	@FindBy(xpath="//input[@name='logid']")
	WebElement Text_Login_EmailID;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement Btn_Login;
	
	@FindBy(xpath="//b[text()=' The username and/or password you entered is incorrect.']")
	WebElement LogIn_ErrorMessage;
	
	@FindBy(xpath="//input[@name='pswd']")
	WebElement Text_Login_Password;
	
	@FindBy(xpath="//a[@title='Create new Rediffmail account']")
	WebElement link_CreateNewAccount;
	
	@FindBy(xpath="//a[contains(text(),'Create a Rediffmail account')]")
	WebElement link_CreateAccount;
	
	@FindBy (xpath="(//input[contains (@name,'name')])[1]")
	WebElement TextBox_FullName;
	
	@FindBy(xpath="//input[@type='radio']")
	WebElement Btn_Radio;
	
	@FindBy(xpath="//input[@value='f']")
	WebElement Btn_Radio_Option;
	
	@FindBy(xpath="//input[contains (@name, 'login')]")
	WebElement Text_EmailID;
	
	@FindBy(xpath="//input[@id='Register']")
	WebElement Btn_CreateAccount;
	
	@FindBy(xpath="//select[@id='country']")
	WebElement DD_Country;
	
	//login page details
	@FindBy(xpath="//a[@title='Lightning fast free email']")
	WebElement loginWindowLink;
	
	@FindBy(xpath="//a[@title='Sign out']")
	WebElement loginSignOut;
	
	//Money page details
	
	@FindBy(xpath="//a[@href='https://money.rediff.com']")
	WebElement moneyWindowLink;
	
	//shopping page details
	@FindBy(xpath="(//a[text()='Shopping'])[1]")
	WebElement shoppingWindowLink;
	
	
	//stock market frame
	@FindBy(xpath="//input[@id='query']")
	WebElement text_getQuoteSearchBox;
	
	@FindBy(xpath="//input[@class='getqbtn']")
	WebElement icon_getQuoteSearchBox;
	
	@FindBy(xpath="//input[@id='srchword']")
	WebElement text_getQuote;
	
	
	
	
	
	public Rediff_HomePage() throws IOException {	
	PageFactory.initElements(driver, this);
	
	}
	
	
	public Rediff_LoginPage loginPageWindow() throws IOException {
		TestUtil.clickOn(driver, loginWindowLink, Constants.SHORT_WAIT);
		return new Rediff_LoginPage();
	}
	
	public Rediff_createNewAccount createnNewAccountWindow() throws IOException {
		TestUtil.clickOn(driver, loginSignOut, Constants.SHORT_WAIT);
		TestUtil.clickOn(driver, link_CreateAccount, Constants.SHORT_WAIT);
		return new Rediff_createNewAccount();
	}
	
	
	
	public Rediff_MoneyPage moneyPageWindow() throws IOException {
		TestUtil.clickOn(driver, moneyWindowLink, Constants.SHORT_WAIT);
		return new Rediff_MoneyPage();
	}
	
	public Rediff_ShoppingPage shoppingPageWindow() throws IOException{
		TestUtil.clickOn(driver, shoppingWindowLink, Constants.SHORT_WAIT);
		return new Rediff_ShoppingPage();
		
	}
	
	public Rediff_StockMarketPage stockMarketWindow() throws IOException, InterruptedException {
		
		// Switch Frame
		String parentWindow =driver.getWindowHandle();
		
	    driver.switchTo().frame(driver.findElement(By.id("moneyiframe")));
	    Thread.sleep(500);
		TestUtil.sendKeys(driver, text_getQuoteSearchBox, Constants.LONG_WAIT, "Price");
		TestUtil.clickOn(driver, icon_getQuoteSearchBox, Constants.LONG_WAIT);
		Thread.sleep(500);
		driver.switchTo().defaultContent();
		TestUtil.switchWindow(driver, parentWindow, "");
		Thread.sleep(500);
		
		return new Rediff_StockMarketPage();
		
	}
	
	
	
	
}
