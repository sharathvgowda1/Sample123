package com.shophunt.genericutilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	   /**
	    *   its used to read the data from Excel-Workbook based on below 
	    * @param sheetName
	    * @param rowNum
	    * @param celNum
	    * @return String data

	 * @throws Throwable
	    */

	public String getExcelData(String SheetName, int RowNum, int CellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		DataFormatter formatter=new DataFormatter();
		String Data = formatter.formatCellValue(wb.getSheet(SheetName).getRow(RowNum).getCell(CellNum));
		return Data;
	}
	
	/**
	 * used to get the last used row number on specified Sheet
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public int getRowCount(String sheetName) throws Throwable
	{
		FileInputStream fis  = new FileInputStream(IConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		wb.close();
		return sh.getLastRowNum();
	}
	/**
	 * used to write data back to Excel based on below parameter
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @param data
	 * @throws Throwable
	 */
	public void setDataExcel(String sheetName , int rowNum, int cellNum ,String data) throws Throwable
	{
		FileInputStream fis  = new FileInputStream(IConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.createRow(rowNum);
		Cell cell = row.createCell(cellNum);
		cell.setCellValue(data);
		FileOutputStream fos = new FileOutputStream(IConstants.ExcelPath);
		wb.write(fos);
		wb.close();
	}
	

}
