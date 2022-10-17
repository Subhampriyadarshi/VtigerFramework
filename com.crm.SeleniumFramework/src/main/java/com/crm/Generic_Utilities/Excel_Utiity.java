package com.crm.Generic_Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utiity {

	/**
	 * this method is used to fetch data from excel
	 * @param sheetName
	 * @param RowNum
	 * @param cellNum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 * @author Subham
	 */
	public String getDataFromExcel(String sheetName,int RowNum,int cellNum) throws EncryptedDocumentException, IOException
	{
		//FileInputStream fis1=new FileInputStream("./Book2.xlsx");
		FileInputStream fis1=new FileInputStream(ipathConstant.EXCELFILE_PATH);
		Workbook book=WorkbookFactory.create(fis1);
		
		/*Sheet sh=book.getSheet(sheetName);
		Row row=sh.getRow(RowNum);
		Cell cell = row.getCell(cellNum);
		String data = cell.getStringCellValue();
		return data;  */
		
		DataFormatter format=new DataFormatter();
		return format.formatCellValue(book.getSheet(sheetName).getRow(RowNum).getCell(cellNum));
		
	}
	
	public String getExcelData() throws EncryptedDocumentException, IOException
	{
		FileInputStream fis1=new FileInputStream("./Book1.xlsx");
		Workbook book=WorkbookFactory.create(fis1);
		
		/*Sheet sh=book.getSheet(sheetName);
		Row row=sh.getRow(RowNum);
		Cell cell = row.getCell(cellNum);
		String data = cell.getStringCellValue();
		return data;  */
		return null;
	}
}
