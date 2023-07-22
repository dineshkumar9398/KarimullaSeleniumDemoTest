package com.Demo.base;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.api.logs.Logger;

public class BaseClass {
	public static WebDriver driver;
	public static Logger log;
	public static Properties prop;
	public static String ConfigPath = "C:\\Users\\dines\\eclipse-workspace\\selenium_test\\src\\main\\java\\com\\Demo\\config\\Config.properties";
	public static Properties dataProp;
	public static String dataPath="C:\\Users\\dines\\eclipse-workspace\\selenium_test\\src\\main\\java\\com\\Demo\\testData\\testdata.properties";
	public void loadpropertiesFiles() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(ConfigPath);
		prop.load(fis);
		dataProp = new Properties();
		FileInputStream datafis = new FileInputStream(dataPath);
		dataProp.load(datafis);
//		String baseURL ;
//		String BrowserName;
//		baseURL = prop.getProperty("baseURL");
//		BrowserName = prop.getProperty("BrowserName");
//		System.out.println(baseURL);
//		System.out.println(BrowserName);
	}
	
	
//	@BeforeMethod
//	public void browser() throws IOException {
//		loadpropertiesFiles();
//		driver = setup(prop.getProperty("BrowserName"));
//		driver.get(prop.getProperty("baseURL"));
//	}

	public WebDriver setup(String Browser) {
		if(Browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (Browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if (Browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		return driver;
	}
	
	@AfterMethod
	public void teardown(){
		driver.quit();
	}
}
