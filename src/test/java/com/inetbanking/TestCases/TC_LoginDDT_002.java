package com.inetbanking.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.PageObjects.LoginPage;
import com.inetbanking.Utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass
{
	@Test(dataProvider="LoginData")
	public void loginDDT(String email,String Pwd)
	{
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		logger.info("Email provided");
		lp.setPassword(Pwd);
		logger.info("Password provided");
		lp.setLogin();
		if(driver.getTitle().equals("Dashboard / nopCommerce administration"))
		{
			Assert.assertTrue(true);
			logger.info("Login passed");
			lp.clickLogout();
			driver.switchTo().defaultContent();
		}
		else
		{
			Assert.assertTrue(false);
			logger.warn("Login Failed");
		}
		/*if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();//this command will switch to main page url
			Assert.assertTrue(false);
			logger.warn("Login failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login Passed");
			lp.clickLogout();
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();
			
			
		}*/
		
	}
	
	//user defined method created to check alert is present or not
	/*public boolean isAlertPresent()
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}*/
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"\\src\\test\\java\\com\\inetbanking\\TestData\\loginData.xlsx";
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colnum=XLUtils.getCellCount(path, "Sheet1", 1);
		String logindata[][]=new String[rownum][colnum];
		//to get the data we need for loop
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colnum;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i, j);//1 0
			}
			
		}
		return logindata;
		
		
	}
}
	
	

