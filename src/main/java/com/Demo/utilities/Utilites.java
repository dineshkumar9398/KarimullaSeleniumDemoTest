package com.Demo.utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilites {
	
	WebDriver driver;
	public static String EmailWithTIme() {
		Date date = new Date();
		String timestamp = date.toString().replace(" ","_").replace(":","_");
		return "admin"+timestamp+"@gmail.com";
	}
	
	public void ExplicitWait() {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10000)); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("Xpath")));
	}
//	public static String excelPath ="C:\\Users\\dines\\OneDrive\\Documents\\logindata.xlsx";
//	public static Object[][] getTestDataFromExcel(String SheetName) throws IOException {
//		FileInputStream excfis = new FileInputStream(excelPath);
//		XSSFWorkbook workbook = new XSSFWorkbook(excfis);
//		XSSFSheet sheet = workbook.getSheet(SheetName);
//		int rows = sheet.getLastRowNum();
//		int cols = sheet.getRow(0).getLastCellNum();
//		Object[][] data = new Object[rows][cols];
//		for(int i=0;i<rows;i++) {
//			XSSFRow row = sheet.getRow(i+1);
//			for(int j=0;j<cols;j++) {
//				XSSFCell cell = row.getCell(j);
//				data[i][i]=cell.getStringCellValue();
//				}
//			}
//		return data;
//		}
	
	
	public static String CaptureScreenShot(WebDriver driver,String testName) {
		File srcScreenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationScreenshotPath = "C:\\Users\\dines\\eclipse-workspace\\selenium_test\\ScreenShots\\"+testName+".png";
		try {
			org.openqa.selenium.io.FileHandler.copy(srcScreenshot, new File(destinationScreenshotPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return destinationScreenshotPath;
	}
}

