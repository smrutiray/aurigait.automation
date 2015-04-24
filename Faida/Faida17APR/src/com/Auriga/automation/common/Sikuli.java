package com.Auriga.automation.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Sikuli 
{
	
	    // Screen : only focus on the screen.
	    // pattern : focus only on the images.
	
	
	    // 1. create object for screen class then only we can access all methods.
	        Screen s = new Screen();
	     
	    // 2. click on element   (click on specific image present on the screen)
	        s.click("<<image name>>");
	        ex: s.click("image1.png");
	     
	    // 3. right click on an element   (right click of image present on screen)
	        s.rightClick("<<image name>>");
	     
	    // 4. find an element    (to find specific element present on screen)
	        s.find("<<image name>>");
	     
	    // 5. double click on element   (double click on element present on screen)
	        s.doubleClick("<<image name>>");
	     
	    // 6. check element present on screen or not
	        s.exists("<<image name>>");
	     
	    // 7. type string on textbox present on screen
	        s.type("<<image name>>", "string to be typed");
	        ex: s.type("image1.png","abcd");
	     
	    // 8. wheeling on a particular image   (to perform wheeling action on the element image)
	        s.wheel("<<image name>>",int t1,int t2);
	        ex: s.wheel("image1.png",25,0);
	     
	    // 9. drag and drop image/element present on screen
	        s.dragdrop("<< source image name>>","<<target image name>>");
	     
	    // 10. roll hover on a particular image present on screen
	        s.hover("<<image name>>");
	     
	    // 11. paste and copied string   (used to paste text on specified textbox)
	         s.paste("<<image name>>","test");
	         ex: s.paste("image1.png","test");
	         
	     /* ex: Screen scr = new Screen();
	           Pattern img1 = new Pattern("path of your image where it is located after taking screenshot");
	           WebDriver driver = new FirefoxDriver();
	           driver.manage().windows().maximize();
	           driver.get("URL");
	           scr.click("img1");*/
	           
}

}

