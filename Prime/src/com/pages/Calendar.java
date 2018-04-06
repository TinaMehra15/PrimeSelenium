package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Calendar {
WebDriver driver;
By bookThisDate = By.xpath("//button[text()='Book this date']");

//initialize the driver
public Calendar(WebDriver driver)
{
		this.driver = driver;
}

public void calendar()
{

	List<WebElement> dates = driver.findElements(By.xpath("//div[@class='DayPicker-Day']"));	
	for(int a=1; a<dates.size();a++) 
	 {  
		//String date = dates.get(a).getText();
		String enableddates = dates.get(a).getAttribute("aria-disabled");
		if(enableddates.equalsIgnoreCase("false"))
		{
			 dates.get(a).click();
			 driver.findElement(bookThisDate).click();
			 break;
		}
	}

}
}
