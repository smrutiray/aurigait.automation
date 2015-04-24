package com.Faida.automation.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Auriga.automation.common.TestBaseSetUp;
import com.Faida.automation.pagefactory.LogOut;
import com.Faida.automation.pagefactory.MyListings;
import com.Faida.automation.pagefactory.UserSignIn;



public class MyListingsTest extends TestBaseSetUp
{
	private WebDriver driver;
	UserSignIn usersign;
	MyListings mylist;
	LogOut out;
	
	@BeforeClass
	public void setup() 
	{
		driver = getDriver();
		
		usersign = new UserSignIn(driver);
		mylist = new MyListings(driver);
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
	   public void clickMyListingsTest()
	{
		//mylist.doVerifyMyListings();
		mylist.clickMyListings();
		//FrameWork.WaitForPageToLoad(driver, 20);
		
	}
	@Test(priority = 5, enabled = true)
	 public void doVerifyMyListingsTest()
	{
		//mylist.doVerifyMyListings();
		Assert.assertTrue(mylist.doVerifyMyListings(),"my listings text is not matched ");
	}
	

	@Test(priority = 6, enabled = true)
	public void doMyListingsBelowTest()
	{
		//mylist.clickMyListings();
		mylist.clickMyListingBelowTab();
	}
	
	
	@Test(priority = 7, enabled = true)
	public void doMyListingsDisableTest()
	{
		mylist.clickOnDisableItems();
		mylist.clickOkDisableBtn();
	}
	
	
	@Test(priority = 8, enabled = true)
	public void doMyListingsNotAvailTest()
	{
		mylist.clickOnNotAvailableItems();
	}
	
	@Test(priority = 9, enabled = true)
	public void Test()
	{
		out.logoutButtonClick();
		
	}
	
	
}
