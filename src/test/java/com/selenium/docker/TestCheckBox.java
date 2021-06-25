package com.selenium.docker;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestCheckBox {
	 
	@BeforeClass
	public void beforeCheckin() {
		
		Util.invokeBrowser(Constants.TEST_CHECKBOX);
		System.out.println("Checkbox started");
		Reporter.log("Checkbox started");
	}
	
	  @Test(priority=0)
	  public void testCheckBox() {
		  try {
			    try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    
//			    driver.findElement(By.id("hobbies-checkbox-1")).click();
			    Util.webElementClickByXpath("//*[@id=\"checkboxes\"]/input[1]");
			    
			    WebElement checkbox  = Util.isElementPresent(By.xpath("//*[@id=\"checkboxes\"]/input[1]"), "chkbox");
			    
			    boolean chkboxSelected = false;
			    if(checkbox != null) {
			    	if(checkbox.isSelected() == true) {
			    		chkboxSelected = true;
			    	}
			    }
				
				Assert.assertEquals(true, chkboxSelected, "Checkbox selected properly");
				Reporter.log("Checkbox Successfully");
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
