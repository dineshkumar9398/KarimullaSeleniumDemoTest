package com.Demo.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Demo.base.BaseClass;

public class searchPage extends BaseClass{
	
	WebDriver driver;
	//Objects
	@FindBy(name="search")
	private WebElement searchfield;
	
	@FindBy(xpath="(//button[@type='button'])[4]")
	private WebElement searchButton;
	
	@FindBy(xpath="//a[text()='HP LP3065']")
	private WebElement verifyproduct;
	
	@FindBy(xpath="//p[text()='There is no product that matches the search criteria.']")
	private WebElement Productnotavaliable;
	
	public searchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public void searchvalideData() {
		searchfield.sendKeys(dataProp.getProperty("valideProduct"));
	}
	
	public void clickSearchButton() {
		searchButton.click();
	}
	
	public boolean verifyproductdata() {
		boolean text= verifyproduct.isDisplayed();
		return text;
	}
	
	public void searchInvalideData() {
		searchfield.sendKeys(dataProp.getProperty("InvalideProduct"));
	}
	
	public boolean ProductnotAvaliable() {
		boolean text1= Productnotavaliable.isDisplayed();
		return text1;
	}
}
