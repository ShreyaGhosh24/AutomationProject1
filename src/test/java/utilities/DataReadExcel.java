package utilities;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFCell;
public class DataReadExcel {
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static XSSFCell cell;
	
	
	public static Object[][] readDataExcel(String path,String sName,int row,int col) throws IOException {
		FileInputStream file= new FileInputStream("C:\\Users\\SHREYA GHOSH\\eclipse-workspace\\CuraHealth\\Dataset\\LoginCredentialsData.xlsx");
		String sheetName="invalid";
		
		workbook= new XSSFWorkbook(file);
		sheet=workbook.getSheet(sName);
		//=sheet.getRow(0).getCell(0);
		//String[][] validDataset = null;
		String[][] Dataset=new String[row+1][col+1];
		
		for(int i=0;i<=row;i++) {
			for(int j=0;j<=col;j++) {
				System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
				Dataset[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.println(Dataset[i][j]);
			}
			
			
				
		
		
		
		}
		//System.out.println(invalidDataset[0][0]);
		return Dataset;
		
	
	}
}

