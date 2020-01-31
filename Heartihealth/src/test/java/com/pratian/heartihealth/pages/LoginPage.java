package com.pratian.heartihealth.pages;

import java.awt.HeadlessException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pratian.heartihealth.testlisteners.TestListener;


public class LoginPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	private final String siteUrl = "http://172.30.12.171:8081/";
	private final String expectedUrl = "http://172.30.12.171:8081/login";
	private final String expectedTitle = "Hearti Health";
	private final String signError = "Login Page is not displayed";
	
	//Identifying the location of Email TextBox 
	private By username = By.id("inputEmail");
	private By password = By.id("inputPassword");
	private By loginbtn = By.id("loginBtn");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Open the application
	 *
	 * @return the home page
	 */
	public void open() {
		
		driver.get(siteUrl);
		
		//checking whether URL and Title of webpage is same as expectedURL and expectedTitle
		if (!driver.getCurrentUrl().contains(expectedUrl) || !driver.getTitle().contains(expectedTitle)) {
			throw new HeadlessException(signError);
		}
		TestListener.reportLog("Navigated to Login Page");
		
	}

	public void  LoginIntoApplication(String Username, String Password ) {
		
		wait=new WebDriverWait(driver,60);
		
		//waiting for username input box is clickable
		wait.until(ExpectedConditions.elementToBeClickable(username)).click();
		//clearing the data from username textbox
		driver.findElement(username).clear();
		//entering data in username textbox
		driver.findElement(username).sendKeys(Username);
		
		driver.findElement(password).click();
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(Password);
		
		driver.findElement(loginbtn).click();
		
	}
}