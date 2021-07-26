package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {
	
	 
	
	
	public static void main(String[] args) {
		DataFormatter df= new DataFormatter();
	FileInputStream fis;
	try {
		//File src=new File("")
		fis = new FileInputStream("Test.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh=wb.getSheet("UsersTable");
		int rows=sh.getPhysicalNumberOfRows();
		System.out.println("Total number of rows :"+rows);
		for(int i=0;i<rows;i++)
		{
			int col=sh.getRow(i).getLastCellNum();
			{
				for(int j=0;j<col;j++){
					Cell c=sh.getRow(i).getCell(j);
					String data=df.formatCellValue(c);
					System.out.print(data);
				}
				System.out.println();
			}
		}
	}
				 catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
	}
}
			//String data=sh.getRow(i).getCell(0).getStringCellValue();
			//System.out.println(data);
		
				//System.out.println("columns in rownum:"+i+"are"+col);
				
	
	
	
	
	

