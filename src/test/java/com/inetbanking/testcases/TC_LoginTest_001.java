package com.inetbanking.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobject.LoginPage;

public class TC_LoginTest_001 extends Base
{
	@Test
	public void LoginTest() throws IOException
	{
		logger.info("URL is opened");
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(UserID);
		logger.info("Entered username");
		lp.setPassword(password);
		logger.info("Entered password");
		lp.clickSubmit();
		System.out.println("driver.getTitle()");
		
		if (driver.getTitle().equals("GTPL Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("logintest passed");
		}
		else
		{
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("login test failed");
		}
			
			
		}
	

}
