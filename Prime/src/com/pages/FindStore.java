package com.pages;

//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
import java.util.List;
//import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class FindStore {
WebDriver driver;
By postcodetxt = By.id("searchBoxInput");
By postcodebutton=By.id("find_stores");
By storeList = By.xpath("//div[@class='info_container']");
//By selectDate = By.xpath("//button[text()='Select date']");
By selectDate = By.xpath("//div[@class='store-list__actions']//button[@class='btn store-list__btn--primary']");
By amendDate= By.xpath("//button[@class='btn secondary btn--small']");
//initialize the driver
public FindStore(WebDriver driver)
{
		this.driver = driver;
}
public void clickAmendDate()
{
	driver.findElement(amendDate).click();
}
public void enterPostcode(String postcode)
{
	driver.findElement(postcodetxt).sendKeys(postcode);	
}

public void clicksearch()
{
	driver.findElement(postcodebutton).click();
}

public void selectAStore()
{
	//driver.manage().window().maximize();	

	//Store List
	List<WebElement> store_Webelement = driver.findElements(storeList);	
	//Date List
	List<WebElement> date_Webelement = driver.findElements(selectDate);
	//System.out.println(date_Webelement.get(0).isEnabled());
	//Loop to select the store and date which is visible
	for(int a=0; a<store_Webelement.size();a++) 
	 {  
	//	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	
	   if (store_Webelement.get(a).isDisplayed())
		{ //System.out.println(store_Webelement.get(0).isEnabled());
		   store_Webelement.get(a).click();
		   if (date_Webelement.get(a).isEnabled())
		   {
			   //System.out.println(date_Webelement.get(0).isEnabled());
				Actions builder = new Actions(driver);
				builder.moveToElement(date_Webelement.get(a));
				builder.perform();
				builder.build().perform();
			   date_Webelement.get(a).click();
			   break;
		   }
		 
		}
	 }
  }

}


