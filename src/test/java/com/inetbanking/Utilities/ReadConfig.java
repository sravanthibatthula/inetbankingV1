package com.inetbanking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig
{
	Properties prop;
	public ReadConfig()
	{
		File src=new File("./Configuration/config.properties");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(src);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception is" +e.getMessage());
		}
		prop=new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception is" +e.getMessage());
		}
	}
	
	public String getApplicationURL()
	{
		String url=prop.getProperty("baseURL");
		return url;
	}
	public String getEmail()
	{
		String email=prop.getProperty("Email");
		return email;
	}
	public String getPassword()
	{
		String password=prop.getProperty("Password");
		return password;
	}
	public String getChromePath()
	{
		String chromepath =prop.getProperty("chromepath");
		return chromepath;
	}
	public String getFirefoxPath()
	{
		String Firefoxpath =prop.getProperty("firefoxpath");
		return Firefoxpath;
	}
	public String getIEPath()
	{
		String IEpath =prop.getProperty("iepath");
		return IEpath;
	}
	

}
