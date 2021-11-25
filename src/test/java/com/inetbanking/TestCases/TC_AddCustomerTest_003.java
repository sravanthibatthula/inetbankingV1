package com.inetbanking.TestCases;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.PageObjects.AddCustomerPage;
import com.inetbanking.PageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass 
{
	@Test
	public void AddCustomerTest() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(Email);
		lp.setPassword(Password);
		lp.setLogin();
		Thread.sleep(3000);
		AddCustomerPage addcust=new AddCustomerPage(driver);
		addcust.cilckCustomerMenulink();
		addcust.clickOnCustomers();
		addcust.clickOnAddNewCutomer();
		String email=randomstring()+"@gmail.com";
		addcust.setCustomerEmail(email);
		addcust.setPassword("Sai@1234");
		addcust.setFirstname("sravanthi");
		addcust.setLastname("Batthula");
		addcust.setGender("Female");
		addcust.setDateofBirth("10/28/2021");
		addcust.setCompany("teknol");
		addcust.setIstaxexempt();
		addcust.selectNewsRole("Test store 2");
		addcust.selectCusomerRole("Administrators");
		addcust.selectManagerofvendor("Not a vendor");
		addcust.selectActiveChbx();
		addcust.addAdmincomment("this is for testing");
		Thread.sleep(3000);
		addcust.clickOnSave();
		String expected_title="Customers / nopCommerce administration";
		System.out.println();
		if(driver.getTitle().equals(expected_title))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		} 
		/* String message=driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissable']")).getText();
		System.out.println(message);
		if(message.equals("The new customer has been added successfully."))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		} */
	
	}
}


	
	