package excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataBasedOnCondition {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		String expecID = "tc_03";
		String	data1 ="";
		String	data2 ="";
		String	data3 ="";
		boolean flag = false;
		FileInputStream fis = new FileInputStream("C:\\\\Users\\\\User\\\\Desktop\\\\testScriptData.xlsx");
		Workbook  wb = WorkbookFactory.create(fis);
		Sheet	sh = wb.getSheet("org");
		int rowcount = sh.getLastRowNum();
		for (int i = 0; i <= rowcount; i++) {
			String	data ="";
			try {
				data = sh.getRow(i).getCell(0).toString();
				if (data.equals(expecID)) {
					flag = true;
					data1= sh.getRow(i).getCell(1).toString();
					data2= sh.getRow(i).getCell(2).toString();
					data3= sh.getRow(i).getCell(3).toString();
				}		
			} 
			catch (Exception e) {}
		}
		if (flag==true) {
			System.out.println(data1+"\t"+data2+"\t"+data3);			
		} else {
			System.out.println(expecID+" is not available");
		}
		wb.close();
	}

}
