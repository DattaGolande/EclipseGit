package com.jbk.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OperatorsPage {

public static WebDriver driver=null;
	
	@BeforeMethod
	public void setUpBrowser(){
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Selenium Softwares\\chromedriver.exe");
		driver = new ChromeDriver();
	    driver.get("file:///D:/Selenium/Selenium%20Softwares/Offline%20Website/Offline%20Website/pages/examples/operators.html");
		}
	
	@Test
	public void maxiTimeCount(){
		List<WebElement>timings=driver.findElements(By.xpath("//td[6]"));
		for(WebElement time:timings){
			String text=time.getText();
			int firstIndex=text.indexOf(':');
			int lastIndex=text.lastIndexOf(':');
			
			String inTime=text.substring(firstIndex-2, firstIndex+6);
			String outTime=text.substring(lastIndex-2,lastIndex+6 );
			System.out.println(inTime+" "+outTime);
		}
	}
	
	
	
}
