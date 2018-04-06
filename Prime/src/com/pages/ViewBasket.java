package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewBasket {
//Define the objects
WebDriver driver;
By minibasket = By.xpath("//*[@id='mini-basket-container']");

//initialize the WebDriver
public ViewBasket(WebDriver driver)
{
	this.driver = driver;
}

public void viewBasket()
{
	driver.findElement(minibasket).click();
		
}
}
