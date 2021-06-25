package com.selenium.docker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Upload {
	
	 
	@BeforeClass
	public void beforeUpload() {
		
		Util.invokeBrowser(Constants.UPLOAD);
		System.out.println("UPLOAD started");
		Reporter.log("UPLOAD started");
	}
	
	  @Test(priority=0)
	  public void testUpload() {
		  try {
			    try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			    
//			    Util.getDriver().findElement(By.xpath("//*[@id=\"file-upload\"]")).click(); // Click on import button to see import option
//			    
//			    WebElement webElementUploadFile= Util.getDriver().findElement(By.xpath("//*[@id=\"file-upload\"]"));
//				
//				//To wait for element visible
//				  WebDriverWait wait = new WebDriverWait(Util.getDriver(), 20);
//				  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='upfile']")));
//				  
//			      if(webElementUploadFile.isDisplayed()) {
//			    	  System.out.println("webElementUploadFile displayed ");
//			      
//			    	  WebElement uploadElement = Util.getDriver().findElement(By.id("upfile"));
//			    	  // enter the file path onto the file-selection input field
//			    	 
//
//			      }
			      
			      String projectRootPath = Util.getProjectDirectory();
			      WebElement uploadElement = Util.getDriver().findElement(By.id("file-upload"));
		    	  if(Util.isWindows()) {
		    		  uploadElement.sendKeys(projectRootPath + "\\" + "logs.txt");
		    	  }else {
		    		  uploadElement.sendKeys(projectRootPath + "/" + "logs.txt");	  
		    	  }

			       // click the "UploadFile" button
		    	  Util.getDriver().findElement(By.id("file-submit")).click();
			    
				   boolean fileStatus = false;
			    	if(Util.getPageSourceCheck("File Uploaded!") == "File Uploaded!") {
			    		fileStatus = true;
			    	}else {
			    		fileStatus = false;
			    	}
					
					
				Assert.assertEquals(true, fileStatus, "File not uploaded");
				Reporter.log("File uploaded Successfully");
			   
			    
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

