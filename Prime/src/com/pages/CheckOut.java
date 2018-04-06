package com.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOut {
WebDriver driver;
By checkoutID = By.id("goToCheckout");
public CheckOut(WebDriver driver)
{
	this.driver = driver;
}

public void clickCheckOut()
{
	driver.findElement(checkoutID).click();
}

}
