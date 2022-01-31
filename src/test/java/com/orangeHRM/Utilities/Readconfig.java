package com.orangeHRM.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Readconfig {
	Properties pro = new Properties();

	public Readconfig() {
		File src = new File("./Configuration/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro.load(fis);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public String getBaseURL()
	{
		String baseURL=pro.getProperty("baseURL");
				return baseURL;	
	}
	public String getUserName()
	{
		String username=pro.getProperty("username");
				return username;	
	}
	public String getPassword()
	{
		String password=pro.getProperty("password");
				return password;	
	}
	public String getChromePath()
	{
		String chromepath=pro.getProperty("chromepath");
				return chromepath;	
	}
}
