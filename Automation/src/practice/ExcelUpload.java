package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUpload {
	public static void main(String[] args) throws EncryptedDocumentException, IOException  {
		System.out.println("hi");
		// Step no: 1
		FileInputStream f1 = new FileInputStream(
				"C:/Users/prahalla.perumalla/git/repository/RHB/Excel/Prahalla doc.xlsx");
		// Step no: 2
		Workbook wb = WorkbookFactory.create(f1);
		// Step no: 3
		Sheet s1 = wb.getSheet("Login"); // interface will have abstract method
		// Step no: 4
		Row r1 = s1.getRow(1);
		// Step no: 5
		Cell c1 = r1.getCell(1);
		// Step no: 6
		String value1 = c1.toString();
		System.out.println(value1);
	}

}
