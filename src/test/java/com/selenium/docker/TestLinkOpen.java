package com.selenium.docker;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestLinkOpen {
	
	 
	@BeforeClass
	public void beforeTestLinkOpen() {
		
		Util.invokeBrowser(Constants.TestLinkOpen);
		System.out.println("TestLinkOpen started");
		Reporter.log("TestLinkOpen started");
	}
	
	  @Test(priority=0)
	  public void testTestLinkOpen() {
		  try {
			    try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
//			    Util.webElementClickByXpath("//*[@id=\"content\"]/div/a");
			    boolean isFound = Util.webElementLinkToClickWithNewWin("Click Here");
			    
				Assert.assertEquals(true, isFound, "Window open properly");
				Reporter.log("Window open successfully");
			   
			    
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

