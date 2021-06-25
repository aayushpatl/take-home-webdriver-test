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

public class DynamicControls {
    
     
    @BeforeClass
    public void beforeDynamicContent() {
        
        Util.invokeBrowser(Constants.DYNAMIC_CONTROL);
        System.out.println("DYNAMIC_CONTROL started");
        Reporter.log("DYNAMIC_CONTROL started");
    }
    
      @Test(priority=0)
      public void testDynamicContentRemoveButton() {
          try {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                Util.webElementClickByXpath("//*[@id=\"checkbox-example\"]/button");
             // explicit wait - to wait for the compose button to be click-able
                WebDriverWait wait = new WebDriverWait(Util.getDriver(),40);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"checkbox-example\"]/button")));
                
                WebElement checkbox  = Util.isElementPresent(By.xpath("//*[@id=\"checkbox\"]"), "chkbox");
                
                boolean chkboxDisplayed = false;
                if(checkbox != null) {
                    if(Util.getPageSourceCheck("It's gone!") == "It's gone!") {
                        chkboxDisplayed = true;
                    }else {
                        chkboxDisplayed = false;
                    }
                }
                
                Assert.assertEquals(true, chkboxDisplayed, "Checkbox disappeared properly");
                Reporter.log("Checkbox Successfully");
               
                
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
                
                Util.webElementClickByXpath("//*[@id=\"checkbox-example\"]/button");
             // explicit wait - to wait for the compose button to be click-able
                WebDriverWait wait = new WebDriverWait(Util.getDriver(),30);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"checkbox-example\"]/button")));
                
                WebElement checkbox  = Util.isElementPresent(By.xpath("//*[@id=\"checkbox\"]"), "chkbox");
                
                boolean chkboxDisplayed = false;
                if(checkbox != null) {
                    if(Util.getPageSourceCheck("A checkbox") == "A checkbox") {
                        chkboxDisplayed = true;
                    }else {
                        chkboxDisplayed = false;
                    }
                }
                
                Assert.assertEquals(true, chkboxDisplayed, "Checkbox appeard properly");
                Reporter.log("Checkbox Successfully");
               
                
//                Assert.assertEquals(false, isPass, "dynamic control changes");
//                Reporter.log("dynamic control changes");
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
              
              Util.webElementClickByXpath("//*[@id=\"input-example\"]/button");
              
              boolean buttonStatus = false;
              if(Util.getPageSourceCheck("It's enabled!") == "It's enabled!") {
            	  buttonStatus = true;
              }else {
            	  buttonStatus = false;
              }
              
              Assert.assertEquals(true, buttonStatus, "Button disabled properly");
              Reporter.log("Button disabled Successfully");
             
              
        }catch (Exception e){
            e.printStackTrace();
            Util.driverAndBroswerClose();
        }
      }
      
      @Test(priority=3)
      public void testDynamicContentDisableButton() {
          try {
              try {
                  Thread.sleep(3000);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
              
              Util.webElementClickByXpath("//*[@id=\"input-example\"]/button");
              
              boolean buttonStatus = false;
              if(Util.getPageSourceCheck("It's disabled!") == "It's disabled!") {
            	  buttonStatus = true;
              }else {
            	  buttonStatus = false;
              }
              
              Assert.assertEquals(true, buttonStatus, "Button enabled properly");
              Reporter.log("Button enabled Successfully");
             
              
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