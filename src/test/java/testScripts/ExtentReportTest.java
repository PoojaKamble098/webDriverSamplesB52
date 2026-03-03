package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import commonUtils.Utility;

public class ExtentReportTest {
	WebDriver driver;
	ExtentReports extentReports;
	ExtentSparkReporter spark;
	ExtentTest extentTest;
	
	@BeforeMethod
	
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
	}
	
	@BeforeTest
	
	public void setupExtent()
	{
		extentReports =new ExtentReports();
		spark = new ExtentSparkReporter("test-output/SparkReport.html");
		extentReports.attachReporter(spark);
	}
	
  @Test(retryAnalyzer = MyRetry.class)
  public void ChkBoxdrop1() {
	  
	  //WebDriver driver = new ChromeDriver();
		// driver.manage().window().maximize();
		  //driver.get("https://testautomationpractice.blogspot.com/");
	  extentTest = extentReports.createTest("Radio Button Test");
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

@AfterMethod
public void teardown(ITestResult result)
{
	if(result.getStatus() == result.FAILURE) {
		extentTest.log(Status.FAIL, result.getThrowable().getMessage());
		String path=Utility.getScreenshotPathString(driver);
		extentTest.fail(MediaEntityBuilder.createScreenCaptureFromPath(path).build());
	}
}

@AfterTest
public void finishExtent() {
	extentReports.flush();
}

}