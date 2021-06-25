package com.selenium.docker;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IFrame {
	 
	@BeforeClass
	public void beforeFloatingMenu() {
		
		Util.invokeBrowser(Constants.IFRAME);
		System.out.println("IFRAME started");
		Reporter.log("IFRAME started");
	}
	
	  @Test(priority=0)
	  public void testFloatingMenu() {
		  try {
			    try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			    
			    JavascriptExecutor jse = (JavascriptExecutor) Util.getDriver();  
			    jse.executeScript("window.scrollBy(0,document.body.scrollHeight || document.documentElement.scrollHeight)", "");
			    
			   WebElement webElement = Util.isElementPresent(By.xpath("//*[@id=\"mce_0_ifr\"]"), "IFrame");
			   
			   boolean iframeExist = false;
			   if(webElement != null && webElement.isDisplayed()) {
				   iframeExist = true;
			   }
				
				Assert.assertEquals(true, iframeExist, "Iframe  exist");
				Reporter.log("Iframe exist");
		  }catch (Exception e){
			  e.printStackTrace();
			  Util.driverAndBroswerClose();
		  }

	  }
	
@AfterClass(alwaysRun = true)
public void tearDown() {
	try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	Util.driverAndBroswerClose();
	Reporter.log("Driver Closed After Testing");
}

	
}
