package com.curiositybox.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.curiositybox.base.TestBase;
import com.curiositybox.pages.GiftsPage;
import com.curiositybox.pages.HomePage;
import com.curiositybox.pages.LoginPage;

public class GiftsPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	GiftsPage giftspage;
	
	public GiftsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		intialization();
		loginpage=new LoginPage();
		homepage=new HomePage();
		giftspage=new GiftsPage();
		loginpage.popupcloseclick();
		homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		homepage.clickMenuGifts();
	}
	
	@Test(priority=1)
	public void titleVerifyTest()
	{
		String title = giftspage.verifyTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Gift | Curiosity Box");
	}
	@Test(priority=2)
	public void VerifyProductTest()
	{
		giftspage.clickOnProduct();
		giftspage.clickOnAddButton();
		giftspage.clickOnCartIcon();
		
		String product = giftspage.verifyProduct();
        Assert.assertEquals(product, "Lab Coat");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
