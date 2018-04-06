package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalDetails {
//Define the WebDriver object
WebDriver driver;
//Define Contact Details objects
By firstName = By.name("firstName");
By lastName =By.name("lastName");
By emailId= By.id("emailFirst");
By emailConfirm= By.id("emailSecond");
By phoneNo=By.name("phoneNumber");
//Define Billing Details objects
By billingAdd = By.name("billingAddress");
By postCode = By.name("billingPostcode");
By checkBox =By.id("termsAndConditions");
//Continue Button
By continueButton = By.id("submit-form");

//Back Button
By backButton = By.xpath("//a[@class='btn secondary']");

//initialize the WebDriver
public PersonalDetails(WebDriver driver)
{
		this.driver = driver;
}
public void contactDetails(String firstname, String lastname, String emailid, String emailconfirm, String phoneno)
{
	driver.findElement(firstName).sendKeys(firstname);
	driver.findElement(lastName).sendKeys(lastname);
	driver.findElement(emailId).sendKeys(emailid);
	driver.findElement(emailConfirm).sendKeys(emailconfirm);
	driver.findElement(phoneNo).sendKeys(phoneno);
}
public void billingDetails(String billingadd, String billingpostcode)
{
	driver.findElement(billingAdd).sendKeys(billingadd);
	driver.findElement(postCode).sendKeys(billingpostcode);
	driver.findElement(checkBox).click();
}
public void clickContinue()
{
	driver.findElement(continueButton).click();
}
public void clickbackButton()
{
	driver.findElement(backButton).click();
}

}