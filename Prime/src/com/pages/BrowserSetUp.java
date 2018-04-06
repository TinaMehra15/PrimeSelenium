package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserSetUp {
public static WebDriver driver;


public void setup()
{
	System.setProperty("webdriver.chrome.driver","/Users/tina.mehra/Documents/chromedriver");
	driver= new ChromeDriver();
	String appURL = "https://web.stg.olympusdev.js-devops.co.uk/";
	driver.get(appURL);
}
}
