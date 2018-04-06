package com.test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import com.pages.*;

//Test case to update the basket quantity, book a new store and make the payment using 3D secure card

public class AmendOrderTest {
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

//@BeforeTest
@BeforeClass
public void setup()
{
		System.setProperty("webdriver.chrome.driver","/Users/tina.mehra/Documents/chromedriver");
		driver= new ChromeDriver();
		String appURL = "https://web.stg.olympusdev.js-devops.co.uk/";		
	//	String appURL = "https://select.sainsburys.co.uk/";
		driver.get(appURL);
}
@Test(priority=12,groups="Amend Order")
public void addItemsToBasket()
	{
		objAddToBasket = new AddToBasket(driver);
		objAddToBasket.browserOurPlatter();
		objAddToBasket.addItems();
	}
@Test(priority=13,groups="Amend Order")
public void viewBasket()
	{
		objViewBasket = new ViewBasket(driver);
		objViewBasket.viewBasket();
	}
@Test(priority=14,groups="Amend Order")
public void checkout()
	{
		objCheckOut= new CheckOut(driver);
		objCheckOut.clickCheckOut();
	}
@Test(priority=15,groups="Amend Order")
public void findPostCode()
	{
		objFindStore = new FindStore(driver);
		objFindStore.enterPostcode("Nine");
		objFindStore.clicksearch();
		objFindStore.selectAStore();
	}
@Test(priority=16,groups="Amend Order")
public void selectdate()
	{
		objCalendar = new Calendar(driver);
		objCalendar.calendar();
	}


@Test(priority=17,groups="Amend Order")
public void backButtonClick()
	{
		objPersonalDetails = new PersonalDetails(driver);
		objPersonalDetails.clickbackButton();
	}
@Test(priority=18,groups="Amend Order")
public void incrementProduct()

{
	//driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	objAddToBasket = new AddToBasket(driver);
	
	objAddToBasket.increaseProductQty();
	System.out.println("You are in the increament product");
}
@Test(priority=19,groups="Amend Order")
public void AmendDateandfindPostCode()
	{
		objFindStore = new FindStore(driver);
		objFindStore.clickAmendDate();
		objFindStore.enterPostcode("Elephant");
		objFindStore.clicksearch();
		objFindStore.selectAStore();
	}
@Test(priority=20,groups="Amend Order")
public void Amendselectdate()
	{
		objCalendar = new Calendar(driver);
		objCalendar.calendar();
	}
@Test(priority=21,groups="Amend Order")
public void OrderVerification()
	{
		objOrderSummaryVerification = new OrderSummaryVerification(driver);
		retunArray = OrderSummaryVerification.orderSummaryDetails();
	}
@Test(priority=22,groups="Amend Order")
public void personaldetails()
	{
		objPersonalDetails = new PersonalDetails(driver);
		objPersonalDetails.contactDetails("Test", "Test", "test@email.com", "test@email.com", "07567676767");
		objPersonalDetails.billingDetails("19 Holborn", "GU9 9NJ");
		objPersonalDetails.clickContinue();
	}
	
@Test(priority=23,groups="Amend Order")
public void payment()
	{
		objPayment = new Payment(driver);
		objPayment.PaymentDetails("377810000000007", 2,3,"1234");//3d secure cards
	//	objPayment.PaymentDetails("5573552536142983", 2,3,"123");
		objPayment.paynow();
		objPayment.SecurePayment();
	}
@Test(priority=24,groups="Amend Order")
public void orderconfirmation()
	{
		objOrderConfirmation = new OrderConfirmation(driver);
		objOrderConfirmation.OrderDetails();
		
	}
@Test(priority=25,groups="Amend Order")
public void detailcomparions()
{
String []  f = retunArray;
//System.out.println("The Order No is:" + OrderConfirmation.finalOrderId);
String OrderIdString =FileUtility.read();
String OrderId = OrderIdString.substring(0, OrderIdString.indexOf("|"));
//String lastName =OrderIdString.substring((OrderIdString.indexOf("|")+1),OrderIdString.length());
System.out.println("The Order number is: "+ OrderId);

	
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
			break;
			}

}
	}

@AfterClass
public void closeBrowser()
	{
		objCloseBrowser = new CloseBrowser(driver);
		objCloseBrowser.QuitBrowser();
	}
}
