package medikartPharma;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class DDTExcel {
	@DataProvider(name = "loginData")
	public Object[][] getData() throws Exception {

		FileInputStream fis = new FileInputStream("C:\\Users\\YourName\\testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");

		int rows = 5; // 0–4
		int cols = 2; // username, password

		Object[][] data = new Object[rows][cols];

		DataFormatter formatter = new DataFormatter();

		for (int i = 0; i < rows; i++) { // rows 0–4
			Row row = sheet.getRow(i);

			for (int j = 0; j < cols; j++) { // cols 0–1
				Cell cell = row.getCell(j);
				data[i][j] = formatter.formatCellValue(cell);
			}
		}
		wb.close();
		return data;
	}
}

