package excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// Step1: get the excel path location and java object of the physical excelFile
		FileInputStream fis = new FileInputStream("C:\\Users\\User\\Desktop\\testScriptData.xlsx");
		// Step2: Open the workbook read mode
		Workbook wb = WorkbookFactory.create(fis);
		// Step3: get the control of the ‘org’ sheet
		Sheet sh = wb.getSheet("org");
		//Step4: get the control of ‘1st’ row
		Row row = sh.getRow(1);
		//Step5: get the control of the 2nd cell & read the string data
		Cell cel = row.getCell(2);
		String val = cel.getStringCellValue();
		System.out.println(wb.getSheet("org").getRow(1).getCell(3).getStringCellValue());
		System.out.println(wb.getSheet("org").getRow(1).getCell(3).toString());
		System.out.println(val);
		//Step6: close the Workbook
		wb.close();
	}

}
