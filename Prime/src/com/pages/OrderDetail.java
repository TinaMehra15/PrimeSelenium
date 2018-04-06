package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderDetail {

WebDriver driver;
By orderSummary = By.xpath("//span[@class = 'checkout-sidebar__section-item']");
By storeName = By.xpath("//*[@class='address__name'])");
//By orderSummary = By.xpath("//*[@id='maincontent']/descendant::span[@class = 'checkout-sidebar__section-item']");
//By orderSummary = By.xpath("//span");
public OrderDetail(WebDriver driver)
{
	this.driver = driver;
}
public static String[] outArray;
//public static Order order = new Order();

public String[] orderSummaryDetails()
{
	List<WebElement> inList = driver.findElements(orderSummary);
	System.out.println("The Store name is: "+ driver.findElement(storeName).getText());
	String[] outArray = new String[inList.size()];  // instantiate Array
	//System.out.println(inList.size());
	for (int i = 0; i < inList.size(); i++) 
	{
		outArray[i] = inList.get(i).getText();

		System.out.println(i + outArray[i]);
  }

	return outArray;
}



}

