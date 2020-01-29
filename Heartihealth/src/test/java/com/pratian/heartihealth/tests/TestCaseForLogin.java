package com.pratian.heartihealth.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pratian.heartihealth.pages.HomePage;
import com.pratian.heartihealth.pages.LoginPage;

@Listeners(com.pratian.heartihealth.testlisteners.TestListener.class)
public class TestCaseForLogin extends BaseClass {
	
	@Test(priority = 1)
	public void LoginCheck() {
		LoginPage loginPage=new LoginPage(driver);
		
		loginPage.open();
		
		loginPage.LoginIntoApplication("j_lavanya@ahcpllc.com", "kljl@123");
		HomePage homePage = new HomePage(driver);
		//homePage.navigatedToHomePage();
		
		Assert.assertTrue(homePage.navigatedToHomePage());
		
	}

}
