package com.pages;

//import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderSummaryVerification {
	
public static WebDriver driver;
//	WebDriver driver;
static By orderSummary = By.xpath("//span[@class = 'checkout-sidebar__section-item']");
//By orderSummary = By.xpath("//*[@id='maincontent']/descendant::span[@class = 'checkout-sidebar__section-item']");
static By storeAddName = (By.xpath("//*[@class='address__name']"));

public static String storename;
public OrderSummaryVerification(WebDriver driver)
{
	OrderSummaryVerification.driver = driver;
}
public static String[] outArray;

public  static String[] orderSummaryDetails()
//public  void orderSummaryDetails()
{
	//List<WebElement> inList = driver.findElements(By.xpath("//span[@class = 'checkout-sidebar__section-item']"));
	List<WebElement> inList = driver.findElements(orderSummary);
	storename = driver.findElement(storeAddName).getText();
	String[] outArray = new String[inList.size()];  // instantiate Array
	//System.out.println(inList.size());
	for (int i = 0; i < inList.size(); i++) 
	{
		outArray[i] = inList.get(i).getText();

	System.out.println("In the Order Summary Verification values are :" + outArray[i]);
  }

	return outArray;
}

}
