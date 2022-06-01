
package com.inetbanking.testcases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobject.AddCustomerPage;
import com.inetbanking.pageobject.LoginPage;

public class TC_AddCustomerTest_003 extends Base
{

	@Test
	public void NewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(UserID);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Passsword is provided");
		lp.clickSubmit();

		Thread.sleep(3000);

		AddCustomerPage addcust=new AddCustomerPage(driver);

		addcust.clickNewCustomer();

		logger.info("providing customer details....");

		addcust.custName("simcy");	
		addcust.custgender("female");
		addcust.custdob("25","11","1989");
		Thread.sleep(5000);
		addcust.custaddress("INDIA");
		addcust.custcity("melbourne");
		addcust.custstate("victoria");
		addcust.custpinno("3034");
		addcust.custtelephoneno("27465824");

		String email=randomstring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();

		Thread.sleep(3000);

		logger.info("validation started....");

		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");

		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");

		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}

	}
public String randomstring()
{
String generatedstring=RandomStringUtils.randomAlphabetic(8);
return(generatedstring);

}
public  static String randomNum()
{
String generatedstring2=RandomStringUtils.randomNumeric(4);
return(generatedstring2);

}

}
