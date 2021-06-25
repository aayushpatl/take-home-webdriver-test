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

public class DynamicLoading {
    
     
    @BeforeClass
    public void beforeDynamicContent() {
        
        Util.invokeBrowser(Constants.DYNAMIC_LOADING);
        System.out.println("DYNAMIC_LOADING started");
        Reporter.log("DYNAMIC_LOADING started");
    }
    
      @Test(priority=0)
      public void testDynamicContentRemoveButton() {
          try {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                Util.webElementClickByXpath("//*[@id=\"start\"]/button");
             // explicit wait - to wait for the compose button to be click-able
               boolean buttonStatus = false;
                if(Util.getPageSourceCheck("Hello World!") == "Hello World!") {
                    buttonStatus = true;
                }else {
                    buttonStatus = false;
                }
                
                Assert.assertEquals(true, buttonStatus, "Hello World! appeared properly");
                Reporter.log("Hello World! appeared came Successfully");
               
                
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