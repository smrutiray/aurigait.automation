package com.Faida.automation.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Auriga.automation.common.Framework;
import com.Auriga.automation.common.Log;
import com.Faida.automation.factorydata.MainPage;
import com.Faida.automation.factorydata.MyHomePage;



public class MyConnections 
{
	protected WebDriver driver;
	private By myConnec = By.xpath("//a[@href='/my-account#tab-myConnections']");
	private By followRequest = By.xpath(
			"//li[@class='myconnection-tabs']/a[@aria-controls='follow-request']");
	private By myConnecAbove = By.xpath("//strong[text()='My Connections']");
	private By friends1 = By.xpath("//li[@class='active myconnection-tabs']/a[@aria-controls='friends']");
	private By acqua = By.xpath("//li[@class='myconnection-tabs']/a[@href='#myConnections-acquaintances']");
	//private By userName = By.xpath("//span[@class='profile-name-cont']");
    //private By myListingsText = By.xpath("//div[@class='dropdown-toggle' and @style='color: inherit;']");
    private By exchangeReq = By.xpath("//div[@class='dropdown-toggle' and @style='color: inherit;']");
    private By userName = By.xpath("//span[@class='profile-name-cont']");
    
	public MyConnections(WebDriver driver) 
	{
		this.driver = driver;
	}

	
	public Boolean doVerifyMyConnection() 
	{  
		return Framework.verifySuccessMessage(driver,myConnecAbove,MyHomePage.MyConnections.myConnection);
		
	}
	
	public void clickMyConnections()
	{   
		Framework.HoverAndClickOnElement(driver, userName, myConnec);
	}
	
	
	public void clickOnFollowRequestTab()
	{
		driver.findElement(followRequest).click();
		
	}
	
	public void clickOnFriendsTab()
	{
		driver.findElement(friends1).click();
		
	}
	
	public void clickOnAquaTab()
	{
		driver.findElement(acqua).click();
		
	}
	
	
	
}


