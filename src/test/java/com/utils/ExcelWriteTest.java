package com.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.utils.ExcelWrite;

public class ExcelWriteTest {

	WebDriver driver=null;

    @Test
	public void test01() {
		int row=1;
		ExcelWrite eu = new ExcelWrite();
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Selenium Softwares\\chromedriver.exe");
		driver =  new ChromeDriver();
		driver.get("file:///D:/Selenium/Selenium%20Softwares/Offline%20Website/Offline%20Website/pages/examples/users.html");
		if(row==1) {
		List<WebElement> headers = driver.findElements(By.tagName("th"));//8
		for(WebElement header : headers) {
			String text =header.getText();
			eu.writeExcel("Test.xlsx", "UsersTable", text, 0, headers.indexOf(header));			
		}
		row++;
		}
		while(row<=5){
			List<WebElement> data = driver.findElements(By.xpath("//tr["+row+"]/td"));//8
			for(WebElement val : data) {
				String text =val.getText();
				eu.writeExcel("Test.xlsx", "UsersTable", text, row-1, data.indexOf(val));			
			}
			row++;
		}
	}

	
}