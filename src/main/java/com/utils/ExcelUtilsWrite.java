package com.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtilsWrite {

	FileInputStream fis=null;
	Workbook wb=null;
	FileOutputStream fos=null;
	
	public void writeExcelFile(String filePath,String sheetname, String data,int row,int col){
		
		try {
			fis= new FileInputStream(filePath);
			wb=WorkbookFactory.create(fis);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		Sheet sh=wb.getSheet(sheetname);
		if(sh.getRow(row)==null){
			sh.createRow(row);
		}
		if(sh.getRow(row).getCell(col)==null){
			sh.getRow(row).createCell(col);
		}
		
		sh.getRow(row).getCell(col).setCellValue(data);
		
		try {
			fos=new FileOutputStream(filePath);
			wb.write(fos);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace(); 
		}
	}
	
	public static void main(String[] args) {
		
		ExcelUtilsWrite eu=new ExcelUtilsWrite();
		eu.writeExcelFile("Test.xlsx", "login", "Datta", 2, 8);
	}
}
