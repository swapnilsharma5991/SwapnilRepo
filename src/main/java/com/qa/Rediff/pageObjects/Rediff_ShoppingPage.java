package com.qa.Rediff.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Rediff.Constants.Constants;
import com.qa.Rediff.base.base;

import utilities.TestUtil;

public class Rediff_ShoppingPage extends base{
	public static Logger log =LogManager.getLogger(base.class.getName());
	
	public Rediff_ShoppingPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@id='srchword']")
	WebElement text_searchBox;
	
	@FindBy(xpath="//input[@class='newsrchbtn']")
	WebElement btn_search;
	
	
	@FindBy(xpath="//span[@id='topcat1']")
	WebElement link_MensLifestyle;
	
	@FindBy(xpath="//span[@id='topcat2']")
	WebElement link_WomensLifestyle;
	
	@FindBy(xpath="//span[@id='topcat3']")
	WebElement link_Mobile;
	
	@FindBy(xpath="//span[@id='topcat4']")
	WebElement link_Electronics;
	
	@FindBy(xpath="//span[@id='topcat5']")
	WebElement link_Watches;
	
	@FindBy(xpath="//span[@id='topcat6']")
	WebElement link_HomeDecor;
	
	@FindBy(xpath="//span[@id='topcat7']")
	WebElement link_PersonalCare;
	
	@FindBy(xpath="//a[@title='Customer Delight Center']")
	WebElement link_CDC;
	
	@FindBy(xpath="//a[contains (text(), 'Frequently asked questions')]")
	WebElement link_FrequentlyAskedQuestions;
	
	@FindBy(xpath="(//div[@class='div_myitemname'])[1]")
	WebElement link_shoppingItem;
	
	//validations
	
	@FindBy(xpath="//p[contains(text(),'Over 22,00,000+ Products')]")
	WebElement link_over2200000products;
	
	
	public String validation1() {
		return link_over2200000products.getText();
	}
	
	public String validation2() {
		return link_MensLifestyle.getText();
	}
	
	public String validation3() {
		return link_WomensLifestyle.getText();
	}
	
	public String validation4() {
		return link_Mobile.getText();
	}
	
	
	public void signInShopping_Rediff(String Product) throws InterruptedException{
		TestUtil.clickOn(driver, text_searchBox, Constants.SHORT_WAIT);
		TestUtil.sendKeys(driver, text_searchBox, Constants.SHORT_WAIT, Product);
		Thread.sleep(1000);
		TestUtil.clickOn(driver, btn_search, Constants.LONG_WAIT);
		TestUtil.moveToElement(driver, link_MensLifestyle);
		Thread.sleep(500);
		TestUtil.moveToElement(driver, link_WomensLifestyle);
		Thread.sleep(500);
		TestUtil.moveToElement(driver, link_Mobile);
		Thread.sleep(500);
		TestUtil.moveToElement(driver, link_Electronics);
		Thread.sleep(500);
		TestUtil.moveToElement(driver, link_Watches);
		Thread.sleep(500);
		TestUtil.moveToElement(driver, link_HomeDecor);
		Thread.sleep(500);
		TestUtil.moveToElement(driver, link_PersonalCare);
		System.out.println("Scroll down-up starts");
		Thread.sleep(500);
		TestUtil.scrollDownUsingActions(driver);
		Thread.sleep(1000);
		TestUtil.scrollUpUsingActions(driver);
		Thread.sleep(1000);
		System.out.println("Scroll down-up ends");
		TestUtil.clickOn(driver, link_shoppingItem, Constants.SHORT_WAIT);
		Thread.sleep(1000);
		TestUtil.navigateBack();
		Thread.sleep(1000);
		TestUtil.clickOn(driver, link_CDC, Constants.MEDIUM_WAIT);
		System.out.println("Before Switch");
		System.out.println(driver.getTitle());
		String parentWindow =driver.getWindowHandle();
		TestUtil.switchWindow(driver, parentWindow, "");
		System.out.println("After Switch");
		System.out.println(driver.getTitle());
		Thread.sleep(500);
		TestUtil.clickOn(driver, link_FrequentlyAskedQuestions, Constants.MEDIUM_WAIT);
		TestUtil.navigateBack();
		Thread.sleep(1000);
		
	}
}
