package com.selenium.docker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DropDown {
	 
	@BeforeClass
	public void beforeDropDown() {
		
		Util.invokeBrowser(Constants.DROP_DOWN);
		System.out.println("Drop Down started");
		Reporter.log("Drop Down started");
	}
	
	  @Test(priority=0)
	  public void testDropDown() {
		  try {
			    try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    
			    Select drpDown = new Select(Util.getDriver().findElement(By.id("dropdown")));
			    drpDown.selectByVisibleText("Option 1");
				
			    //verify text changed in to 'Drop here' box 
			    String textTo = drpDown.getAllSelectedOptions().get(0).getText();
			    boolean isPass = false;
			    if(textTo.equals("Option 1")) {
			    	System.out.println("PASS: Option 1 selected");
			    	isPass = true;
			    }else {
			    	System.out.println("FAIL: Option 1 not selected");
			    	isPass = false;
			    }
			    
				Assert.assertEquals(true, isPass, "Dropdown selected properly");
				Reporter.log("Dropdown selected");
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
