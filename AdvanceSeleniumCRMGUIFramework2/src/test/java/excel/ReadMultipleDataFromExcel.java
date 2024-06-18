package excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("C:\\\\Users\\\\User\\\\Desktop\\\\testScriptData.xlsx");
		Workbook  wb = WorkbookFactory.create(fis);
		Sheet	sh = wb.getSheet("Sheet1");
		//		for (int i = 1; i <50; i++) {
		//			Row row = sh.getRow(i);
		//			String	col1= row.getCell(0).toString();
		//			String	col2= row.getCell(1).toString();
		//			System.out.println(col1+"\t"+col2);
		//		}
		int rowCount = sh.getLastRowNum();
		for (int i = 1; i <rowCount; i++) {
			Row row = sh.getRow(i);
			String	col1= row.getCell(0).toString();
			String	col2= row.getCell(1).toString();
			System.out.println(col1+"\t"+col2);
		}
		wb.close();
	}

}
