package practise;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataexcel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\User\\Desktop\\testScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		FileOutputStream fos = new FileOutputStream("C:\\Users\\User\\Desktop\\testScriptData.xlsx");
		String s1 = "tc_02";
		boolean flag = false;
		int   rowcount = wb.getSheet("org").getLastRowNum();
		for (int i = 0; i <=rowcount; i++) {
			String data = "";
			try {
				data=wb.getSheet("org").getRow(i).getCell(0).toString();
				if(data.equals(s1)) {
					flag= true;
					Cell cel = wb.getSheet("org").getRow(i).createCell(4);
					cel.setCellType(CellType.STRING);
					cel.setCellValue("fail");
					}
			} catch (Exception e) {}
		}
		if(flag==true) {
			System.out.println("Data entered successfully");
		}
		else {
			System.out.println(s1+" not present");
		}
		wb.write(fos);
		wb.close();
	}

}
