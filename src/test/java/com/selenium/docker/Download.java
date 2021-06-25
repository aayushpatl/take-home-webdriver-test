package com.selenium.docker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Download {
	
	 
	@BeforeClass
	public void beforeDownload() {
		
		Util.invokeBrowser(Constants.DOWNLOAD);
		System.out.println("DOWNLOAD started");
		Reporter.log("DOWNLOAD started");
	}
	
	  @Test(priority=0)
	  public void testDownload() {
		  try {
			    try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			    
			    Util.webElementClickByXpath("//*[@id=\"content\"]/div/a");

			    
//			    C:\Users\Deepak Sharma\Downloads\some-file.txt
			    
//			    some-file.txt
			    
			    
			    boolean isFileExist = false;
			    if(Util.isFileExist("C:\\Users\\Deepak Sharma\\Downloads\\some-file.txt")) {
			    	isFileExist = true;
		    	}else {
		    		isFileExist = false;
		    	}
				
				Assert.assertEquals(true, isFileExist, "File not downloaded");
				Reporter.log("File downloaded Successfully");
			   
			    
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

