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



public class Rediff_createNewAccount extends base{
	Rediff_HomePage homepage;
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
	
	
	//Getter setter
	@FindBy (xpath="(//input[contains (@name,'name')])[1]")
	private WebElement TextBox_FullName;
	
	
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
	
	@FindBy(xpath="//input[@id='login1']")
	WebElement text_username;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement text_password;
	
	@FindBy(xpath="//input[@value='Sign in']")
	WebElement btn_signIn;
	
	@FindBy(xpath="//a[@class='rd_rediff']")
	WebElement link_rediffHomePage;
	
	
	@FindBy(xpath="//table[@id='tblcrtac']/tbody/tr[2]/td/font/b")
	WebElement msg_error;
	
	//create account details
	
	@FindBy(xpath="(//input[@type='password'])[1]")
	WebElement text_password1;
	
	@FindBy(xpath="(//input[@type='password'])[2]")
	WebElement text_password2;
	
	@FindBy(xpath="(//input[@type='text'])[3]")
	WebElement text_altEmailAdd;
	
	@FindBy(xpath="//input[@id='mobno']")
	WebElement text_mobileNo;
	
	
	
	
	
	public Rediff_createNewAccount() throws IOException {	
	PageFactory.initElements(driver, this);
	
	}
	
	
	public void createRediffForm(String fullName, String rediffID, String password, String retypePassword, 
			String alternateEmailAddress, String mobile,String country) throws InterruptedException {
		
		TestUtil.sendKeys(driver, TextBox_FullName, Constants.SHORT_WAIT, fullName);
		TestUtil.sendKeys(driver, Text_EmailID, Constants.SHORT_WAIT, rediffID);
		TestUtil.sendKeys(driver, text_password1, Constants.SHORT_WAIT, password);
		TestUtil.sendKeys(driver, text_password2, Constants.SHORT_WAIT, retypePassword);
		TestUtil.sendKeys(driver, text_altEmailAdd, Constants.SHORT_WAIT, alternateEmailAddress);
		try
		{
		TestUtil.sendKeys(driver, text_mobileNo, Constants.SHORT_WAIT, mobile);
			}
		catch(Exception e){
		System.out.println("Moble field not working:::::");	
		}
		Thread.sleep(2000);
		Btn_Radio_Option.click();
		TestUtil.selectDropDownbyVisibleText(DD_Country, country);
		
		TestUtil.clickOn(driver, Btn_CreateAccount, Constants.SHORT_WAIT);
		try
		{
		TestUtil.acceptAlertPopup();
		log.info("Create Rediffmail Account---->Pop up handeled");
		
		}
		catch(Exception e){
			
		}
		
		Thread.sleep(3000);
	}
	
	
	
}
