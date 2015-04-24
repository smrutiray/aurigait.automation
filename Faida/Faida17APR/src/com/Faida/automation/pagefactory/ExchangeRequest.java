package com.Faida.automation.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Auriga.automation.common.Framework;
import com.Faida.automation.factorydata.MyHomePage;


public class ExchangeRequest 
{
	protected WebDriver driver;
	private By exchangeReq = By.xpath("//a[@href='/my-account#tab-myRequest']");
	private By requestReceived = By.xpath("//a[text()='Requests Received']");
	private By requestsMade = By.xpath("//a[text()='Requests Made']");
	private By exchanged = By.xpath("//a[text()='Exchanged']");
	private By trashed = By.xpath("//a[text()='Trashed']");
	//private By userName = By.xpath("//span[@class='profile-name-cont']");
	private By myListingsText = By.xpath("//div[@class='dropdown-toggle' and @style='color: inherit;']");
	private By userName = By.xpath("//span[@class='profile-name-cont']");
	private By myRequest = By.xpath("//strong[@class='c-tab']");

	public ExchangeRequest(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	public Boolean doVerifyExchangeRequest() 
	{    
		return Framework.verifySuccessMessage(driver, myRequest, MyHomePage.ExchangeRequests.exchangeRequests);
		
		}
	public void clickExchangeRequest()
	{   
		Framework.HoverAndClickOnElement(driver, userName, exchangeReq);
		
	}
	
	public void clickOnRequestReceivedTab()
	{
		driver.findElement(requestReceived).click();
		
	}
	
	public void clickRequestMadeTab()
	{
		driver.findElement(requestsMade).click();
		
	}
	
	public void clickExchangedTab()
	{
		driver.findElement(exchanged).click();
		
	}
	
	public void clickTrashedTab()
	{
		driver.findElement(trashed).click();
		
	}

	
}
