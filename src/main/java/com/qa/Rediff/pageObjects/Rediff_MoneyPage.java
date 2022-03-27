package com.qa.Rediff.pageObjects;

import java.io.IOException;
import com.Rediff.Constants.*;
import com.qa.Rediff.base.base;
import utilities.TestUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Rediff_MoneyPage extends base{
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
	
	
	
	public Rediff_MoneyPage() throws IOException {	
	PageFactory.initElements(driver, this);
	
	}

	
	
	public void loginrediff() {
		
	}
	public void signInShopping_Rediff(String UserId, String Password) throws InterruptedException{
		TestUtil.clickOn(driver, link_Shopping, Constants.SHORT_WAIT);
		TestUtil.clickOn(driver, link_SignIn, Constants.SHORT_WAIT);
		TestUtil.sendKeys(driver, Text_Login_EmailID, Constants.SHORT_WAIT, UserId);
		Thread.sleep(1000);
		TestUtil.sendKeys(driver, Text_Login_Password, Constants.SHORT_WAIT, Password);
		Thread.sleep(1000);
		TestUtil.clickOn(driver, Btn_Login, Constants.SHORT_WAIT);
		Thread.sleep(1000);
		
	}
	
	public void createRediffform(String column1, String column2, String column3, String column4) throws InterruptedException {
		
		TestUtil.clickOn(driver, Link_Rediffmail, Constants.SHORT_WAIT);
		TestUtil.clickOn(driver, link_CreateNewAccount, Constants.SHORT_WAIT);
		TestUtil.sendKeys(driver, TextBox_FullName, Constants.SHORT_WAIT, column1);
		TestUtil.sendKeys(driver, Text_EmailID, Constants.SHORT_WAIT, column2);
		Thread.sleep(2000);
		Btn_Radio_Option.click();
		
		try
		{
		    
			TestUtil.selectDropDownbyVisibleText(DD_Country, column4);
		    
		}
		catch(Exception e) {
			log.error("Drop down country");
			
		}
		
		TestUtil.clickOn(driver, Btn_CreateAccount, Constants.SHORT_WAIT);
		try
		{
		TestUtil.acceptAlertPopup();
		log.info("Create Rediffmail Account---->Pop up handeled");
		
		}
		catch(Exception e){
			
		}
		
		TestUtil.navigateBack();
		System.out.println(TestUtil.getWindowTitle(driver));
		TestUtil.navigateForward();
		System.out.println(TestUtil.getWindowTitle(driver));
		
		
	}
	
	
	
}
