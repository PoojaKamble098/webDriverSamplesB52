package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ChkBoxdrop {
  
	WebDriver driver;
	@BeforeTest
	public void setup() {	
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	driver.get("https://testautomationpractice.blogspot.com/");
	}
	  
	@Test(groups="SmokeTest")
 
  public void ChkBoxdrop1() {
	  
	  //WebDriver driver = new ChromeDriver();
		// driver.manage().window().maximize();
		  //driver.get("https://testautomationpractice.blogspot.com/");
		  WebElement gender = driver.findElement(By.id("female"));
		  if (!gender.isSelected()) {
			  gender.click();
			  
			  		  }	
		  Assert.assertFalse(gender.isSelected());
	}

		  
		  
		  @Test(alwaysRun= true, dependsOnMethods = "ChkBoxdrop1" )
		  public void checkboxradio() {
			  
			  //WebDriver driver = new ChromeDriver();
				// driver.manage().window().maximize();
				  //driver.get("https://testautomationpractice.blogspot.com/");
				  WebElement sunday = driver.findElement(By.id("sunday"));
				  WebElement monday = driver.findElement(By.id("monday"));
				  sunday.click();
				  System.out.println("Value of sunday ..."+sunday.getDomAttribute("Value"));
				  System.out.println("Value of property ..."+sunday.getDomProperty("tagName"));
				  
				  monday.click();
				  if (sunday.isSelected()) {
					  sunday.click();
		  
  }
		  
		  Assert.assertFalse(sunday.isSelected());

}


@Test(priority = 1)

public void dropdownTest() {
	
	Select singSel = new Select (driver.findElement(By.id("Country")));
			singSel.selectByVisibleText("United Kingdom");

	Select mulSel = new Select (driver.findElement(By.id("animals")));
	mulSel.selectByIndex(1);
	mulSel.selectByValue("deer");
	mulSel.selectByVisibleText("Rabbit");

}
}