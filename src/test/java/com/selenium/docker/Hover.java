package com.selenium.docker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Hover {
	 
	@BeforeClass
	public void beforeHover() {
		
		Util.invokeBrowser(Constants.HOVER);
		System.out.println("Hover started");
		Reporter.log("Hover started");
	}
	
	  @Test(priority=0)
	  public void testHover() {
		  try {
			    try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			    
			    WebElement ele = Util.getDriver().findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/img"));
			    WebElement ele2 = Util.getDriver().findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/img"));
			    WebElement ele3 = Util.getDriver().findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/img"));

			  //Creating object of an Actions class
			  Actions action = new Actions(Util.getDriver());

			  //Performing the mouse hover action on the target element.
			  action.moveToElement(ele).perform();
			  action.moveToElement(ele2).perform();
			  action.moveToElement(ele3).perform();
			   
			    boolean hoverDisplay = false;
		    	if(Util.getPageSourceCheck("name: user3") == "name: user3") {
		    		hoverDisplay = true;
		    	}else {
		    		hoverDisplay = false;
		    	}
				
				Assert.assertEquals(true, hoverDisplay, "Hover display properly");
				Reporter.log("Hover display Successfully");
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
