package com.pratian.heartihealth.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	
		public WebDriver driver;
		private final String chromeDriverPath = "./src/main/resources/drivers/chromedriver.exe";
		
		
		@BeforeMethod(alwaysRun = true)
		public void setUp() {
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			
			//Opening Chrome Driver
			driver = new ChromeDriver();
			//Maximizing Chrome Driver
			driver.manage().window().maximize();
		}
		
	
	 @AfterMethod 
	 public void teardown() { 
	  
	 // closing Chrome Driver
	  driver.close();
	  
	 }
	 
	}



