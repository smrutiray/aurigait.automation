package com.Faida.automation.pagefactory;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Auriga.automation.common.Framework;
import com.Faida.automation.factorydata.MainPage;


public class UserRegister 
{
	protected WebDriver driver;
	private By enterName = By.name("user[profile][name]");
	private By closepopup = By.xpath(".//*[@id='popupSignIn']/div/div/div[1]/button");
	private By enterEmail = By.name("user[email]");
	private By enterPhoneNumber = By.name("user[contact]");
	private By registerButton = By.xpath("//button[@type='submit']");
	private By regisButton = By.xpath("//button[text()='Register']");
	private By loginWithFacebook = By.xpath("//a[@href='/auth/facebook']");
	private By loginWithGoogle = By.xpath("//a[@href='/auth/google']");
	private By facebookEmail = By.id("email");
    private By facebookPass = By.id("pass");
	private By facebookLogin = By.id("loginbutton");
	private By allErrorMsg = By.id("signup-error");
	private By facebookErrorMsg = By.xpath("//div[@class='pam login_error_box uiBoxRed']");
	private By popupPage = By.xpath("//div[@id='LandingPopup']/div/div/div[1]/button");
	private By registerVerify = By.xpath("//span[@class='profile-name-cont']");
	private By getNotificationAfterRegister = By.xpath("//div[@class='alert-count img-circle messages-cont' and text()='1']");
	private By clickNotification  = By.xpath("//dt[text()='earn   points for registration ']");
	//private By notification = By.xpath("//div[text()='1']");
	private By nameBlank = By.id("//div[@id='signup-error']");
	private By userName = By.xpath("//span[@class='profile-name-cont']");
	
	public UserRegister(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	public void clickPopUp()
    {
	   driver.findElement(popupPage).click();
	}
	
	public void closeRegiPoppup()
	{
		Framework.Click(driver, closepopup);
	}
	public void clickRegister()
	{
		driver.findElement(By.xpath("//a[text()=' Register ']")).click();
	}
	
	public void clearAll()
	{
		   driver.findElement(enterName).clear();
		   driver.findElement(enterEmail).clear();
		   driver.findElement(enterPhoneNumber).clear();
		 
	}
	
	/*public Boolean doVerifyRegister() 
	{
		return Framework.verifySuccessMessage(driver,registerVerify,MainPage.Register.email1);
		
	}*/
	
   public void addRegisterDetails()
   {
	   //driver.findElement(By.xpath("//a[text()=' Register ']")).click();
	   driver.findElement(enterName).clear();
	   driver.findElement(enterName).sendKeys(MainPage.Register.name);
	   driver.findElement(enterEmail).clear();
	   driver.findElement(enterEmail).sendKeys(MainPage.Register.email1);
	   driver.findElement(enterPhoneNumber).clear();
	   driver.findElement(enterPhoneNumber).sendKeys(MainPage.Register.registerPhoneNumber);
	   driver.findElement(regisButton).click();
	   driver.findElement(getNotificationAfterRegister).click();
   }
   
   public Boolean doVerifyDetails()
   {
       return Framework.verifySuccessMessage(driver,clickNotification,MainPage.Register.notification);
	}
   
   public  void doRegisterBlankAllField() 
   {
		driver.findElement(enterName).clear();
		driver.findElement(enterEmail).clear();
		driver.findElement(enterPhoneNumber).clear();
		driver.findElement(registerButton).click();
        //return Framework.verifySuccessMessage(driver, allErrorMsg,MainPage.Register.allFieldBlankText);
        Assert.assertTrue(Framework.verifySuccessMessage(driver, allErrorMsg,MainPage.Register.allFieldBlankText));
   }
   
   public void doRegisterBlankNameField()
   {    
	   driver.findElement(enterName).clear();
	   driver.findElement(enterEmail).sendKeys(MainPage.Register.email1);
	   driver.findElement(enterPhoneNumber).sendKeys(MainPage.Register.registerPhoneNumber);
	   driver.findElement(regisButton).click();
	   //return Framework.verifySuccessMessage(driver,nameBlank,MainPage.Register.nameErrorText);
	   Assert.assertTrue(Framework.verifySuccessMessage(driver,nameBlank,MainPage.Register.nameErrorText));
   }
   
  /* public void doRegisterBlankPhoneField()
   {    
	   driver.findElement(enterName).sendKeys(MainPage.Register.name);
	   driver.findElement(enterEmail).sendKeys(MainPage.Register.email1);
	   driver.findElement(enterPhoneNumber).clear();
	   driver.findElement(registerButton).click();
	   //return Framework.verifySuccessMessage(driver,nameBlank,MainPage.Register.nameErrorText);
	   Assert.assertTrue(Framework.verifySuccessMessage(driver,phoneBlank,MainPage.Register.nameErrorText));
   }*/

	public void addFacebookDetails()
    {
	   driver.findElement(loginWithFacebook).click();
	   driver.findElement(facebookEmail).sendKeys(MainPage.Register.emailForFacebook);
	   driver.findElement(facebookPass).sendKeys(MainPage.Register.password);
	   driver.findElement(facebookLogin).click();
    }
	
	public void addGoogle()
	{
	   driver.findElement(loginWithGoogle).click();
	   
	   
   }
   
   
    public boolean doFacebookBlankAllField()
   {
	   driver.findElement(facebookEmail).clear();
	   driver.findElement(facebookPass).clear();
	   driver.findElement(loginWithFacebook).click();
	   return Framework.verifySuccessMessage(driver,facebookErrorMsg,MainPage.Register.facebookFieldBlank);
	   
   }
   
   
	
}
