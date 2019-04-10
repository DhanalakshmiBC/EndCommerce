package com.curiositybox.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.curiositybox.base.TestBase;
import com.curiositybox.pages.HomePage;
import com.curiositybox.pages.LoginPage;

public class HomePageTest extends TestBase {
	
	HomePage homepage;
	LoginPage loginpage;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		intialization();
		homepage=new HomePage();
		loginpage =new LoginPage();
		loginpage.popupcloseclick();
		homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));	
	}
	
	
	@Test(priority=1)
	public void titleVerifyTest()
	{
		String title = homepage.verifyTitle();
		Assert.assertEquals(title, "My Account | Curiosity Box");
	}
	@Test(priority=2)
	public void verifyUsername()
	{
		String name = homepage.verifyUserName();
		Assert.assertEquals(name, "dhanalakshmi");
	}
	@Test(priority=3)
	public void verifyFooterLinksTest() throws InterruptedException
	{	
		homepage.verifyFooterContent();
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	
	
	
	
	
	
	

}
