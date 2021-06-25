package com.selenium.docker;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JSAlert {
    
     
    @BeforeClass
    public void beforeJSAlert() {
        
        Util.invokeBrowser(Constants.JSAlert);
        System.out.println("JSAlert started");
        Reporter.log("JSAlert started");
    }
    
      @Test(priority=0)
      public void testJSAlert() {
          try {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                Util.webElementClickByXpath("//*[@id=\"content\"]/div/ul/li[1]/button");
                
                Alert alert = Util.getDriver().switchTo().alert();
                String alertText = alert.getText();
                
                String expectedTitle = "I am a JS Alert";
                String originalTitle = alertText;
                Assert.assertEquals(originalTitle, expectedTitle, "Alert title is not same");
                Reporter.log("Alert text is same");
               
                
          }catch (Exception e){
              e.printStackTrace();
              Util.driverAndBroswerClose();
          }

      }
      
      @Test(priority=1)
      public void testDynamicContentAddButton() {
          try {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                Util.webElementClickByXpath("//*[@id=\"content\"]/div/ul/li[2]/button");
                
                Alert alert = Util.getDriver().switchTo().alert();
                String alertText = alert.getText();
                
                String expectedTitle = "I am a JS Confirm";
                String originalTitle = alertText;
                Assert.assertEquals(originalTitle, expectedTitle, "Alert title is not same");
                Reporter.log("Alert text is same");
          }catch (Exception e){
              e.printStackTrace();
              Util.driverAndBroswerClose();
          }

      }
      
      @Test(priority=2)
      public void testDynamicContentEnableButton() {
          try {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                Util.webElementClickByXpath("//*[@id=\"content\"]/div/ul/li[3]/button");
                
                Alert alert = Util.getDriver().switchTo().alert();
                String alertText = alert.getText();
                
                String expectedTitle = "I am a JS prompt";
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

