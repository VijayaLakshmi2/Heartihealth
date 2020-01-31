package com.pratian.heartihealth.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pratian.heartihealth.testlisteners.TestListener;

public class HomePage {

	WebDriver driver;
	WebDriverWait wait;
	
	//Identifying the location of Application Name (HeartiHealth)
	By logo = By.id("siteName");
	By sidemenu=By.xpath("//*[@class='menu-title']");
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public Boolean navigatedToHomePage() {
		
		Boolean flag=false;
		wait= new WebDriverWait(driver,120);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(logo));
		
		//Checking whether Application Name is same as HeartiHealth
		if(driver.findElement(logo).getText().equalsIgnoreCase("HeartiHealth")){
			TestListener.reportLog("Navigated to Home Page");
			flag=true;
		}
		else
			throw new RuntimeException("Home Page is not loaded");
		return flag;
		
	}
	
	public void clickOnHealthPredictor(){
		
		wait= new WebDriverWait(driver,120);
		
		//Waiting for the side menu to be visible
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(sidemenu));
		
		//Getting list of elements in Side Menu
		List<WebElement> elements=driver.findElements(sidemenu);
		for(WebElement ele:elements){
			//Check for the element text and click if the Text is same as Health Predictor
			if(ele.getText().equalsIgnoreCase("Health Predictor"))
				ele.click();
		}
	}
	
	public void clickOnDashboard(){
		
		wait= new WebDriverWait(driver,120);
		
		//Waiting for the side menu to be visible
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(sidemenu));
		
		//Getting list of elements in Side Menu
		List<WebElement> elements=driver.findElements(sidemenu);
		for(WebElement ele:elements){
			//Check for the element text and click if the Text is same as Dashboard
			if(ele.getText().equalsIgnoreCase("Dashboard"))
				ele.click();
		}
	}
}
