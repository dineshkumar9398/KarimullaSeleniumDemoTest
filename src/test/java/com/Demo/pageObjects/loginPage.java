package com.Demo.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Demo.base.BaseClass;

public class loginPage extends BaseClass {
	
	public WebDriver driver;
	//Objects
	@FindBy(name="email")
	private WebElement username;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement loginButton;
	
	@FindBy(xpath="//div[text()='Warning: No match for E-Mail Address and/or Password.']")
	private WebElement WarningNomatchforEMailAddressandorPassword;
	
	public loginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions
	public void username(String s) throws InterruptedException {
		Thread.sleep(3000);
		username.sendKeys(s);
		//driver.findElement(By.name("email")).sendKeys(user);
	}
	
	public void password(String pwd) {
		password.sendKeys(pwd);
		//driver.findElement(By.name("password")).sendKeys(pwd);
	}
	
	public accountPage Button() {
		loginButton.click();

		//driver.findElement(By.xpath("//input[@type='submit']")).click();
		//returning the account page to login . so we can reduce the line when using account page deltails.1
		return new accountPage(driver);
	}
	
	public boolean WarningNomatchforEMailAddressandorPassword() {
		boolean text= WarningNomatchforEMailAddressandorPassword.isDisplayed();
		return text;
	}
}
