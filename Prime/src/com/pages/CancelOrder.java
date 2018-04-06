package com.pages;

import java.util.concurrent.TimeUnit;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CancelOrder {
WebDriver driver;
By orderNo = By.xpath("//input[@id='loginOrderId']");
By lastName = By.xpath("//*[@id='loginLastName']");
By submit = By.xpath("//button[@id='loginSubmit']");
By cancelOrder = By.xpath("//*[@class='btn cancel']" );
By yesCancelOrder = By.xpath("//button[@class='btn submit secondary']");
By cancelConfirmation =By.xpath("//*[@class='main_heading']");

public static String cancelMsg;

public CancelOrder(WebDriver driver)
{
	this.driver = driver;		
}
public void orderNo(String orderId)
{
	driver.findElement(orderNo).sendKeys(orderId);
	
}
public void lastName(String lastname)
{
	driver.findElement(lastName).sendKeys(lastname);
}
public void clickSubmit()
{
	
	driver.findElement(submit).click();
}
public void cancelMyOrder()
{
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	driver.findElement(cancelOrder).click();
}
public void yesCancelMyOrder()
{
	driver.findElement(yesCancelOrder).click();
}
public void orderCancelled()
{
	cancelMsg = driver.findElement(cancelConfirmation).getText();
	//System.out.println(cancelMsg);
}
}
