package com.Faida.automation.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Auriga.automation.common.TestBaseSetUp;
import com.Faida.automation.pagefactory.LogOut;
import com.Faida.automation.pagefactory.UserSignIn;


public class SignInTest extends TestBaseSetUp
{
     private WebDriver driver;
  
     UserSignIn usersign;
     LogOut out;

@BeforeClass
public void setup() 
{
	driver = getDriver();
	
	usersign = new UserSignIn(driver);
	out = new LogOut(driver);
}

@Test(priority = 0, enabled = true)
public void clickPopUpTest() 
{
	usersign.clickPopUp();
}

@Test(priority = 1, enabled = true)
public void addSigninDetailsTest() 
{
	usersign.addLoginDetails();
}

@Test(priority = 2, enabled = true)
public void doVerifyUserSigninTest() 
{
	
	Assert.assertTrue(usersign.doVerifyUserNameAfterSignIn(),"user name text is not verified ");

}


@Test(priority = 3, enabled = false)
public void doLoginBlankAllFieldTest() 
{
	
	Assert.assertTrue(usersign.doLoginBlankAllField(),
			"Not Displayed error message after leave all fields blank in signin page");

	Assert.assertTrue(usersign.doLoginEmailBlank(),
			"Not Displayed error message after leave email field blank in signin page");
	
	Assert.assertTrue(usersign.doLoginPassBlank(),
			"Not Displayed error message after leave password field blank in signin page");



}

@Test(priority = 4, enabled = true)
public void Test()
{
	out.logoutButtonClick();
	
}

}
