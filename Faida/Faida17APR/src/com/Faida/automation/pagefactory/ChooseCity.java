package com.Faida.automation.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.Auriga.automation.common.Framework;
import com.Auriga.automation.common.Log;
import com.Faida.automation.factorydata.MainPage;
import com.Faida.automation.factorydata.MyHomePage;


public class ChooseCity 
{

	protected WebDriver driver;
	private By chooseCityBar = By.id("select2-selectLocation-container");
	
	
	public ChooseCity(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	public boolean clearField() 
	{
		
		driver.findElement(chooseCityBar).clear();
		
		return Framework.verifySuccessMessage(driver,chooseCityBar,MyHomePage.AfterRegister.cityErrorText);
	}
	
	
	public void doAddCity()
	{
		driver.findElement(chooseCityBar).sendKeys(MainPage.Main.chooseYourCityText);
		new Select(driver.findElement(chooseCityBar))
		.selectByValue(MyHomePage.AfterRegister.chooseYourCityText);
	}
	
	
}
