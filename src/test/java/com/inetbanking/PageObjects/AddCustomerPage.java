package com.inetbanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage 
{
	WebDriver ldriver;
	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(how=How.XPATH, using="/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/a")
	WebElement customerslinkmenu;
	@FindBy(how=How.XPATH,using="/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/ul/li[1]/a/p")
	WebElement clickoncustomers;
	@FindBy(xpath="/html/body/div[3]/div[1]/form[1]/div/div/a")
	WebElement btnaddnewcustomer;
	@FindBy(id="Email")
	WebElement txtemail;
	@FindBy(xpath="//input[@id='Password']")
	WebElement txtpassword;
	@FindBy(name="FirstName")
	WebElement txtfirstname;
	@FindBy(name="LastName")
	WebElement txtlastname;
	@FindBy(id="Gender_Male")
	WebElement rdmalegender;
	@FindBy(xpath="//input[@id='Gender_Female']")
	WebElement rdfemalegender;
	@FindBy(xpath="//input[@id='DateOfBirth']")
	WebElement txtdateofbirth;
	@FindBy(id="Company")
	WebElement txtcompany;
	@FindBy(id="IsTaxExempt")
	WebElement chbxistaxexempt;
	@FindBy(xpath="//body/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/nop-cards[1]/nop-card[1]/div[1]/div[2]/div[9]/div[2]/div[1]/div[1]/div[1]/div[1]")
	WebElement txtnewsletter;
	@FindBy(xpath="//li[contains(text(),'Your store name')]")
	WebElement lstitemyourstorename;
	@FindBy(xpath="//li[contains(text(),'Test store 2')]")
	WebElement lstitemTeststore2;
	@FindBy(xpath="//body/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/nop-cards[1]/nop-card[1]/div[1]/div[2]/div[10]/div[2]/div[1]/div[1]/div[1]/div[1]")
	WebElement txtcustomerroles;
	@FindBy(xpath="//li[contains(text(),'Administrators')]")
	WebElement lstitemAdministrators;
	@FindBy(xpath="//li[contains(text(),'Forum Moderators')]")
	WebElement lstitemForumModerators;
	@FindBy(xpath="//li[contains(text(),'Registered')]")
	WebElement lstitemRegistered;
	@FindBy(xpath="//*[@id='SelectedCustomerRoleIds_taglist']/li/span[2]")
	WebElement deleteSelectedRegistered;
	@FindBy(xpath="//li[contains(text(),'Guests')]")
	WebElement lstitemGuests;
	@FindBy(xpath="//li[contains(text(),'Vendors')]")
	WebElement lstitemVendors;
	@FindBy(xpath="//select[@id='VendorId']")
	WebElement manageofvendor;
	@FindBy(id="Active")
	WebElement chbxactive;
	@FindBy(name="AdminComment")
	WebElement admincomment;
	@FindBy(name="save")
	WebElement btnSave;
	public void cilckCustomerMenulink()
	{
		customerslinkmenu.click();
		
	}
	public void clickOnCustomers()
	{
		clickoncustomers.click();
	}
	public void clickOnAddNewCutomer()
	{
		btnaddnewcustomer.click();
		
	}
	public void setCustomerEmail(String custemail_id)
	{
		txtemail.sendKeys(custemail_id);
	}
	public void setPassword(String password)
	{
		txtpassword.sendKeys(password);
	}
	public void setFirstname(String firstname)
	{
		txtfirstname.sendKeys(firstname);
	}
	public void setLastname(String lastname)
	{
		txtlastname.sendKeys(lastname);
	}
	
	public void setGender(String gender)
	{
		if(gender=="Male")
		{
			rdmalegender.click();
		}
		else if(gender=="Female")
		{
			rdfemalegender.click();
		}
	}
	public void setDateofBirth(String dob)
	{
		
		txtdateofbirth.sendKeys(dob);
	}
	public void setCompany(String company)
	{
		txtcompany.sendKeys(company);
	}
	public void setIstaxexempt()
	
	{
		chbxistaxexempt.click();
	}
	public void selectNewsRole(String newsrole)
	{
		txtnewsletter.click();
		
		/* List<WebElement> newsroleoptions=ldriver.findElements(By.xpath("//*[contains(@id,'SelectedNewsletterSubscriptionStoreIds')]//option"));
		for(int i=0;i<=newsroleoptions.size();i++)
		{
		   if(newsroleoptions.get(i).getText().contains(newsrole))
		   {
			   newsroleoptions.get(i).click();
		   }
		
			
		} */
	
		WebElement listitem = null;
		if(newsrole=="Your store name")
		{
	
			listitem=lstitemyourstorename;
		}
		else if(newsrole=="Test store 2")
		{
			listitem=lstitemTeststore2;
		}
		listitem.click(); 
		
}
		
	public void selectCusomerRole(String role) throws InterruptedException
	{
		txtcustomerroles.click();
		WebElement listitem = null;
		if(role=="Administrators")
		{
			listitem=lstitemAdministrators;
		}
		else if(role=="Forum Moderators")
		{
			listitem=lstitemForumModerators;
		}
		else if(role=="Registered")
		{
			listitem=lstitemRegistered;
			
		}
		else if(role=="Guests")
		{
			//Thread.sleep(3000);
			deleteSelectedRegistered.click();
			listitem=lstitemGuests;
		}
		else if(role=="Vendors")
		{
			listitem=lstitemVendors;
		}
		listitem.click();
			
	}
	
	public void selectManagerofvendor(String value)
	{
		Select drop=new Select(manageofvendor);
		drop.selectByVisibleText(value);
	}
	
	public void selectActiveChbx()
	{
		chbxactive.click();
	}
	public void addAdmincomment(String admincomments)
	{
		admincomment.sendKeys(admincomments);
	}
	public void clickOnSave()
	{
		btnSave.click();
		
	}
}
