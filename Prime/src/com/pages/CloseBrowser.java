package com.pages;
import org.openqa.selenium.WebDriver;

public class CloseBrowser {
WebDriver driver;
//initialize the WebDriver
public CloseBrowser(WebDriver driver)
{
		this.driver = driver;
}
//Close the Browser
public void QuitBrowser()
{
		driver.close();
}
}
