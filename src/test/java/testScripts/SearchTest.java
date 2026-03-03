package testScripts;



import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.script.RegExpValue;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SearchTest {
	public final String expValue = "JavaScript";
  @Test
 
  public void searchtest1() throws InterruptedException{
	  
	  WebDriver driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// driver.manage().window().maximize();
		  driver.get("https://jqueryui.com/autocomplete/");
		  WebElement frame1 = driver.findElement(By.cssSelector(".demo-frame"));
		  driver.switchTo().frame(frame1);
		// action.scrollByAmount(10, 900).perform();
		 // driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		  WebElement inpAge = driver.findElement(By.cssSelector("#tags"));
		 // inpAge.click();
		  inpAge.sendKeys("as");
		 Thread.sleep(2000);
		 List<WebElement> items = driver.findElements(By.cssSelector("ul#ui-id-1 > li"));
		 System.out.println("Number of matching items..."+items.size());
		 for(WebElement item : items) {
		
			 System.out.println(item.getText());
			 if(item.getText().equalsIgnoreCase(expValue)) {
				 item.click();
				 break;
			 }
		 }
		  
  }
}
