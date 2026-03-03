package testScripts;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class SwagTest {
	WebDriver driver;
	
	@BeforeMethod
	
	public void setup() {
		driver = new ChromeDriver();
	}
  @Test(dataProvider = "loginData")
  public void Saucedemo(String strUser, String strPwd) {
	
	  
	  //WebDriver driver = new ChromeDriver();
		// driver.manage().window().maximize();
		  driver.get("https://www.saucedemo.com/");
		  WebElement inpUser = driver.findElement(By.id("user-name"));
		//  inpUser.sendKeys("standard_user");
		  inpUser.sendKeys(strUser);
		  driver.findElement(By.name("password")).sendKeys(strPwd);
		  driver.findElement(By.id("login-button")).click();
		  WebElement header = driver.findElement(By.cssSelector("span.title"));
		  Assert.assertTrue(header.isDisplayed());
		  
		  	  
  }
  
  @DataProvider(name="loginData")
  public Object[][] getData() throws CsvValidationException, IOException {
	  String path = System.getProperty("user.dir")
			  + "//src//test//resources//TestData/loginData.csv";
	  CSVReader reader = new CSVReader(new FileReader(path));
	  
	  String cols[];
	  ArrayList<Object> dataList = new ArrayList<Object>();
	  while ((cols = reader.readNext())  !=null) {
		  Object record[] = {cols[0], cols[1] };
		  dataList.add(record);
		  }
		  reader.close();
		  return dataList.toArray(new Object[dataList.size()][]);
	  }
  }
  

