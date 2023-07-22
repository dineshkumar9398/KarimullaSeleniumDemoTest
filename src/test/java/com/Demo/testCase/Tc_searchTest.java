package com.Demo.testCase;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Demo.base.BaseClass;
import com.Demo.pageObjects.searchPage;

public class Tc_searchTest extends BaseClass{
	
	searchPage search;
	
	public WebDriver driver;
	@BeforeMethod
	public void browser() throws IOException {
		loadpropertiesFiles();
		driver = setup(prop.getProperty("BrowserName"));
		driver.get(prop.getProperty("baseURL"));
	}
	@Test(priority = 1)
	public void searchvalide() {
	    search = new searchPage(driver);
		search.searchvalideData();
		//driver.findElement(By.name("search")).sendKeys(dataProp.getProperty("valideProduct"));
		search.clickSearchButton();
		//driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
		if(search.verifyproductdata()) {
			assertTrue(true);
		}
		else {
			assertTrue(false);
		}
	}
	
	@Test(priority = 2)
	public void searchInvalide() {
		search = new searchPage(driver);
		search.searchInvalideData();
		search.clickSearchButton();
		//driver.findElement(By.name("search")).sendKeys(dataProp.getProperty("InvalideProduct"));
		//driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
		if(search.ProductnotAvaliable()) {
			assertTrue(true);
		}
		else {
			assertTrue(false);
		}
	}
	
}
