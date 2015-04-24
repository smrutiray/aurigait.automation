package com.Faida.automation.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.Auriga.automation.common.Framework;
import com.Auriga.automation.common.Log;
import com.Faida.automation.factorydata.MainPage;
import com.Faida.automation.factorydata.MyHomePage;


public class ActivityFeed 
{

	protected WebDriver driver;
	private By activityFeedLink = By.xpath("//a[@href='/my-account#tab-activityFeed']");
	private By activityFeedTab = By.xpath("//a[@href='#activityFeed']");
	private By iWantToGetLink = By.id("listings-search");
	private By btnIWantToGetLink = By.xpath("//svg[@class='icon-search']");
	//private By searchBarIWantToGet = By.
	private By iWantToExchange = By.id("product-name");
	
	private By btniWantToExchange = By.xpath("//div[@class='glyphicon glyphicon-plus']");
	private By user  = By.className("user");
	private By title = By.xpath("//input[@class='form-control' and @value='mobile']");
	private By titleText = By.xpath("//input[@placeholder='Short description of your item']");
	private By titleError = By.xpath("//small[text()='Please enter title']");
	private By category = By.name("listing[categories][0]");
	private By subCategory = By.name("listing[categories][1]");
	private By subCategory1 = By.name("listing[categories][2]");
	private By description = By.xpath("//textarea[@placeholder='Everything about your item. (It will help you getting better offers.)']");
	private By descriptionError = By.xpath("//small[@class='validate-msg']");
	private By city = By.id("listing-city");
	private By userName = By.xpath("//span[@class='profile-name-cont']");
	private By locality = By.id("listing-locality");
	private By contact = By.xpath("//input[@value='5454678790']");
	private By enterItemName = By.id("desire-product-0");
	private By selectCategory = By.name("desire[0][categories][0]");
	private By selectSubCategory = By.name("desire[0][categories][1]");
	private By addButton = By.id("add-user-item");
	//private By activityText = By.xpath("//div[@style='color: inherit;']");
	private By cityError = By.xpath("//div[@class='tt-dataset-citiesRepo']/small[text()='Please select city']");
	
	
	public ActivityFeed(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	public void clickActivityFeed()
	{   
		Framework.HoverAndClickOnElement(driver, userName, activityFeedLink);
	}
	
	public Boolean doVerifyActivityFeed() 
	{   
		
		return Framework.verifySuccessMessage(driver, activityFeedTab, MyHomePage.ActivityFeed.activityFeedText);
		
	}
	
	public void iWant()
	{
		Framework.Type(driver, iWantToGetLink, MainPage.Main.wayToYourFavouriteItems);
	}
	
	public void iExchange()
	{
		
		Framework.Type(driver, iWantToExchange, MainPage.Main.addListing);
		Framework.Click(driver, btniWantToExchange);
		
	}
	
	public void enterDetails()
	{
		driver.findElement(title).clear();
		driver.findElement(titleText).sendKeys(MyHomePage.ActivityFeed.iWant);
		new Select(driver.findElement(category))
		.selectByVisibleText(MyHomePage.ActivityFeed.iWant);
		new Select(driver.findElement(subCategory))
		.selectByVisibleText(MyHomePage.ActivityFeed.iWantItem);
		new Select(driver.findElement(subCategory1))
		.selectByVisibleText(MyHomePage.ActivityFeed.enterMobileName);
		driver.findElement(description).sendKeys(MyHomePage.ActivityFeed.title);
		driver.findElement(city).sendKeys(MyHomePage.ActivityFeed.city);
		//new Select(driver.findElement(locality))
		//.selectByVisibleText(MyHomePage.ActivityFeed.locality);
		driver.findElement(locality).sendKeys(MyHomePage.ActivityFeed.locality);
		driver.findElement(contact).sendKeys(MainPage.Register.phoneNumber);
		driver.findElement(enterItemName).sendKeys(MyHomePage.ActivityFeed.enterItemName);
		driver.findElement(addButton).click();
		
	}
	
	 public boolean doActivityFeedFormBlankTitleField()
	   {
		   driver.findElement(title).clear();
		   new Select(driver.findElement(category))
			.selectByVisibleText(MyHomePage.ActivityFeed.iWant);
		   driver.findElement(description).sendKeys(MyHomePage.ActivityFeed.title);
		   driver.findElement(city).sendKeys(MyHomePage.ActivityFeed.city);
		   driver.findElement(contact).sendKeys(MainPage.Register.phoneNumber);
		   driver.findElement(addButton).click();
		   
		   return Framework.verifySuccessMessage(driver, titleError,MyHomePage.ActivityFeed.titleErrorText);
		  
		  
	   }
	
	public boolean doActivityFeedFormBlankDescriptionField()
	   {
		    driver.findElement(title).clear();
		    driver.findElement(titleText).sendKeys(MyHomePage.ActivityFeed.iWant);
		    new Select(driver.findElement(category))
			.selectByVisibleText(MyHomePage.ActivityFeed.iWant);
		    driver.findElement(description).clear();
		   driver.findElement(city).sendKeys(MyHomePage.ActivityFeed.city);
		   driver.findElement(contact).sendKeys(MainPage.Register.phoneNumber);
		   driver.findElement(addButton).click();
		   
		   return Framework.verifySuccessMessage(driver,descriptionError,MyHomePage.ActivityFeed.descriptionErrorText);
		 
		  
	   }
	 
	 public boolean doActivityFeedFormBlankCityField()
	   {
		  
		    driver.findElement(title).clear();
		    driver.findElement(titleText).sendKeys(MyHomePage.ActivityFeed.iWant);
		    new Select(driver.findElement(category))
			.selectByVisibleText(MyHomePage.ActivityFeed.iWant);
		    driver.findElement(description).sendKeys(MyHomePage.ActivityFeed.title);
		    driver.findElement(city).clear();
		    driver.findElement(contact).sendKeys(MainPage.Register.phoneNumber);
		    
		    return Framework.verifySuccessMessage(driver,cityError,MyHomePage.ActivityFeed.cityErrorText);
	   }
	
}
