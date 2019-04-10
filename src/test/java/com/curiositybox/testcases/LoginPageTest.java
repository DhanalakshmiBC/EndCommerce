package com.curiositybox.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


import org.testng.annotations.BeforeMethod;


import com.curiositybox.base.TestBase;
import com.curiositybox.pages.HomePage;
import com.curiositybox.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	
   public LoginPageTest()
   {
	   super();
   }
   
   @BeforeMethod
   public void setup()
   {
	   intialization();
	   loginpage=new LoginPage();
   }
   
   @Test(priority=1)
   public void verifyloginpageTest()
   {
	   loginpage.popupcloseclick();
	   boolean logo = loginpage.logoverify(); 
	   Assert.assertTrue(logo);
   }
   
   @Test(priority=2)
   public void urlverifyTest()
   {
	  String url = loginpage.urlVerify();
	  Assert.assertEquals("http://build.curiosity-box.com/", url);  
   }
   
   @Test(priority=3)
   public void loginFormverifyTest()
   {
	   loginpage.popupcloseclick();
	   boolean form = loginpage.loginFormverify();
	   Assert.assertTrue(form);
   }
 
   @Test(dependsOnMethods = {"loginFormverifyTest"})
   public void loginTest()
   { 
	   try
	   {
		   loginpage.popupcloseclick();
		   homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		   Assert.assertEquals(homepage.verifyTitle(), "My Account | Curiosity Box"); 
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
	   }
	   
   }
   
  
   @AfterMethod
   public void tearDown()
   {
	   driver.quit();
   }
   

}
