package com.curiositybox.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.curiositybox.base.TestBase;

public class HomePage extends TestBase{

	Actions action;
	WebDriverWait wait;
	
	@FindBy(xpath="//strong[text()='dhanalakshmi']")
	WebElement userName;
	
	@FindBy(xpath="//ul[@id='top-menu']/li[4]")
	WebElement menuGifts;
	
	@FindBy(xpath="//div[@id='footer-widgets']//a")
	List<WebElement> footerContent;
	
	@FindBy(tagName="a")
	List<WebElement> footerAllLink;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
		action=new Actions(driver);
		wait=new WebDriverWait(driver,30);
		
	}
	
	public String verifyTitle()
	{
		return driver.getTitle();
	}
	
	public String verifyUserName()
	{
		System.out.println(userName.getText());
		return userName.getText();
	}
	
	public void clickMenuGifts()
	{
		wait.until(ExpectedConditions.elementToBeClickable(menuGifts));
		action.moveToElement(menuGifts).click().build().perform();
		//menuGifts.click();
	}
	
	public void verifyFooterContent() throws InterruptedException {
		
		int count = footerContent.size();
		
		System.out.println("Footer links are:");
		for(int i=0; i<count;i++)
		{
			
			System.out.println(footerContent.get(i).getText());
			
		}
		
	}
	
	
	
	
}
