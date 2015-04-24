package com.Faida.automation.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.Auriga.automation.common.TestBaseSetUp;
import com.Faida.automation.pagefactory.ActivityFeed;
import com.Faida.automation.pagefactory.LogOut;
import com.Faida.automation.pagefactory.UserSignIn;



public class ActivityTest extends TestBaseSetUp
{
	private WebDriver driver;
	
	UserSignIn usersign;
	ActivityFeed actfeed;
	LogOut out;
	
	@BeforeClass
	public void setup() 
	{
		driver = getDriver();
	    usersign = new UserSignIn(driver);
		actfeed = new ActivityFeed(driver);
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
	public void activityFeedTest() throws InterruptedException
	{
		actfeed.clickActivityFeed();
	}
	
	@Test(priority = 5, enabled = true)
	public void doactivityFeedTest()
	{
		Assert.assertTrue(actfeed.doVerifyActivityFeed(),"Activity Feed text is not matched ");
	}
	
	
	@Test(priority = 6, enabled = true)
	public void iWantTest()
	{
		actfeed.iWant();
	}
	
	@Test(priority = 7, enabled = true)
	public void iExchangeTest()
	{
		actfeed.iExchange();
	}
	
	@Test(priority = 8, enabled = true)
	public void enterDetailsTest() 
	{   
		actfeed.enterDetails();
		
	}
	
	@Test(priority = 9, enabled = false)
	public void doActivityFeedFormBlankTitleFieldTest() 
	{
		
		Assert.assertTrue(actfeed.doActivityFeedFormBlankTitleField(),
				"Not Displayed error message after leave Title field blank in activity form page");
	}
	
	@Test(priority = 10, enabled = true)
	public void Test()
	{
		out.logoutButtonClick();
		
	}
	
}
