package com.selenium.docker;

import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JScriptError {
	
	 
	@BeforeClass
	public void beforeJSAlert() {
		
		Util.invokeBrowser(Constants.JSError);
		System.out.println("JSError started");
		Reporter.log("JSError started");
	}
	
	  @Test(priority=0)
	  public void testJSAlert() {
		  try {
			    try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			    boolean isErrorExist = false;
			    LogEntries logEntries = Util.getDriver().manage().logs().get("browser");
			    for (LogEntry entry : logEntries) {
				    System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
				    String errorLogType= entry.getLevel().toString();
				    String errorLog= entry.getMessage().toString();
				    if(errorLog.contains("Cannot read property 'xyz' of undefined")){
//				    System.out.println("Error LogType: "+ errorLogType+" Error Log message: "+errorLog);
				    	isErrorExist = true;
				    }
			    }
				
				Assert.assertEquals(true, isErrorExist, "Error not exist");
				Reporter.log("Error verified");
			   
			    
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

