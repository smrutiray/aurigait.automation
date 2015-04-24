package com.Faida.automation.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.Auriga.automation.common.Framework;

public class LogOut 
{
	protected WebDriver driver;
	private By logoutButton = By.xpath("//a[@href='/logout']");
	private By myConnecText = By.xpath("//div[@class='dropdown-toggle' and @style='color: inherit;']");
	private By userName = By.xpath("//span[@class='profile-name-cont']");
	
	public LogOut(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	
	/*public void clickMyConnections()
	{   
		Framework.HoverAndClickOnElement(driver, myConnecText, logoutButton);
	}*/
		
	
	 public void logoutButtonClick()
	    {
		   Framework.HoverAndClickOnElement(driver, userName, logoutButton);
		 }
}
