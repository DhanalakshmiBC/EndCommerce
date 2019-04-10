package com.curiositybox.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.curiositybox.base.TestBase;

public class GiftsPage extends TestBase {
	
	Actions action;
	
	@FindBy(xpath="//ul[@class='products columns-4']/li[2]")
	WebElement product2;
	
	@FindBy(xpath="//button[@name='add-to-cart']")
	WebElement clickAddButton;
	
	@FindBy(xpath="//a[@class='et-cart-info']")
	WebElement clickOnCartIcon;
	
	@FindBy(xpath="//table[@class='shop_table shop_table_responsive cart woocommerce-cart-form__contents']//td[3]/a")
	WebElement verifyProductAdded;
	
	
	public GiftsPage()
	{
		PageFactory.initElements(driver, this);
		action=new Actions(driver);
	}
	
	public String verifyTitle()
	{
		return driver.getTitle();
	}
	
	public void clickOnProduct()
	{
		action.moveToElement(product2).build().perform();
		action.click().build().perform();
	//	product2.clear();
	}
	public void clickOnAddButton()
	{
		clickAddButton.click();
	}
	public void clickOnCartIcon()
	{
		clickOnCartIcon.click();
	}
	
	public String verifyProduct()
	{
		return verifyProductAdded.getText();
	}
	

}
