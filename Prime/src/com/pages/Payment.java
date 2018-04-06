package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Payment {
//Define the WebDriver object
WebDriver driver;
By cardNo = By.name("cardNumber");
By expiryMonth= By.name("expiryMonth");
By expiryYear= By.name("expiryYear");
By csc =By.name("csc");
By submitButton = By.name("btnSubmit");
By passwordtxt =By.id("acsPassword");
//initialize the WebDriver
public Payment(WebDriver driver)
{
	this.driver = driver;
}
public void PaymentDetails(String cardno,int monthindex,int yearindex, String cscno)
{
	driver.switchTo().frame("payment"); 
	driver.findElement(cardNo).sendKeys(cardno);
	
	Select expirymonthdropdown = new Select(driver.findElement(expiryMonth));
	expirymonthdropdown.selectByIndex(monthindex);
	
	Select expiryyeardropdown = new Select(driver.findElement(expiryYear));
	expiryyeardropdown.selectByIndex(yearindex);
	
	driver.findElement(csc).sendKeys(cscno);
}
public void paynow()
{
	driver.findElement(submitButton).click();
	driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
}

//3d secure card
public void SecurePayment()
{	
	driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	//System.out.println(driver.getCurrentUrl());
	//driver.switchTo().frame("payment"); 
//	 driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='payment']")));
	 
	//driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='CompanyLogo']"))).click();
	driver.findElement(By.xpath("//*[@id='CompanyLogo']")).click();
	//driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
//	driver.findElement(passwordtxt).sendKeys("password");
//	driver.findElement(submitButton).click();
}
}
