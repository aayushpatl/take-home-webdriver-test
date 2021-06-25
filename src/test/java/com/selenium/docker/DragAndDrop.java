package com.selenium.docker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DragAndDrop {

	@BeforeClass
	public void beforeDragAndDrop() {

		Util.invokeBrowser(Constants.DRAG_DROP);
		System.out.println("Drag and Drop started");
		Reporter.log("Drag and Drop started");
	}

	@Test(priority = 0)
	public void testDragAndDrop() {
		try {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			WebElement from = Util.getDriver().findElement(By.id("column-a"));
			WebElement to = Util.getDriver().findElement(By.id("column-b"));
//                            //Creating object of Actions class to build composite actions
			Actions builder = new Actions(Util.getDriver());
			// Perform drag and drop
			builder.dragAndDrop(from, to).perform();
			// verify text changed in to 'Drop here' box
			String textTo = from.getText();
			boolean isPass = false;
			if (textTo.equals("A")) {
				System.out.println("PASS: File is dropped to target as expected");
				isPass = true;
			} else {
				System.out.println("FAIL: File couldn't be dropped to target as expected");
				isPass = false;
			}

//                          //Element which needs to drag.            
//                         WebElement From=Util.getDriver().findElement(By.xpath("//*[@id=\"column-a\"]"));    
//                         
//                         //Element on which need to drop.        
//                         WebElement To=Util.getDriver().findElement(By.xpath("//*[@id=\"column-b\"]"));                    
//                                 
//                         //Using Action class for drag and drop.        
//                         Actions act=new Actions(Util.getDriver());    
//                         
//                         //Dragged and dropped.        
//                         act.dragAndDrop(From, To).build().perform();

//                          //WebElement on which drag and drop operation needs to be performed
//                            WebElement fromElement = Util.getDriver().findElement(By.xpath("//*[@id=\"column-a\"]"));
			//
//                            //WebElement to which the above object is dropped
//                            WebElement toElement = Util.getDriver().findElement(By.xpath("//*[@id=\"column-b\"]"));    
			//
//                            //Creating object of Actions class to build composite actions
//                            Actions builder = new Actions(Util.getDriver());
			//
//                            //Building a drag and drop action
//                            Action dragAndDrop = builder.clickAndHold(fromElement)
//                            .moveToElement(toElement)
//                            .release(toElement)
//                            .build();

			// Performing the drag and drop action
//                            dragAndDrop.perform();
//                            

			Assert.assertEquals(true, isPass, "Drag properly");
			Reporter.log("Dragged");
		} catch (Exception e) {
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
