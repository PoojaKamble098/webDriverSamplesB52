package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CaseStudyArticleTest {
  @Test
  public void caseStudy() {
	  WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		  driver.get("https://conduit-realworld-example-app.fly.dev/#/");
		  WebElement inpUser = driver.findElement(By.xpath("username"));
		  inpUser.sendKeys("tomsmith");
		  driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
		  driver.findElement(By.className("radius")).click();
  }
}
