package testScripts;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JsExecutor {
  @Test
  public void jsExecutorTest() {
	  WebDriver driver = new ChromeDriver();
	  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.get("https://testautomationpractice.blogspot.com/");
		JavascriptExecutor js =(JavascriptExecutor)driver;
		
		js.executeScript("window.scrollTo(10, document.body.scrollHeight)");
		String strTitle = (String)js.executeScript("return document.title");
		System.out.println(strTitle);
  }
}
