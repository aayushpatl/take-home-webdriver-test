package com.selenium.docker;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class LoginSuccess {
	 
	@BeforeClass
	public void beforeLogin() {
		
		Util.invokeBrowser(Constants.LOGIN_URL);
		System.out.println("Login started");
		Reporter.log("Login started");
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
			    
				Util.webElementSendKeyByXpath("//*[@id=\"username\"]", Constants.EMAIL);
				Util.webElementByNameClear("password"); // clear
				Util.webElementSendKeyByXpath("//*[@id=\"password\"]",  Constants.PASSWORD);
				Util.webElementClickByXpath("//*[@id=\"login\"]/button");
				
				String expectedTitle = "Secure Area";
				String originalTitle = Util.getPageSourceCheck("Secure Area");
				Assert.assertEquals(originalTitle, expectedTitle, "There is some problem while login");
				Reporter.log("Login again Successful");
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
