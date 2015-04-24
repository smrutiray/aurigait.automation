package com.Faida.automation.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChangePassword 
{
	    protected WebDriver driver;
		private By enterPassword = By.name("newPassword1");
		private By reEnterPassword = By.name("newPassword2");
		private By update = By.xpath("//button[@type='submit' and text()='Register']");
		private By click = By.xpath("//div[@id='LandingPopup']/div/div/div[1]/button");
		
		public ChangePassword(WebDriver driver) 
		{
			this.driver = driver;
		}
		
		/*public void addChangePasswordDetails()
		   {
			   //driver.findElement(enterPassword).sendKeys(FirstSignin.Signin.enterNewPassword);    
			  // driver.findElement(reEnterPassword).sendKeys(FirstSignin.Signin.reEnterPassword);   
			  // driver.findElement(update).click();
		   }*/
		
		
			public void clickPopUp()
		    {
			   driver.findElement(click).click();
			   
		     }
		
		

}
