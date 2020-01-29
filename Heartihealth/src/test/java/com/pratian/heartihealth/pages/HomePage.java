package com.pratian.heartihealth.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pratian.heartihealth.testlisteners.TestListener;

public class HomePage {

	WebDriver driver;
	WebDriverWait wait;
	
	By homepage = By.id("home");
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public Boolean navigatedToHomePage() {
		Boolean flag=false;
		wait= new WebDriverWait(driver,120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(homepage));
		//System.out.println(driver.findElement(homepage).getText());
		if(driver.findElement(homepage).getText().equalsIgnoreCase("Home")){
			TestListener.reportLog("Navigated to Home Page");
			flag=true;
		}
		else
			throw new RuntimeException("Home Page is not loaded");
		return flag;
	}
	
}
