package com.curiositybox.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.curiositybox.base.TestBase;

public class SignUpPage extends TestBase{
	
	WebDriverWait wait;
	Actions action;
	
	@FindBy(xpath="//a[@title='Close']")
	WebElement popupClose;
	
	@FindBy(xpath="//form[@class='woocommerce-form woocommerce-form-register register']")
	WebElement registerForm;
	
	@FindBy(name="billing_first_name")
	WebElement firstNameField;
	
	@FindBy(name="billing_last_name")
	WebElement lastNameField;
	
	@FindBy(name="email")
	WebElement emailField;
	
	@FindBy(name="register")
	WebElement registerButton;
	
	@FindBy(xpath="//a[text()='JOIN US']")
	WebElement joinus;
	
	public SignUpPage()
	{
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver,30);
		action=new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(joinus));
	}
	
	public void popupcloseclick()
	{
		popupClose.click();
	}
	
	public boolean registerFormVerify()
	{
		joinus.click();	
		return registerForm.isDisplayed();
	}
	
	public void signup(String fn,String ln,String em)
	{
		joinus.click();	
		
		action.moveToElement(firstNameField).click().sendKeys(fn).build().perform();
		action.moveToElement(lastNameField).click().sendKeys(ln).build().perform();
		action.moveToElement(emailField).click().sendKeys(em).build().perform();
		action.moveToElement(registerButton).click().build().perform();
		
	//	firstNameField.sendKeys(fn);
	//	lastNameField.sendKeys(ln);
	//	emailField.sendKeys(em);
	//	registerButton.click();
		
	}
}
