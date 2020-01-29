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
	
	private final String siteUrl = "https://uatint-adjudication-kalos.mirrahealthcare.com/";
	private final String expectedUrl = "https://uatint-adjudication-kalos.mirrahealthcare.com/";
	private final String expectedTitle = "MIRRA - LOGIN";
	private final String signError = "Login Page is not displayed";
	private By username = By.id("userId");
	private By password = By.id("Password");
	private By loginbtn = By.id("btnSubmit");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Open the application
	 *
	 * @return the home page
	 */
	public LoginPage open() {
		driver.get(siteUrl);

		if (!driver.getCurrentUrl().contains(expectedUrl) || !driver.getTitle().contains(expectedTitle)) {
			throw new HeadlessException(signError);
		}
		TestListener.reportLog("Navigated to Login Page");
		return this;
	}

	public void  LoginIntoApplication(String Username, String Password ) {
		wait=new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(username)).click();
		driver.findElement(username).sendKeys(Username);
		wait.until(ExpectedConditions.elementToBeClickable(password)).click();
		driver.findElement(password).sendKeys(Password);
		wait.until(ExpectedConditions.elementToBeClickable(loginbtn)).click();
		
		
		
		
		

		
	}
}