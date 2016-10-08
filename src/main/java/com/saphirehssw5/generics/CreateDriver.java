package com.saphirehssw5.generics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateDriver
{
	public static WebDriver getDriver()
	{
		WebDriver driver = null;
		String browser_name = GetData.fromProperties("configdata", "browser");
		String url = GetData.fromProperties("configdata", "url");
		if(browser_name.equalsIgnoreCase("ff"))
		{
			driver = new FirefoxDriver();
		}
		else if(browser_name.equalsIgnoreCase("gc"))
		{
			System.setProperty("webdriver.chrome.driver", "./browser_exe/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else 
		{
			System.out.println("Not Valid browser");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
		return driver;
	}
}
