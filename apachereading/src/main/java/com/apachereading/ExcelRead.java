package com.apachereading;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	public static void main(String[] args) throws IOException {

		readFromExcel();

	}

	private static void readFromExcel() throws IOException {

		File file = new File("C:/Users/Pashu/Desktop/weblogicJars.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workBook = new XSSFWorkbook(fis);
		Sheet mySheet = workBook.getSheetAt(0);
		for (Row row : mySheet) {

			if (row.getCell(0).getStringCellValue().endsWith(".jar")) {

				System.out.println(row.getCell(0).getStringCellValue());
				writeInExcel();

			}

		}

	}

	private static void writeInExcel() {
		
		

	}

}
