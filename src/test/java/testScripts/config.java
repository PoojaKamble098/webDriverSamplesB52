package testScripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class config {
  
  WebDriver driver;
  WebDriverWait wait;
  Properties prop;
  @BeforeTest

  @Test
  public void setup() throws IOException {
	  String path = System.getProperty("user.dir")
			  +"//src//test//resources//configFiles//config.properties";
	  FileInputStream fin = new FileInputStream(new File(path));
	  prop = new Properties();
	  prop.load(fin);
	  String strBrowser = prop.getProperty("browser");
	  if (strBrowser.equalsIgnoreCase("chrome")) {
		  driver = new ChromeDriver();
		  
	  }
	  else if(strBrowser.equalsIgnoreCase("edge")) {
		  driver = new EdgeDriver();
	  }
	  
	  wait=new WebDriverWait(driver, Duration.ofSeconds(18));
	  driver.manage().window().maximize();
	  driver.get(prop.getProperty("url"));
  }}