package com.selenium.docker;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ContextMenu {
	 
	@BeforeClass
	public void beforeLogin() {
		
		Util.invokeBrowser(Constants.CONTEXT_MENU);
		System.out.println("Context Menu started");
		Reporter.log("Context menu started");
	}
	
	  @Test(priority=0)
	  public void testLogin() {
		  try {
			    try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    
			    Actions actions = new Actions(Util.getDriver());
			    WebElement elementLocator = Util.isElementPresent(By.id("hot-spot"), "hot-spot");//driver.findElement(By.id("ID"));
			    actions.contextClick(elementLocator).perform();
			    
			    Alert alert = Util.getDriver().switchTo().alert();
			    String alertText = alert.getText();
				
				String expectedTitle = "You selected a context menu";
				String originalTitle = alertText;
				Assert.assertEquals(originalTitle, expectedTitle, "Alert title is not same");
				Reporter.log("Alert text is same");
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
