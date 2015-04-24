package com.Faida.automation.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Auriga.automation.common.Framework;
import com.Auriga.automation.common.Log;
import com.Faida.automation.factorydata.MainPage;
import com.Faida.automation.factorydata.MyHomePage;


public class MyListings 
{

	protected WebDriver driver;
	//private By activityFeedLink = By.xpath("//a[@href='/my-account#tab-activityFeed']");
	private By myListing = By.xpath("//a[@href='/my-account#tab-myListing']");
	private By myListingsTab = By.xpath("//a[text()='My Listings' and @breadcrumb='My Listing']");
	private By myListingsBelow = By.xpath("//a[text()='My Listings' and @breadcrumb='My Listings']");
	private By notAvailableItems = By.xpath("//a[text()='Not Available Items']");
	private By disableItems = By.xpath("//input[@id='disable_product']");
	//private By userName = By.xpath("//span[@class='profile-name-cont']");
	private By profileText = By.xpath("//div[@class='dropdown-toggle' and @style='color: inherit;']");
	private By userName = By.xpath("//span[@class='profile-name-cont']");
	private By disableBtn = By.xpath("//button[text()='Ok']");

	public MyListings(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	public Boolean doVerifyMyListings() 
	{    
		return Framework.verifySuccessMessage(driver,myListingsBelow,MyHomePage.MyListings.myListings);
	   
	}
	
	
	public void clickMyListings()
	{   
		Framework.HoverAndClickOnElement(driver, userName, myListing);
		
	}
	
	public void clickMyListingBelowTab()
	{
		driver.findElement(myListingsBelow).click();
		
	}
	
	public void clickOnNotAvailableItems()
	{
		driver.findElement(notAvailableItems).click();
	}
	

	public void clickOnDisableItems()
	{
		driver.findElement(disableItems).click();
	}
	
	public void clickOkDisableBtn()
	{
		driver.findElement(disableBtn).click();
	}
	
	

}
