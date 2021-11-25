package com.inetbanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver ldriver;
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	@FindBy(id="Email")
	WebElement txtemail;
	@FindBy(id="Password")
	WebElement txtpassword;
	@FindBy(xpath="//button[@type='submit']")
	WebElement btnlogin;
	@FindBy(xpath="//*[@id=\"navbarText\"]/ul/li[3]/a")
	WebElement Logoutlink;
	public void setEmail(String email_id)
	{
		txtemail.clear();
		txtemail.sendKeys(email_id);
	}
	public void setPassword(String pwd)
	{
		txtpassword.clear();
		txtpassword.sendKeys(pwd);
	}
	public void setLogin()
	{
		btnlogin.click();
	}
	public void clickLogout()
	{
		Logoutlink.click();
	}

}
