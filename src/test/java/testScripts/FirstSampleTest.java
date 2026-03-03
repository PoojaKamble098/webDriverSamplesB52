package testScripts;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class FirstSampleTest {
  @Test(groups="SmokeTest")
  public void loginTest() {
	  Map<String, Object> prefs = new HashMap();
	  prefs.put("credentials_enable_service", false);
	  prefs.put("profile.password_manager_enabled", false);
	  prefs.put("profile.password_manager_leak_detection", false);
	  
	  // Create Chromeoptions object
	  
	  //ChromeOptions options = new ChromeOptions();
	 // options.setExperimentalOption("prefs", prefs);
			  
	WebDriver driver = new ChromeDriver();
	 driver.manage().window().maximize();
	  driver.get("https://the-internet.herokuapp.com/login");
	  WebElement inpUser = driver.findElement(By.id("username"));
	  inpUser.sendKeys("tomsmith");
	  driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
	  driver.findElement(By.className("radius")).click();
	  
	  driver.navigate().back();
	  System.out.println("Current URL ..."+driver.getCurrentUrl());
	  
	  System.out.println("Title ..."+driver.getTitle());
	  Assert.assertEquals(driver.getTitle(), "The Internet");
	  
	  driver.navigate().forward();
  }
}
