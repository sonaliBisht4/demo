package ddt_extra;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetMultipleDataFromExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(".\\src/test/resources/TestScriptData.xlsx");

		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("A12");

		for (int i = 1; i <= sh.getLastRowNum(); i++) {
			
			String value0 = sh.getRow(i).getCell(0).getStringCellValue();
			System.out.println(value0);
			
			String value1 = sh.getRow(i).getCell(1).getStringCellValue();
			System.out.println(value1);
		}
	}

}
