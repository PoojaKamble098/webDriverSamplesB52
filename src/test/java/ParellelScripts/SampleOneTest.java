package ParellelScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SampleOneTest {
	WebDriver driver;
  @Test
  public void testOne() {
	  driver = new ChromeDriver();
	  long id = Thread.currentThread().getId();
	  System.out.println("Test11 in SampleOne..."+id);
	  
	  }
  
  @Test
  public void testTwo()
  {
	  driver = new ChromeDriver();
	  long id = Thread.currentThread().getId();
	  System.out.println("Test12 in SampleOne..."+id);
	  
  }
  @Test
  public void testThree()
  {
	  driver = new ChromeDriver();
	  long id = Thread.currentThread().getId();
	  System.out.println("Test13 in SampleOne..."+id);
}
  
}