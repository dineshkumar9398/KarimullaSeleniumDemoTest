package com.Demo.testCase;


import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Demo.base.BaseClass;
import com.Demo.pageObjects.accountPage;
import com.Demo.pageObjects.loginPage;
import com.Demo.utilities.Utilites;


public class Tc_loginTest extends BaseClass {
	
	public WebDriver driver;
	@BeforeMethod
	public void browser() throws IOException {
		loadpropertiesFiles();
		driver = setup(prop.getProperty("BrowserName"));
		driver.get(prop.getProperty("baseURL"));
	}
	
	//Global Variable 
	accountPage account;
	@Test(priority = 1)
	public void loginTestWithValideCerdential() throws InterruptedException {
		loginPage lp = new loginPage(driver);
		lp.username(prop.getProperty("ValideUser"));
		lp.password(prop.getProperty("ValidePassword"));
		account= lp.Button();
		Thread.sleep(2000);
		if(account.VerifyAccountName()) {
			assertTrue(true);
		}
		else {
			assertTrue(false);
		}
		
	}
	
	@Test(priority = 0)
	public void loginTestWithInValideCerdentials() throws InterruptedException {
		loginPage lp = new loginPage(driver);
		System.out.println(Utilites.EmailWithTIme());
		System.out.println(dataProp.getProperty("InvalidePassword"));
		lp.username(Utilites.EmailWithTIme());
		lp.password(prop.getProperty("ValidePassword"));
		lp.Button();
		if(lp.WarningNomatchforEMailAddressandorPassword()) {
			assertTrue(true);
		}
		else {
			assertTrue(false);
			
		}
	}
	//@Test(priority = 1,dataProvider = "Credential")
		public void loginTestWithInvalideCerdential(String[] s) throws InterruptedException {
		loginPage lp = new loginPage(driver);
		//lp.username("karimaj123@gmail.com");
		lp.username(s[0]);
		//lp.password("123423");
		lp.password(s[1]);
		lp.Button();
		Thread.sleep(3000);
		if(lp.WarningNomatchforEMailAddressandorPassword()) {
			assertTrue(true);
		}
		else {
			assertTrue(false);
		}
	}
	
	@DataProvider()
	public String[][] Credential(){
		String[][] data = new String[][] {
			{Utilites.EmailWithTIme(),dataProp.getProperty("InvalidePassword")},
			{prop.getProperty("ValideUser"),dataProp.getProperty("InvalidePassword")},
			{Utilites.EmailWithTIme(),prop.getProperty("ValidePassword")},
		};
		return data;
	}
	@Test(priority = 2)
	public void loginTestWithNoCerdential() throws InterruptedException {
		loginPage lp = new loginPage(driver);
		lp.Button();
		if(lp.WarningNomatchforEMailAddressandorPassword()) {
			assertTrue(true);
		}
		else {
			assertTrue(false);
		}
	}
}
