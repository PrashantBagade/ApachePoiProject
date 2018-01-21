import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Writefile {
	
public static void writeXLSXFile(Temp[] webobj,FileInputStream file) throws IOException {

    Workbook workbook = new XSSFWorkbook(file);
    org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0);
    Iterator<Row> iterator = sheet.iterator();

	
		//iterating r number of rows
		for (int r=0;r < 5; r++ )
		{
			Temp fromweblogicsheet=webobj[r];
//			XSSFRow row = (XSSFRow) sheet.createRow(r);

			//iterating c number of columns
			for (int c=0;c < 5; c++ )
			{
				String containsjar=fromweblogicsheet.getWeblogicJar();
				if (containsjar.equalsIgnoreCase(cell.getStringCellValue()))
				{
//				XSSFCell cell = row.createCell(c);
	
				cell.setCellValue("Cell "+r+" "+c);
				}else{
					break;
				}
			}
		}
//
//		FileOutputStream fileOut = new FileOutputStream(excelFileName);
//
//		//write this workbook to an Outputstream.
//		wb.write(fileOut);
//		fileOut.flush();
//		fileOut.close();
	}

}

