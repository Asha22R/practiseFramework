package practise;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class CreateWorkBook {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\User\\Desktop\\data\\testScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		
		wb.createSheet("Product").createRow(100).createCell(10,CellType.STRING);
		FileOutputStream fos = new FileOutputStream("‪‪");
		wb.write(fos);
		wb.close();

	}

}
