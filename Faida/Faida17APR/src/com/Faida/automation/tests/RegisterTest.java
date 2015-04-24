package com.Faida.automation.tests;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Auriga.automation.common.Framework;
import com.Auriga.automation.common.TestBaseSetUp;
import com.Faida.automation.pagefactory.LogOut;
import com.Faida.automation.pagefactory.UserRegister;
import com.Faida.automation.report.ReportLib;


public class RegisterTest extends TestBaseSetUp
{
	
	private WebDriver driver;
	UserRegister userregis;
	LogOut out;
	String imageUrl ="/home/smruti/t/automation/faida/ScreenShot/";
	
	//ReportLib rlib;
	

	@BeforeClass
	public void setup() 
	{
		driver = getDriver();
		userregis = new UserRegister(driver);
		out = new LogOut(driver);
		//rlib = new ReportLib(driver);
		
	}
	
	
	@Test(priority = 0, enabled = true)
	public void clickPopUpTest() 
	{
		userregis.clickPopUp();
		try
		{
			throw new FileNotFoundException();
		}
	
			catch(FileNotFoundException e)
		{
		   //rlib.getScreenShot("popup");
				
				Framework.getScreenShot(driver,imageUrl,"popup");
	    }
	
		
	}
	
	
	
	/*@Test(priority = 1, enabled = true)
	public void addRegisterDetailsTest() 
	{
		userregis.addRegisterDetails();
	}*/
	
	@Test(priority = 1, enabled = true)
	public void doRegisterBlankAllFieldTest() 
	{
		userregis.clickRegister();
		userregis.clearAll();
		userregis.doRegisterBlankAllField();
		Framework.getScreenShot(driver,imageUrl,"blank register page");
		userregis.closeRegiPoppup();
		try
		{
			throw new FileNotFoundException();
		}
	
			catch(FileNotFoundException e)
		{
		    //rlib.getScreenShot("register blank");
			Framework.getScreenShot(driver, imageUrl,"Register");
	    }
	}
	

	/*@Test(priority =2, enabled = true)
	public void doRegisterBlankNameFieldTest() 
	{	
		userregis.clickRegister();
	    userregis.clearAll();
        userregis.doRegisterBlankNameField();
        Framework.getScreenShot(driver,imageUrl,"register name field blank");
		userregis.closeRegiPoppup();
		try
		{
			throw new FileNotFoundException();
		}
	
			catch(FileNotFoundException e)
		{
		    rlib.getScreenShot("register name blank");
	    }
	}*/

	@Test(priority = 3, enabled = true)
	public void doAddRegisterTest() 
	{
		userregis.clickRegister();
		//userregis.clearAll();
		userregis.addRegisterDetails();
		Framework.getScreenShot(driver, imageUrl,"Register");
		userregis.closeRegiPoppup();
		/*try
		{
			throw new FileNotFoundException();
		}
	
			catch(FileNotFoundException e)
		{
		    Framework.getScreenShot("add register details");
	    }*/
	}
	
	@Test(priority = 4, enabled = true)
	public void doVerifyRegisterTest() 
	{
	    Framework.getScreenShot(driver,imageUrl,"verify register page");
		Assert.assertTrue(userregis.doVerifyDetails(),"Register text is not matched ");
	}
	
	@Test(priority = 5, enabled = true)
	public void Test()
	{
	    Framework.getScreenShot(driver,imageUrl,"logout page");
		out.logoutButtonClick();
		
	}
	
}
