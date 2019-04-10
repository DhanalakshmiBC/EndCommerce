package com.curiositybox.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.curiositybox.util.UtilTest;

public class TestBase {

	public static Properties prop;
	public static WebDriver driver;
	
	public TestBase()
	{
		try {
			prop=new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\com\\cusriositybox\\config\\config.properties");
			
			prop.load(ip);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void intialization()
	{
		
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(UtilTest.PAGELOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(UtilTest.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
		driver.get("http://build.curiosity-box.com/");
		
	}
	
	
}
