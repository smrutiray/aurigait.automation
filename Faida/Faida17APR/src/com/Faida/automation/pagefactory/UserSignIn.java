package com.Faida.automation.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Auriga.automation.common.Framework;
import com.Auriga.automation.common.Log;
import com.Faida.automation.factorydata.FirstSignIn;
import com.Faida.automation.factorydata.MainPage;

public class UserSignIn 
{
	protected WebDriver driver;
	private By userLoginText = By.xpath("//span[@class='profile-name-cont']");
	private By loginEmail = By.xpath("//input[@class='form-control login-user']");
	private By loginPassword = By.xpath("//input[@placeholder='Enter Password']");
	private By loginButton = By.xpath("//button[text()='Login']");
	private By loginErrorMsg = By.xpath("//div[text()='Invalid Username or Password.']");
	private By loginFacebookText = By.xpath("//a[@href='/auth/facebook']");
	private By loginFacebookEmail = By.id("email");
	private By loginFacebookPass = By.id("pass");
	private By loginFacebookButton = By.id("u_0_2");
	private By loginGoogleText = By.xpath("//a[@class='social-btn gp-btn']");
	private By loginGoogle = By.id("grant_heading");
	private By loginGoogleCancelButton = By.id("submit_deny_access");
	private By loginGoogleAcceptButton = By.id("submit_approve_access");
	private By popupPage = By.xpath("//div[@id='LandingPopup']/div/div/div[1]/button");
	private By signin = By.xpath("//a[text()=' Sign In ']");
	
	public UserSignIn(WebDriver driver) 
	{
		this.driver = driver;
	}
	public void clickPopUp()
    {
	   driver.findElement(popupPage).click();
	}
	
	/*public Boolean doVerifySignin() 
	{
		if (driver.getTitle().matches(MainPage.Signin.login))
		{
		   Log.info("signin text displayed");	
		   return true;
		}
		else
		{   Log.error("signin not displayed");
			return false;
		}
	}*/
	
	public void addLoginDetails()
	   {
		   //driver.findElement(loginEmail).sendKeys(MainPage.Signin.enterYourEmail);    (use later)
		  // driver.findElement(loginPassword).sendKeys(MainPage.Signin.password);       (use later)
		
		   Log.info("Adding Login Details");
		   driver.findElement(signin).click();
		   driver.findElement(loginEmail).sendKeys(FirstSignIn.Signin.emailid);    
		   driver.findElement(loginPassword).sendKeys(FirstSignIn.Signin.password);   
		   driver.findElement(loginButton).click();
		   
	   }
	
   /* public void addFacebookDetails()
    {
		   driver.findElement(loginFacebookEmail).sendKeys(MainPage.Signin.emailForFacebook);
		   driver.findElement(loginFacebookPass).sendKeys(MainPage.Signin.password1);
		   driver.findElement(loginFacebookButton).click();
	}
      public void addGoogleDetails()
         {

		   driver.findElement(loginGoogleCancelButton).click();
		   driver.findElement(loginGoogleAcceptButton ).click();
		   
	   } */
	
	 public Boolean doLoginBlankAllField() 
	   {
			driver.findElement(loginEmail).clear();
			driver.findElement(loginPassword).clear();
			driver.findElement(loginButton).click();
			if (driver.findElement(loginErrorMsg).getText()
					.matches(MainPage.Signin.loginFieldBlank))
			{
				Log.info("all login fields are empty");
			    return true;
			}
			
			else
			{
			    Log.error("login fields are not empty");        
				return false;
		}
			
	   }
	 
	 public Boolean doLoginEmailBlank()
	 {
		 driver.findElement(loginEmail).clear();
		 driver.findElement(loginPassword).sendKeys(MainPage.Signin.password);
		 driver.findElement(loginButton).click();
		 return Framework.verifySuccessMessage(driver,loginErrorMsg,MainPage.Signin.emailErrorText);
	}
	 
	 public Boolean doLoginPassBlank()
	 {
		 driver.findElement(loginEmail).sendKeys(MainPage.Signin.enterYourEmail);
		 driver.findElement(loginPassword).clear();
		 driver.findElement(loginButton).click();
		 return Framework.verifySuccessMessage(driver,loginErrorMsg,MainPage.Signin.passwordErrorText);
			
	  }
	 
	 
	/* public Boolean doVerifyFacebook() 
		{
			if (driver.getTitle().matches(MainPage.Signin.loginWithFacebook))
			{
				Log.info("title matched");
			    return true;
			}
			else
			{
				Log.error("title mis-matched");
			    return false;
		}
			
		} */
	 
	 public Boolean doVerifyUserNameAfterSignIn() 
	 {
		 return Framework.verifySuccessMessage(driver,userLoginText,MainPage.Signin.userName);
			
      }
}
