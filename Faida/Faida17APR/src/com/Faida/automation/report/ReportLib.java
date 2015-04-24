package com.Faida.automation.report;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class ReportLib 
{
    protected WebDriver driver;
	
	public ReportLib(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	public void getScreenShot(String FileName)
	{
		try
		{
	         EventFiringWebDriver edriver = new EventFiringWebDriver(driver);
	         File src = edriver.getScreenshotAs(OutputType.FILE);
	         File dest = new File("/home/smruti/t/automation/faida/ScreenShot/" + FileName + ".png");
	         FileUtils.copyFile(src, dest);
        }
       catch(Exception e)
        {
    	     //if fails to take screenshot then this block will execute
    	     e.getStackTrace();
        }
	
	
    }
}
