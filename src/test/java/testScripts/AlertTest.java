package testScripts;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTest {
  @Test(groups="SmokeTest")
  public void alertTest1() {
	  WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		  driver.get("https://testautomationpractice.blogspot.com/");
		  driver.findElement(By.id("alertBtn")).click();
		  
		  //Alert alert = driver.switchTo().alert();
		  //Assert.assertEquals(alert.getText(), "I am an alert box!");
		  //alert.accept();
		  
		 driver.findElement(By.id("confirmBtn")).click();
		 Alert confirm=driver.switchTo().alert();
		 System.out.println(confirm.getText());
		 Assert.assertEquals(confirm.getText(), "Press a button!");
		 confirm.dismiss();
		  
		  
		  
  }
  
  @Test
  public void PromptAlert() {
	  WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		  driver.get("https://testautomationpractice.blogspot.com/");
		 // driver.findElement(By.id("promptbtn")).click();
		  
		 // Alert alert = driver.switchTo().alert();
		  //Assert.assertEquals(alert.getText(), "I am an alert box!");
		  //alert.accept();
		  
		  //driver.findElement(By.id("confirmBtn")).click();
		  //Alert confirm=driver.switchTo().alert();
		  //System.out.println(confirm.getText());
		  //Assert.assertEquals(confirm.getText(), "Press a button!");
		  //confirm.dismiss();
		  

  
  String parentWin = driver.getWindowHandle();
  System.out.println(parentWin);
  driver.findElement(By.xpath("//button[contains(text(), 'New Tab')]")).click();
  Set<String> wins = driver.getWindowHandles();
  System.out.println("No. of windows..."+wins.size());
  System.out.println(driver.getTitle());
  for(String win: wins) {
	  System.out.println(win);
	  if(!win.equalsIgnoreCase(parentWin)) {
		  driver.switchTo().window(win);
		  System.out.println("child window..." + driver.getTitle());
	  driver.close();
	  }
  }
  driver.switchTo().window(parentWin);
  //driver.findElement(By.id("alertBtn")).click();
  //driver.quit();
  
}
}
