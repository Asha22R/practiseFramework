package practise;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromWorkBook {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	FileInputStream fis = new FileInputStream("C:\\\\Users\\\\User\\\\Desktop\\\\testScriptData.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	System.out.println(wb.getSheet("org").getRow(1).getCell(0).getStringCellValue());
	int rowcount = wb.getSheet("Sheet1").getLastRowNum();
//	for (int i = 1; i <=rowcount; i++) {
//	String	data1= wb.getSheet("Sheet1").getRow(i).getCell(0).getStringCellValue();
//	String	data2= wb.getSheet("Sheet1").getRow(i).getCell(1).getStringCellValue();
//		System.out.println(data1+"\t"+data2);
//	}
	String expec= "tc_03";
	String data1="";
	String data2="";
	String data3="";
	boolean flag = false;
	for (int i = 0; i <=rowcount; i++) {
		String data="";
		try {
		data = wb.getSheet("org").getRow(i).getCell(0).toString();
		if(data.equals(expec)) {
			flag= true;
			data1 = wb.getSheet("org").getRow(i).getCell(1).toString();
			data2 = wb.getSheet("org").getRow(i).getCell(2).toString();
			data3 = wb.getSheet("org").getRow(i).getCell(3).toString();
		}
			
		} catch (Exception e) {
			
		}
	}
	if(flag==true) {
	System.out.println(data1+"\t"+data2+"\t"+data3);
	}
	else {
		System.out.println(expec+" not prresent in workbook");
	}
	wb.close();
}
}
