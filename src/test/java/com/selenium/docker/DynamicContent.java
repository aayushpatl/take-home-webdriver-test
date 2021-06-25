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

public class DynamicContent {
	
	String[] imgs = {"http://localhost:7080/img/avatars/Original-Facebook-Geek-Profile-Avatar-7.jpg", "http://localhost:7080/img/avatars/Original-Facebook-Geek-Profile-Avatar-1.jpg", "http://localhost:7080/img/avatars/Original-Facebook-Geek-Profile-Avatar-3.jpg", "http://localhost:7080/img/avatars/Original-Facebook-Geek-Profile-Avatar-2.jpg"};
	String[] contents = {"Dicta et nemo maxime voluptatem dolor vitae inventore voluptatum minus voluptatem qui ipsum quo doloremque perspiciatis non autem quia veritatis quis ipsa enim dignissimos occaecati qui voluptates assumenda iure aut praesentium.","Et rerum corporis expedita eligendi quidem est suscipit eum quaerat rerum magni aut sequi ipsa iste quae quas sint maiores omnis beatae nobis quia mollitia non ut eos facilis magnam.","Dicta et nemo maxime voluptatem dolor vitae inventore voluptatum minus voluptatem qui ipsum quo doloremque perspiciatis non autem quia veritatis quis ipsa enim dignissimos occaecati qui voluptates assumenda iure aut praesentium.","Sint aperiam minus dolorem numquam sed perspiciatis aliquid et eum natus voluptatem eius eaque earum fugiat ipsam corporis placeat illo molestiae eos explicabo odio maxime unde omnis voluptas non quos commodi."
		,"Rerum velit et enim incidunt nobis tempore facere est est eveniet perspiciatis saepe fugit veniam nihil ipsum nemo eum et repellat et nisi laboriosam optio et consequuntur rerum et et adipisci nihil sit."};
	 
	@BeforeClass
	public void beforeDynamicContent() {
		
		Util.invokeBrowser(Constants.DYNAMIC_CONTENT);
		System.out.println("DYNAMIC_CONTENT started");
		Reporter.log("DYNAMIC_CONTENT started");
	}
	
	  @Test(priority=0)
	  public void testDynamicContent() {
		  try {
			    try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			    boolean isPass = false;
			    boolean imgValue = false;
			    boolean contentValue = false;
			    for (int i = 0; i < imgs.length; i++) {
				    Util.getDriver().get(Constants.DYNAMIC_CONTENT);
				    Util.getDriver().navigate().refresh();
				    WebElement elementImg =  Util.isElementPresent(By.xpath("//*[@id=\"content\"]/div[1]/div[1]/img"), "image");
				    System.out.println(elementImg.getAttribute("src"));
					if(imgs[i] == elementImg.getAttribute("src")) {
						imgValue = true;
					}else {
						imgValue = false;
					}
				    WebElement elementText =  Util.isElementPresent(By.xpath("//*[@id=\"content\"]/div[1]/div[2]"), "image");
				    System.out.println(elementText.getText());
					if(contents[i] == elementText.getText()) {
						contentValue = true;
					}else {
						contentValue = false;
					}
				}
			    
				if(imgValue == true && contentValue == true) {
					isPass = true;
				}
			    
				Assert.assertEquals(false, isPass, "dynamic content changes");
				Reporter.log("dynamic content changes");
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

