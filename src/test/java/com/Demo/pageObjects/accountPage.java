package com.Demo.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class accountPage {
	
	WebDriver driver;
	//Objects
	@FindBy(xpath="//a[text()='Account']")
	private WebElement accountName;
	
	public accountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public boolean VerifyAccountName() {
		boolean text1= accountName.isDisplayed();
		return text1;
	}
}
