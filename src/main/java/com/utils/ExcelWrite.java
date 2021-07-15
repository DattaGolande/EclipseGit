 package com.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelWrite {
	FileInputStream fis=null;
	FileOutputStream fos= null;
	Workbook wb=null;
	Sheet sh=null;
	
	
	public void writeExcel(String filePath, String sheetName, String data,int row, int col) {
		try {
			 fis= new FileInputStream(filePath);
			 wb= WorkbookFactory.create(fis);
			}catch(Exception e) {
				e.printStackTrace();
			}
		
		    if(wb.getSheet(sheetName)==null)
		    	wb.createSheet(sheetName);
		    	
		    	
			 sh = wb.getSheet(sheetName);
			if(sh.getRow(row)==null) {
				sh.createRow(row);			
			}
			if(sh.getRow(row).getCell(col)==null) {
				sh.getRow(row).createCell(col);
			}
			
		sh.getRow(row).getCell(col).setCellValue(data);	
		try {
		fos = new FileOutputStream(filePath);
		wb.write(fos);
		fos.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}