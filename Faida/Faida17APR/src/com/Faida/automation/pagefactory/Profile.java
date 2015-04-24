package com.Faida.automation.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Auriga.automation.common.Framework;
import com.Faida.automation.factorydata.FirstSignIn;
import com.Faida.automation.factorydata.MyHomePage;



public class Profile
{
	protected WebDriver driver;
	private By profileLink = By.xpath("//a[@href='/my-account#tab-myProfile']");
	private By profileTab = By.xpath("//strong[text()='My Profile']");
	private By iWant = By.id("listings-search");
	private By iExchange = By.id("product-name");
	private By emailID = By.xpath("//span[@class='user-email']");
	//private By userName = By.xpath("//span[@class='profile-name-cont']");
	private By activityText = By.xpath("//div[@style='color: inherit;']");
	private By activityFeed = By.xpath("//div[@class='dropdown-toggle' and @style='color: inherit;']");
	private By userName = By.xpath("//span[@class='profile-name-cont']");
	
	public Profile(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	
	public void clickProfile()
	{   
		Framework.HoverAndClickOnElement(driver, userName, profileLink);
		//new Actions(driver).moveToElement((WebElement) activityText).click().perform();
		//driver.findElement(profileLink).click();
	}
	
	
	public boolean doVerifyProfile() 
	{    
		
		return Framework.verifySuccessMessage(driver, profileTab, MyHomePage.Profile.profileText);
	}
	
	
	
	/*public void iWant()
	{
		driver.findElement(iWant).sendKeys(MainPage.Main.wayToYourFavouriteItems);
	}
	
	public void iExchange()
	{
		driver.findElement(iExchange).sendKeys(MainPage.Main.addListing);
		driver.findElement(iExchange).click();
	}*/
	
	public Boolean doVerifyEmail() 
	{
		 return Framework.verifySuccessMessage(driver, emailID, FirstSignIn.Signin.emailid);
		 
		
		
	}
	
}
