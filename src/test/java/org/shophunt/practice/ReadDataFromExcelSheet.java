package org.shophunt.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelSheet {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		//Step1 - read the file using file input stream
		FileInputStream fis = 	new FileInputStream(".\\Data\\TestData.xlsx");

		//Step2 - Create Workbook
		Workbook book = WorkbookFactory.create(fis);
		
		//load the sheet
		Sheet sh = book.getSheet("Sheet1");
		
		//navigate to the row
		Row row = sh.getRow(1);
		
		//Navigate to the cell
		Cell cell = row.getCell(2);
		
		//read the value inside the cell
		String res = cell.getStringCellValue();
		System.out.println(res);

	}

}
