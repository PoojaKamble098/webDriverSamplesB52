package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FileHandingTest {
  @Test
  public void fileUploadTest() {
	  WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		  driver.get("https://the-internet.herokuapp.com/upload");
		  WebElement addFile = driver.findElement(By.id("file-upload"));
		  String strPath = System.getProperty("user.dir") 
				  + "//screenshots//" + "1770789533210.png";
		  addFile.sendKeys(strPath);
		  
		  driver.findElement(By.id("file-submit")).click();
  }
  
  
  @Test
  public void downloadTest() {
	  WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		  driver.get("https://the-internet.herokuapp.com/download");
		  WebElement txtFile = driver.findElement(By.linkText("test-file.txt"));
		  txtFile.click();
		  
}
  @Test
  
  public void shadowDomeTest() {
	  WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		  driver.get("https://testautomationpractice.blogspot.com/");
		  WebElement shadowHost = driver.findElement(By.id("shadow_host"));
		  SearchContext cont =shadowHost.getShadowRoot();
		  cont.findElement(By.cssSelector("input[type='text']")).sendKeys("ShadowInput");
	//	  driver.findElement(By.cssSelector("input[type='text']")).sendKeys("Shadow");
	  
  }
}