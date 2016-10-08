package com.saphirehssw5.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage 
{
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public WebElement getUsername()
	{
		WebElement un = driver.findElement(By.id("username"));
		return un;
	}
	public WebElement getPassword()
	{
		return driver.findElement(By.name("pwd"));
	}
	public WebElement getLoginBtn()
	{
		return driver.findElement(By.id("loginButton"));
	}
	public WebElement getForgotPwd() 
	{
		return driver.findElement(By.id("toPasswordRecoveryPageLink"));
	}
	public WebElement getForgetPwdNoticeText()
	{
		return driver.findElement(By.xpath("//td[@id='tooltipContainer']/div"));
	}
	public WebElement getRturnLoginPageLink()
	{
		return driver.findElement(By.id("toLoginPageLink"));
	}
}
