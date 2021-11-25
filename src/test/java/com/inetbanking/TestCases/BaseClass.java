package com.inetbanking.TestCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.Utilities.ReadConfig;

public class BaseClass 
{
	ReadConfig readconfig=new ReadConfig();
	public String baseURL=readconfig.getApplicationURL();
	public String Email=readconfig.getEmail();
	public String Password=readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br)
	{
		
		logger=Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties");
		if(br.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
		driver=new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
			driver=new FirefoxDriver();
		}
		
		else if(br.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver",readconfig.getIEPath());
			driver=new InternetExplorerDriver();
		}
		driver.get(baseURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}
	/* @AfterClass
	public void tearDown()
	{
		driver.quit();
	} */
	
	public void captureScreen(WebDriver driver,String tname) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	public String randomstring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return (generatedstring);
	}
	public static String randomNum()
	{
		String generatedstring2=RandomStringUtils.randomNumeric(4);
		return (generatedstring2);
	}
	/*public static void selectoptionFromDropDown(WebElement ele,String value)
	{
		Select dropdown=new Select(ele);
		List<WebElement> alloptions = dropdown.getOptions();
		for(WebElement option:alloptions)
		{
			if(option.getText().equals(value))
			{
				option.click();
				break;
			}
			
		}
	} */


}
