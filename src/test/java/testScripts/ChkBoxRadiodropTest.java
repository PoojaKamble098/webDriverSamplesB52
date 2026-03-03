package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ChkBoxRadiodropTest {
	WebDriver driver;
	@Parameters("browser")
	@BeforeTest
	
	public void setup(String strBrowser) {
		if(strBrowser.equalsIgnoreCase("chrome")){
		
			driver = new ChromeDriver();
		
		}
		else if(strBrowser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		
	}
	 driver.manage().window().maximize();
	  driver.get("https://testautomationpractice.blogspot.com/");
		}
	
  @Test
  public void checkboxradio() {
	  
	  WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		  driver.get("https://testautomationpractice.blogspot.com/");
		  WebElement sunday = driver.findElement(By.id("sunday"));
		  WebElement monday = driver.findElement(By.id("monday"));
		  sunday.click();
	//	  Assert.assertTrue(sunday.isSelected());
		//  Assert.assertFalse(sunday.isSelected());
		  
		  //Create softAssert
		  SoftAssert softAssert = new SoftAssert();
		  softAssert.assertFalse(sunday.isSelected());
		  System.out.println("Value of sunday ...."+sunday.getDomAttribute("value"));
		  System.out.println("Value of a property ...."+sunday.getDomProperty("tagName"));
		    
		  monday.click();
		  if (sunday.isSelected()) {
			  sunday.click();
			 
  }
		  softAssert.assertFalse(sunday.isSelected());
		  softAssert.assertAll();
}
}