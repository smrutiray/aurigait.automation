package com.Auriga.automation.common;

import java.io.File;
import java.security.InvalidParameterException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Framework 
{
	public static WebDriver InitializeBrowser(String browserType, String appURL) {

			WebDriver Initialdriver;
			switch (browserType) {
			case "chrome":
				Initialdriver = initChromeDriver(appURL);
				break;
			case "firefox":
				Initialdriver = initFirefoxDriver(appURL);
				break;
			case "InternetExplorer":
				Initialdriver = initInternetExplorerDriver(appURL);
				break;
			default:
				throw new InvalidParameterException("Invalid Browser type..!!");
			}

			Initialdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			return Initialdriver;
		}

		private static WebDriver initChromeDriver(String appURL) {
			System.out.println("Launching google chrome ...");

			System.setProperty("webdriver.chrome.driver",
					GlobaleVariable.Chromedriverpath + "chromedriver.exe");
			WebDriver chromedriver = new ChromeDriver();
			chromedriver.manage().window().maximize();
			chromedriver.navigate().to(appURL);
			return chromedriver;
		}

		private static WebDriver initInternetExplorerDriver(String appURL) {
			System.out.println("Launching Internet Explorer ...");

			System.setProperty("webdriver.ie.driver", GlobaleVariable.IEdriverpath
					+ "IEDriverServer.exe");
			WebDriver IEdriver = new InternetExplorerDriver();
			IEdriver.manage().window().maximize();
			IEdriver.navigate().to(appURL);

			return IEdriver;
		}

		private static WebDriver initFirefoxDriver(String appURL) {

			System.out.println("Launching Firefox browser..");
			WebDriver Firefoxdriver = new FirefoxDriver();
			Firefoxdriver.manage().window().maximize();

			Firefoxdriver.navigate().to(appURL);
			return Firefoxdriver;
		}
		// Pass by value than it will return with find , help to reduce again again write same statement .
		public static WebElement GetElement(WebDriver driver, By by) {
			return driver.findElement(by);

		}
		// Will select a option after passing visible text of drop down option
		public static void SelectByVisibleText(WebDriver driver, By by, String Text) {
			WebElement qty_dropdwon = driver.findElement(by);
			Select QTY = new Select(qty_dropdwon);
			QTY.selectByValue(Text);
		}
		// Will select a option after passing drop down option value .
		public static void SelectByValue(WebDriver driver, By by, String Text) {
			WebElement qty_dropdwon = driver.findElement(by);
			Select QTY = new Select(qty_dropdwon);
			QTY.selectByValue(Text);
		}
		// Will select a option after passing drop down Index value .
		public static void SelectByIndex(WebDriver driver, By by, String Text) {
			WebElement qty_dropdwon = driver.findElement(by);
			Select QTY = new Select(qty_dropdwon);
			QTY.selectByValue(Text);
		}
		// Click on WebElement like button or hyperlink .
		public static void Click(WebDriver driver, By by) {
			try {
				// if (driver.findElement(by).isDisplayed())
				WebElement Var = GetElement(driver, by);
				if (Var != null)
					if (Var.isDisplayed())
						driver.findElement(by).click();
					else
						Log.error("Error in Clicking");
				else
					Log.error("Element Not Found...");
			} catch (Exception e) {
				e.getStackTrace();

			}
		}
		//  push data to text field . 
		public static void Type(WebDriver driver , By by , String value)
		    {
		    	try{
		    	    WebElement Var = GetElement(driver , by);
		    		if (Var != null)
		    			if (Var.isDisplayed() && Var.isEnabled())
		    			{
		    				driver.findElement(by).clear();
		    				driver.findElement(by).sendKeys(value);
		    			}
		    		  		
		    	else {
		    		Log.error("This field is disabled -> " + Var );
		    	//	throw new IllegalStateException("Error in Clicking on -> " + by );
		    	}
		    		else Log.error("This Element -> " + Var + "is Not Found.");
		    }catch (Exception e){
				e.getStackTrace();
				
			}
		    }
		//  Will Select Radio button value.
		public static void SelectRaidoButton(WebDriver driver , By by)	
		    {
		    try{
		    	    WebElement Var = GetElement(driver , by);
		    		if (Var != null)
		    			if (Var.isDisplayed() && Var.isEnabled())
		    				if (! Var.isSelected())
		    		               driver.findElement(by).click();
		    	        else Log.error("This field is disabled -> " + Var );
		        	
		    		else Log.error("This Element -> " + Var + "is Not Found.");
		    }catch (Exception e){ e.getStackTrace();}
		    	
		    }
		//  Will Select Radio button value.
		public static void SelectCheckBox(WebDriver driver , By by)
		    {
		     try{
		     	    WebElement Var = GetElement(driver , by);
		     		if (Var != null)
		     			if (Var.isDisplayed() && Var.isEnabled())
		     				if (! Var.isSelected())
		     		               driver.findElement(by).click();
		     	        else Log.error("This Check Box is disabled -> " + Var );
		         	
		     		else Log.error("This Element -> " + Var + "is Not Found.");
		     }catch (Exception e){ e.getStackTrace();}
		     	
		     }
		//  Will DeSelect Radio button value.  
		public static void DeselectCheckBox(WebDriver driver , By by)
		    {
		    	 try{
		      	    WebElement Var = GetElement(driver , by);
		      		if (Var != null)
		      			if (Var.isDisplayed() && Var.isEnabled())
		      				if (Var.isSelected())
		      		               driver.findElement(by).click();
		      	        else Log.error("This Check Box is disabled -> " + Var );
		          	
		      		else Log.error("This Element -> " + Var + "is Not Found.");
		      }catch (Exception e){ e.getStackTrace();}
		    }
		//  Will wait till the page not load else fail 
		public static void WaitForPageToLoad(WebDriver driver , int time)
		    {
		    	driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
		    }
		// Will accept alert box.
		public static void AcceptAlert(WebDriver driver)
		    {
		    	try{
		    	driver.switchTo().alert().accept();
		    	Log.info(" Alert  Accepted .");
		        }catch (Exception e){ e.getStackTrace();}
		    }
		// Will Dismiss the alert box . 
		public static void DismissAlert(WebDriver driver)
		    {
		    	try{
		        	driver.switchTo().alert().dismiss();
		        	Log.error("Alert Dismissed.");
		            }catch (Exception e){ e.getStackTrace();}
		    }
		// Will Get text from WebElement
		public static String GetText(WebDriver driver , By by)
		    {
		    	try{
		    	    WebElement Var = GetElement(driver , by);
		    		if (Var != null)
		    			if (Var.isDisplayed())
		    	return	driver.findElement(by).getText();
		    	else {
		    		Log.error("This field is not visible -> " + Var );
		    	return null;
		    	}
		    		else {
		    			Log.error("This Element -> " + Var + "is Not Found.");
		    			return null;
		    		}
		    }catch (Exception e){
				e.getStackTrace();
				return null;
				
			}
		    	
		    	
		    }
		// Will hover on menus and choose option.
		public static void HoverAndClickOnElement (WebDriver driver , By HoverElement , By ClickElement)
		    {
		    	try{
		    	WebElement HoverOnElement = GetElement(driver, HoverElement );
		    	WebElement ClickOnElement = GetElement(driver, ClickElement );
		    	if (HoverOnElement != null && ClickOnElement != null )
		    	{
		    		if (HoverOnElement.isDisplayed()  )
		    		{
		        Actions action = new Actions(driver);
		        action.moveToElement(HoverOnElement).build().perform();
		        Click(driver,ClickElement );
		    		}else Log.error("This field is not visible -> " + HoverOnElement );
		    	}else Log.error("These Elements -> " + HoverOnElement + " and "+ ClickOnElement + "are Not Found.");
		    }catch (Exception e){e.getStackTrace();}

		    
		    }
		// Will navigate to desired URL. 
		public static void NavigateTo(WebDriver driver, String URL)
		    {
		    	try{
		    	driver.navigate().to(URL);
		    	}catch(Exception e){e.getStackTrace();}
		    }
		// Will Match WebElement value with expected and return boolean value.
		public static Boolean verifySuccessMessage(WebDriver driver, By by,
				String message) {
			WebElement msgsuccess = GetElement(driver, by);
			WebDriverWait wait1 = new WebDriverWait(driver, 28);
			WebElement w1 = driver.findElement(by);
			wait1.until(ExpectedConditions.textToBePresentInElement(w1, message));
			if (msgsuccess.getText().matches(message)) {
					Log.info(message+"Message matched");
				return true;

			} else {
				Log.info(message+"Message Not matched");
				return false;
			}
		}
		// Will Match WebElement value with expected and return boolean value.
		public static Boolean verifyErrorMessage(WebDriver driver, By by,
				String message) {
			WebElement msgsuccess = GetElement(driver, by);
			WebDriverWait wait1 = new WebDriverWait(driver, 28);
			WebElement w1 = driver.findElement(by);
			wait1.until(ExpectedConditions.textToBePresentInElement(w1, message));
			if (msgsuccess.getText().matches(message)) {

				return true;

			} else {

				return false;
			}
		}
		// Will Match WebElement value with expected and return boolean value.
		public static Boolean verifInputFieldData(WebDriver driver, By by,String elemessage) {
			WebElement element = GetElement(driver, by);

			System.out.println(element.getText() + " passed ");

			if (element.getAttribute("value").matches(elemessage)) {

				System.out.println(element.getText() + " passed ");
				Log.info(element.getText() + " passed ");
				return true;
			} else {
				return false;
			}

		}
		// Will Match Drop Down WebElement value with expected and return boolean value.
		public static Boolean verifyDropDownData(WebDriver driver, By by, String element) {
			String actualelement = new Select(driver.findElement(by)).getFirstSelectedOption().getText();

			System.out.println(actualelement + " passed ");

			if (actualelement.matches(element)) {

				System.out.println(actualelement + " passed ");
				Log.info(actualelement + " passed ");
				return true;
			} else {
				return false;
			}
		}
		//to take the screenshot and work with that.
		public static void getScreenShot(WebDriver driver, String path, String FileName)
		{
			try
			{
				
				Log.info("Taking Screenshot");
		         EventFiringWebDriver edriver = new EventFiringWebDriver(driver);
		         File src = edriver.getScreenshotAs(OutputType.FILE);
		         File dest = new File(path + FileName + ".png");
		         Log.info("Destination file name "+dest);
		         FileUtils.copyFile(src, dest);
	        }
	       catch(Exception e)
	        {
	    	     //if fails to take screenshot then this block will execute
	    	     e.getStackTrace();
	        }
		}
		
		
			
	}


