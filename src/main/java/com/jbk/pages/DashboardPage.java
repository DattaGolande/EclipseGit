package com.jbk.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DashboardPage {

public static WebDriver driver=null;
	
	@BeforeMethod
	public void setUpBrowser(){
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Selenium Softwares\\chromedriver.exe");
		driver = new ChromeDriver();
	    driver.get("file:///D:/Selenium/Selenium%20Softwares/Offline%20Website/Offline%20Website/pages/examples/dashboard.html");
		}
	
	@Test
	public void verifyCourseColor(){
		List<WebElement>course=driver.findElements(By.xpath("//div//parent::div[contains(@class,'small-box')]"));
		for(WebElement e:course){
			String text=e.getAttribute("class");
			String color=text.substring(text.lastIndexOf('-')+1);
			System.out.println(color);
		}
	}
	
	@Test
	public void verifyCourseSymbol(){
		List<WebElement>icons=driver.findElements(By.xpath("//div[@class='icon']/i"));
		for(WebElement e:icons){
			String text=e.getAttribute("class");
			String symbol=text.substring(text.lastIndexOf('-')+1);
			System.out.println(symbol);
		}
	}
	
}
