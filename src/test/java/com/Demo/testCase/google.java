package com.Demo.testCase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Demo.base.BaseClass;

public class google extends BaseClass{
	
	public WebDriver driver;
	
	@BeforeMethod
	public void browser() throws IOException {
		loadpropertiesFiles();
		driver = setup(prop.getProperty("BrowserName"));
		driver.get(prop.getProperty("baseURL"));
	}

	@Test
	public void facebooktest() {
		driver.findElement(By.id("email")).sendKeys("aboutsd123@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("12321");
		driver.findElement(By.name("login")).click();
		String Actualtext = driver.findElement(By.xpath("//a[text()='Find your account and log in.']")).getText();
		String Excpetedtext = "Find your account and log jhgf";
		Assert.assertEquals(Actualtext, Excpetedtext);
		
	}
}
