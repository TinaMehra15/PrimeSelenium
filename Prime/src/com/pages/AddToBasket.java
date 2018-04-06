package com.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class AddToBasket {
//Declaration
WebDriver driver;
By browserOurPlatter = By.xpath("//div[@class='hero__cta']//a[text()='Browse our platters']");
By addItemsbutton = By.xpath("//button[contains(text(),'Add to basket')]");
By productIncrease = By.xpath("//*[@id='increment']");
//initialize the WebDriver	
//Constructor that is called then an instance of object is created
public AddToBasket(WebDriver driver)
{
	this.driver = driver;		
}
public void browserOurPlatter()
{
	driver.findElement(browserOurPlatter).click();
	
}
public void addItems()
{
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	List<WebElement> total_Webelement = driver.findElements(addItemsbutton);
	//for loop to find and add an item to the basket
	for(int a=0; a<total_Webelement.size();a++)
	 {  
	   if (total_Webelement.get(a).isDisplayed())
		{
		   total_Webelement.get(a).click();
		   break;
		 }
				  
	   }

}
public void increaseProductQty()
{
	driver.findElement(productIncrease).click();
}
}
