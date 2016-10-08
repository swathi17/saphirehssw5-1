package com.saphirehssw5.test.functional;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.saphirehssw5.generics.CreateDriver;
import com.saphirehssw5.generics.GetData;
import com.saphirehssw5.ui.HomePage;
import com.saphirehssw5.ui.LoginPage;

public class LoginTestUS_01 
{
	// Verify Login Page
	
	WebDriver driver = CreateDriver.getDriver();
	LoginPage login = new LoginPage(driver);
	HomePage home = new HomePage(driver);
	
	@Test
	public void testLoginTC_01()
	{
		// Verify Placeholder text on Login Page
		
		String unPlaceHolder = login.getUsername().getAttribute("placeholder");
		String pwdPlaceHolder = login.getForgotPwd().getAttribute("placeholder");
		Assert.assertEquals(unPlaceHolder, "Username");
		Assert.assertEquals(pwdPlaceHolder, "Password");
	}
	@Test
	public void testLoginTC_02()
	{
		// Verify Forgot Password Link
		login.getForgotPwd().click();
		String actualNoticText = login.getForgetPwdNoticeText().getText();
		String expectedNoticeText = "Please enter email address or username below to get password reset instructions.";
		Assert.assertEquals(actualNoticText, expectedNoticeText);	
	}
	@Test
	public void testLoginTC_03()
	{
		// Verify Login with Valid Credentials
		String un = GetData.fromExcel("tdata", "US_01", 1, 0);
		String pwd = GetData.fromExcel("tdata", "US_01", 1, 1);
		// Enter Username
		login.getUsername().sendKeys(un);
		// Enter Password
		login.getPassword().sendKeys(pwd);
		// Click on Login Button
		login.getLoginBtn().click();
		// Verify Home page
		String actual = home.getLogoutLink().getText();
		Assert.assertEquals(actual, "Logout");
		// Click Logout on HomePage
		home.getLogoutLink().click();
		
	}
}
