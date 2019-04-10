package com.curiositybox.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.curiositybox.base.TestBase;

public class LoginPage extends TestBase {
	
	WebDriverWait wait;
	Actions action;
	
	@FindBy(id="logo")
	WebElement logo;
	
	@FindBy(xpath="//a[@title='Close']")
	WebElement popupClose;
	
	@FindBy(xpath="//form[@class='woocommerce-form woocommerce-form-login login']")
	WebElement loginForm;
	
	@FindBy(xpath="//a[text()='JOIN US']")
	WebElement joinus;
	
	@FindBy(id="username")
	WebElement loginUsername;
	
	@FindBy(id="password")
	WebElement loginPassword;
	
	@FindBy(name="login")
	WebElement loginButton;
	
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
		wait =new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(popupClose));
		action=new Actions(driver);
	}
	
	public void popupcloseclick()
	{
		popupClose.click();
	}
	
	public boolean logoverify()
	{
		return logo.isDisplayed();
	}
	
	public String urlVerify()
	{
		return driver.getCurrentUrl();
	}
	
	public boolean loginFormverify()
	{
		joinus.click();
		return loginForm.isDisplayed();
	}
	
	public HomePage login(String un,String pw)
	{
		joinus.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(loginUsername));
		
	    action.moveToElement(loginUsername).click().sendKeys(un).build().perform();
		action.moveToElement(loginPassword).click().sendKeys(pw).build().perform();
		action.moveToElement(loginButton).click().build().perform();
		
	//    loginUsername.sendKeys(un);
	//	loginPassword.sendKeys(pw);
	//	loginButton.click();
		
		return new HomePage();
		
	}
	
	
	
	

}
