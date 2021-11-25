package com.inetbanking.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.PageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass
{
	@Test
	public void LoginTest() throws InterruptedException, IOException
	{
		
		logger.info("URL is opened");
		LoginPage loginPage=new LoginPage(driver);
		loginPage.setEmail(Email);
		logger.info("Enter Email");
		loginPage.setPassword(Password);
		logger.info("Enter Password");
		Thread.sleep(3000);
		loginPage.setLogin();
		if(driver.getTitle().equals("Dashboard / nopCommerce administration"))
		{
			Assert.assertTrue(true);
			logger.info("Login Test passed");
			
		}
		else
		{
			captureScreen(driver,"LoginTest");
			Assert.assertTrue(false);
			logger.info("Login Test Failed");		
		}
		
	}

}
