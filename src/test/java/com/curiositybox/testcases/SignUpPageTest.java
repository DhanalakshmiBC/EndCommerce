package com.curiositybox.testcases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import com.curiositybox.base.TestBase;
import com.curiositybox.pages.SignUpPage;

public class SignUpPageTest extends TestBase {
	
	SignUpPage signuppage;
	
	public SignUpPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		intialization();
		signuppage=new SignUpPage();	
	}
	
	  @Test(priority=1)
	   public void registerFormverifyTest()
	   {
		  signuppage.popupcloseclick();
		  boolean signupform = signuppage.registerFormVerify();
		  Assert.assertTrue(signupform);
	   }
	  
	  @Test(dependsOnMethods = {"registerFormverifyTest"})
	   public void registerTest()
	   {
		  signuppage.popupcloseclick();
		  signuppage.signup("dhanu", "bc", "test@gmail.com");
	   }
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	

}
