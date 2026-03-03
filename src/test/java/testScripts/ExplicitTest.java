package testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExplicitTest {
	public class SecureSiteHandling{
  @Test
	  
  public void ExplicitTest1() {
	  WebDriver driver = new ChromeDriver();
	  Actions action = new Actions(driver);
		driver.manage().window().maximize();
		  driver.get("https://uitestingplayground.com/ajax");
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(18));
				  driver.findElement(By.id("ajaxButton")).click();
				  		wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.cssSelector("div#content")), "Data loaded with AJAX get request."));
		 
				  		String strTxt = driver.findElement(By.cssSelector("div#content")).getText();
				  		Assert.assertEquals(strTxt,  "Data loaded with AJAX get request.");
				  				System.out.println(strTxt);
	  
  }
  
 

	}
}
