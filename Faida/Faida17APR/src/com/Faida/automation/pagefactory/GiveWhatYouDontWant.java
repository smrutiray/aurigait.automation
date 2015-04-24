package com.Faida.automation.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Auriga.automation.common.Framework;
import com.Faida.automation.factorydata.MainPage;

public class GiveWhatYouDontWant 
{
	protected WebDriver driver;
	private By addListingBox = By.id("product-name");
	
	public GiveWhatYouDontWant(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	public Boolean doVerifyGiveDontWant() 
	{
		
		if (driver.getTitle().matches(MainPage.Main.giveWhatYouDontWant))
			return true;
		else
			return false;
	}
	
	public void doAddItems1()
	{
		driver.findElement(addListingBox).sendKeys(MainPage.Main.addListing);
		driver.findElement(addListingBox).click();
	}
}
