package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pages.CancelOrder;
import com.pages.CloseBrowser;
import com.pages.FileUtility;

public class CancelOrderTest {
WebDriver driver;
CancelOrder objCancelOrder;
CloseBrowser objCloseBrowser;
@BeforeClass
public void setup()
{
			
	//System.out.println("Order id --->"+OrderConfirmation.finalOrderId);
	System.setProperty("webdriver.chrome.driver","/Users/tina.mehra/Documents/chromedriver");
			driver= new ChromeDriver();
			String appURL = "https://web.stg.olympusdev.js-devops.co.uk/order/login";
			driver.get(appURL);
}
//@DataProvider(name="OrderIdTestData")
//public Object [][] getData()
//{
//	Object[][] data = new Object[1][1];
//	data[0][0]= "190738-161050";
//	return data;
//}

//@Test(dataProvider="OrderIdTestData",dataProviderClass=OrderConfirmation.class)
@Test(priority=11, groups= {"Place Order","Amend Order"})
public void cancelOrder()
{
		objCancelOrder = new CancelOrder(driver);
		String OrderIdString =FileUtility.read();
		String OrderId = OrderIdString.substring(0, OrderIdString.indexOf("|"));
		String lastName =OrderIdString.substring((OrderIdString.indexOf("|")+1),OrderIdString.length());
		System.out.println("Order number is:"+ OrderId);
		objCancelOrder.orderNo(OrderId);
		objCancelOrder.lastName(lastName);
		objCancelOrder.clickSubmit();
		objCancelOrder.cancelMyOrder();
		objCancelOrder.yesCancelMyOrder();
		objCancelOrder.orderCancelled();
		if (CancelOrder.cancelMsg.contains(OrderId))
		{
			System.out.println("Thanks for Shopping with Sainsburys");
			System.out.println(CancelOrder.cancelMsg);
		}
}
@AfterClass
public void closeBrowser()
{

		objCloseBrowser = new CloseBrowser(driver);
		objCloseBrowser.QuitBrowser();
	
}
}
