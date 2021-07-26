package com.jbk.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class UsersPageTestCasesUsingHashmap {
	public static WebDriver driver=null;
	
	@BeforeMethod
	public void setUpBrowser(){
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Selenium Softwares\\chromedriver.exe");
		driver = new ChromeDriver();
	    driver.get("file:///D:/Selenium/Selenium%20Softwares/Offline%20Website/Offline%20Website/pages/examples/users.html");
	
		
	}
	@Test
	public void validateGenders(){
     	List<WebElement>genders=driver.findElements(By.xpath("//td[6]"));
		for(WebElement gender:genders){
			int row=genders.indexOf(gender)+2;
			if(gender.getText().equals("Male")){
				System.out.println(driver.findElement(By.xpath("//tr["+row+"]/td[2]")).getText());
			}
		}
	}
	
	@Test
	public void addGendersUsingHasmap(){
		List<WebElement>usernames=driver.findElements(By.xpath("//td[2]"));
		List<WebElement>genders=driver.findElements(By.xpath("//td[6]"));
		
		HashMap<Integer,List<String>>hm=new HashMap<Integer, List<String>>();
		for(int i=0;i<usernames.size();i++){
			String uname=usernames.get(i).getText();
			String gender=genders.get(i).getText();
			
			List<String>al=new ArrayList<String>();
			al.add(uname);
			al.add(gender);
			hm.put(i, al);
			}
		
		System.out.println(hm);
	}
	
	@Test
	public void verifyTable(){
		HashMap<String,List<String>>actData=new HashMap<String,List<String>>();
		String key=null;
		List<String>value=new ArrayList<String>();
		List<WebElement>headers=driver.findElements(By.tagName("th"));
		for(WebElement e:headers){
			if(headers.indexOf(e)==0){
				key=e.getText();
			}
			else{
				value.add(e.getText());
			}
			actData.put(key, value);
			int rows=driver.findElements(By.tagName("tr")).size();
			for(int i=2;i<=rows;i++){
				List<WebElement>rowData=driver.findElements(By.xpath("//tr["+i+"]/td"));
				for(WebElement row:rowData){
					if(rowData.indexOf(row)==0)
						key=row.getText();
					else
						value.add(row.getText());
				}
			actData.put(key, value);
			}
			
		}		
		System.out.println(actData);
	}
	
	@Test
	public void mobileLength(){
		boolean flag=false;
		List<WebElement>mobiles=driver.findElements(By.xpath("//td[4]"));
		SoftAssert sa=new SoftAssert();
		for(WebElement mob:mobiles){
			String text=mob.getText();
			if(text.length()==10){
				System.out.println("Correct Number Is :"+text);
				sa.assertTrue(!flag, text);
			}
			else{
				System.out.println("InCorrect Number Is:"+text);
				sa.assertTrue(flag, text);
			}
		}
		//sa.assertAll();
	}
	
	
}
