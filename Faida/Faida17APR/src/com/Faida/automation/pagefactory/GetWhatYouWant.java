package com.Faida.automation.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Auriga.automation.common.Framework;
import com.Faida.automation.factorydata.MainPage;
import com.Faida.automation.factorydata.MyHomePage;

public class GetWhatYouWant 
{
	protected WebDriver driver;
	private By get = By.xpath("//div[text()='GET what you WANT!']");
	private By wayToItems = By.xpath("//input[@id='listings-search']");
	
	

	public GetWhatYouWant(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	public Boolean doVerifyGetWhatYouWantPage() 
	{
		return Framework.verifySuccessMessage(driver,get,MainPage.Main.getWhatYouWantText);
		 
	}  
	
	public void doAddItems()
	{
		driver.findElement(wayToItems).sendKeys(MainPage.Main.wayToYourFavouriteItems );
		driver.findElement(wayToItems).click();
		
	}
	
	
}
