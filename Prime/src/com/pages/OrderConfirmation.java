package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.testng.annotations.DataProvider;

public class OrderConfirmation {

WebDriver driver;
By OrderId = By.xpath("//h1[@class='confirmation']");
By storeName = By.xpath("//p[@class='address__name']");
//By storeRoad = By.xpath("//span[@class='road']");
By slotDate = By.xpath("//p[@data-slot-info]");
By qty= By.xpath("//div[@class='quantity']/div/p");
By price = By.cssSelector("p.price");

public static String getOrderString, getstoreName,getslotDate,getQty,getPrice;
//public static String finalOrderId;
public static String [] orderNo;

OrderSummaryVerification objOrderConfirmation;
public OrderConfirmation(WebDriver driver)
	{
		this.driver = driver;
	}


public void OrderDetails()
{
	driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	getOrderString = driver.findElement(OrderId).getText();
	//finalOrderId = getOrderId.substring(17, 30);
	String ord="order";
	int position =getOrderString.indexOf(ord)+ord.length()+1;
//	System.out.println(getOrderString.indexOf(ord));
//	System.out.println(position);
	String finalOrderId=getOrderString.substring(position,position+13);
	//System.out.println("In the module:" +finalOrderId);
	int commaPosition =getOrderString.indexOf(",");
	String lastName =getOrderString.substring(0, commaPosition) ;
	//System.out.println(lastName);
	String finalString =finalOrderId+"|"+lastName;
	FileUtility.write(finalString);
	 getstoreName = driver.findElement(storeName).getText();
	 //System.out.println(getstoreName);
	// getstoreName = driver.findElement(storeRoad).getText();
	 getslotDate = driver.findElement(slotDate).getText();	
     getQty = driver.findElement(qty).getText();
	 getPrice = driver.findElement(price).getText();
}

//@DataProvider(name="OrderIdTestData")
//public static Object [][] getData()
//{
//	Object[][] data = new Object[1][1];
//	data[0][0]= finalOrderId.length();
//	return data;
//}

}
