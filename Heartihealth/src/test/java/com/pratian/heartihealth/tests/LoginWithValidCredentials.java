package com.pratian.heartihealth.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pratian.heartihealth.pages.HomePage;
import com.pratian.heartihealth.pages.LoginPage;
import com.pratian.heartihealth.utils.Excel;
import com.pratian.heartihealth.utils.property.PropertyFile;

@Listeners(com.pratian.heartihealth.testlisteners.TestListener.class)
public class LoginWithValidCredentials extends BaseTest {
	
	static PropertyFile propertyfile=new PropertyFile();
	
	// getting Excel File Path from property file
	static String path=propertyfile.get("ExcelPathForTestData");
	static Excel excel= new Excel(path);
	
	Map<String, String> map=new HashMap<String, String>();
	
	@DataProvider(name = "validlogin")
	public static Object[][] Categories() {
		Object[][] categories=excel.readData("LoginWithValiddata");
		return categories;
	    	  
	}
	
	@Test(dataProvider = "validlogin")
	public void CheckingForLogo(Map<String, String> validData) {
		
		Map<String, String> map=new HashMap<String, String>();
	    map=validData;
	    
		LoginPage loginPage=new LoginPage(driver);
		
		//Opening URL
		loginPage.open();
		
		//Logging in into application
		loginPage.LoginIntoApplication(map.get("Username"), map.get("Password"));
		
		
		HomePage homePage = new HomePage(driver);
		
		//Checking whether Home Page is Loaded or not
		Assert.assertTrue(homePage.navigatedToHomePage());
		
	}
	
	

}
