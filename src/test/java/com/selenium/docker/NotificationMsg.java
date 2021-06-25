package com.selenium.docker;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NotificationMsg {
	
	 
	@BeforeClass
	public void beforeTestLinkOpen() {
		
		Util.invokeBrowser(Constants.NotificationMessage);
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
			    boolean isUnsuccessful = false;
			    boolean isSuccessful = false;
			    for (int i = 0; i < 5; i++) {
			    	Util.webElementClickByXpath("//*[@id=\"content\"]/div/p/a");
				    
			    	Thread.sleep(2000);
			    	if(Util.getPageSourceCheck("Action unsuccesful, please try again") == "Action unsuccesful, please try again") {
			    		isUnsuccessful =  true;
			    	}
				    
				    
			    	if(Util.getPageSourceCheck("Action successful") == "Action successful") {
			    		isSuccessful =  true;
			    	}
				}
			    
			    boolean isFound = false;
			    if(isUnsuccessful == true && isSuccessful == true) {
			    	isFound = true;
			    }
			    
				Assert.assertEquals(true, isFound, "Message not shown properly");
				Reporter.log("Message shown successfully");
			   
			    
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

