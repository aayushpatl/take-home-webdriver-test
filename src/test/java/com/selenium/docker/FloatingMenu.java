package com.selenium.docker;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FloatingMenu {
	 
	@BeforeClass
	public void beforeFloatingMenu() {
		
		Util.invokeBrowser(Constants.FLOATING_MENU);
		System.out.println("Floating menu started");
		Reporter.log("Floating menu started");
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
			    
			   WebElement webElement = Util.isElementPresent(By.xpath("//*[@id='menu']/ul/li[1]/a"), "Floating menu");
			   
			   boolean floatingMenuExist = false;
			   if(webElement != null && webElement.isDisplayed()) {
				   floatingMenuExist = true;
			   }
				
				Assert.assertEquals(true, floatingMenuExist, "Floating menu exist");
				Reporter.log("Floating menu exist");
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
