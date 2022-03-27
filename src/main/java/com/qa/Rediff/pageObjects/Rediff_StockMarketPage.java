package com.qa.Rediff.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Rediff.Constants.Constants;
import com.qa.Rediff.base.base;

import utilities.TestUtil;

public class Rediff_StockMarketPage extends base{
	public static Logger log =LogManager.getLogger(base.class.getName());
	
	public Rediff_StockMarketPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//input[@id='srchword']")
	WebElement text_getQuote;
	
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement btn_getQuote;
	
	public void getSharePriceDetails(String sharename) throws InterruptedException {
		TestUtil.sendKeys(driver, text_getQuote, Constants.SHORT_WAIT, sharename);
		TestUtil.clickOn(driver, btn_getQuote, Constants.SHORT_WAIT);
		Thread.sleep(2000);
		TestUtil.scrollDownUsingActions(driver);
		Thread.sleep(1000);
		TestUtil.scrollUpUsingActions(driver);
		Thread.sleep(1000);
	}

}
