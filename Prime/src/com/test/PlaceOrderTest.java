package com.test;

import com.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.annotations.Test;


//Test case to add an item to the basket, book a slot and make the payment without 3D secure card

public class PlaceOrderTest
{
//Define all the objects
WebDriver driver;
AddToBasket objAddToBasket;
ViewBasket objViewBasket;
CheckOut objCheckOut;
FindStore objFindStore;
CloseBrowser objCloseBrowser;
Calendar objCalendar;
OrderSummaryVerification objOrderSummaryVerification;
OrderDetail objOrderDetail;
PersonalDetails objPersonalDetails;
Payment objPayment;
OrderConfirmation objOrderConfirmation;

public static String [] retunArray;
//@BeforeMethod
//@Test
//@AfterMethod
//@Test(priority=1,groups="Place Order")
//@Test(dependsOnMethods="Name of the Method")
@BeforeClass
public void setup()
{
	System.setProperty("webdriver.chrome.driver","/Users/tina.mehra/Documents/chromedriver");
	driver= new ChromeDriver();
//	System.setProperty("webdriver.gecko.driver","/Users/tina.mehra/Documents/geckodriver");
//	 driver = new FirefoxDriver();
	String appURL = "https://web.stg.olympusdev.js-devops.co.uk/";
	//String appURL = "https://select.sainsburys.co.uk/";
	driver.get(appURL);
	String title = driver.getTitle();
	Assert.assertEquals(title,"Sainsbury's Select","Title not matched");

}

@Test(priority=1,groups="Place Order")
public void addItemsToBasket()
{
	objAddToBasket = new AddToBasket(driver);
	objAddToBasket.browserOurPlatter();
	objAddToBasket.addItems();
}
@Test(priority=2,groups="Place Order")
public void viewBasket()
{
	objViewBasket = new ViewBasket(driver);
	objViewBasket.viewBasket();
}
@Test(priority=3,groups="Place Order")
public void checkout()
{
	objCheckOut= new CheckOut(driver);
	objCheckOut.clickCheckOut();
}
@Test(priority=4,groups="Place Order")
public void findPostCode()
{
	objFindStore = new FindStore(driver);
	objFindStore.enterPostcode("Nine");
	objFindStore.clicksearch();
	objFindStore.selectAStore();
}
@Test(priority=5,groups="Place Order")
public void selectdate()
{
	objCalendar = new Calendar(driver);
	objCalendar.calendar();
}
@Test(priority=6,groups="Place Order")
public void OrderVerification()
{
	objOrderSummaryVerification = new OrderSummaryVerification(driver);
	retunArray = OrderSummaryVerification.orderSummaryDetails();
}

@Test(priority=7,groups="Place Order")
public void personaldetails()
{
	objPersonalDetails = new PersonalDetails(driver);
	objPersonalDetails.contactDetails("LastName", "LastName", "test@email.com", "test@email.com", "07567676767");
	objPersonalDetails.billingDetails("19 Holborn", "GU9 9NJ");
	objPersonalDetails.clickContinue();
}
@Test(priority=8,groups="Place Order")
public void payment()
{
	objPayment = new Payment(driver);
	//objPayment.PaymentDetails("377810000000007", 2,3,"1234");//3d secure cards
	objPayment.PaymentDetails("5573552536142983", 2,3,"123");
	objPayment.paynow();
	//objPayment.SecurePayment();
}
@Test(priority=9,groups="Place Order")
public void orderconfirmation()
{
	objOrderConfirmation = new OrderConfirmation(driver);
	objOrderConfirmation.OrderDetails();
	
}
@Test(priority=10,groups="Place Order")
public void detailcomparions()

{
	String []  f = retunArray;
	//System.out.println("The Order No is:" + OrderConfirmation.finalOrderId);
	String OrderIdString =FileUtility.read();
	String OrderId = OrderIdString.substring(0, OrderIdString.indexOf("|"));
	System.out.println("The Order number is: "+ OrderId);

//	System.out.println("The Slot booking date from Order confirmation is:" + OrderConfirmation.getslotDate);
	if (OrderConfirmation.getstoreName.equals(OrderSummaryVerification.storename))
		{
		System.out.println("The store name for which the Order is booked: " + OrderConfirmation.getstoreName);
		Assert.assertEquals(OrderConfirmation.getstoreName, OrderSummaryVerification.storename,"The Store Name not Matching");
		}
	
	for(int i =0; i <f.length; i++)
	{
		if (f[i].endsWith(OrderConfirmation.getPrice))
				{
				System.out.println("The Total Basket value placed is : " + OrderConfirmation.getPrice);
				Assert.assertEquals(OrderConfirmation.getPrice, f[i],"The Price does not Matching");
				//Assert.assertTrue(OrderConfirmation.getPrice, f[i]);
				
				//break;
				}
		if(i ==2) {
		String slotDate =f[2];
		Boolean slotDateResult;
		slotDateResult = DateComparisionUtility.DateCompare(slotDate,OrderConfirmation.getslotDate);
		if(slotDateResult)
//		if (f[i].contains(OrderConfirmation.getslotDate))
	{
		System.out.println("The Date for which the Order is to be collected is : " + OrderConfirmation.getslotDate);
//		break;
		}
		}
//	System.out.println("Value of f in Place Order test " +f[i]);
//	System.out.println("Value of Orderconfirmation Price in Place Order test" + OrderConfirmation.getQty);
//		if (f[i].contains(OrderConfirmation.getQty))
//		{
//		System.out.println("The Total Qty placed is : " + OrderConfirmation.getPrice);
//		//break;
//		}
	}
}
//@AfterClass
//public void closeBrowser()
//{
//	objCloseBrowser = new CloseBrowser(driver);
//	objCloseBrowser.QuitBrowser();
//}
}
