package com.utils;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtilsRead {
	
	FileInputStream fis=null;
	Workbook wb=null;
	public void readExcelFile(String filepath,String sheetname){
		DataFormatter df= new DataFormatter();
		try {
			fis= new FileInputStream(filepath);
			wb=WorkbookFactory.create(fis);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		Sheet sh=wb.getSheet(sheetname);
		int rows=sh.getPhysicalNumberOfRows();
		for(int i=0;i<rows;i++){
			int col=sh.getRow(i).getLastCellNum();
			System.out.println("columns in rownum:"+i+"are"+col);
			for(int j=0;j<col;j++){
				Cell c=sh.getRow(i).getCell(j);
				String data=df.formatCellValue(c);
				System.out.print(data+"  ");
			}
			System.out.println();
		}	
		
		
	}
	
	public String readCell(String filepath,String sheetname,int row,int col){
		DataFormatter df= new DataFormatter();
		try {
			fis= new FileInputStream(filepath);
			wb=WorkbookFactory.create(fis);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		Sheet sh=wb.getSheet(sheetname);
		Cell c=sh.getRow(row).getCell(col);
		String data=df.formatCellValue(c);
		System.out.println(data);
		return df.formatCellValue(c);
		
	}
	

	public static void main(String[] args) {
		ExcelUtilsRead eu=new ExcelUtilsRead();
		eu.readExcelFile("Test.xlsx", "login"); 
		System.out.println("*****************************");
		eu.readCell("Test.xlsx", "login", 1, 2);
		System.out.println("*****************************");
		eu.readExcelFile("TestData.xls", "login");
		
		
	}
}
