package practise.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact_Dataprovider_Test {
@Test (dataProviderClass = CreateContact_Dataprovider_Test.class, dataProvider = "demo")
public void createContactTest(String firstname, String lastName) {
	System.out.println("Firstname : "+firstname+" lastmname : "+lastName);
}

@DataProvider(name = "demo")
public Object[][] getData(){
	Object[][] objArr = new Object[3][2];
	objArr[0][0]="Asha";
	objArr[0][1]="R";
	
	objArr[1][0]="Chethan";
	objArr[1][1]="SD";
	
	objArr[2][0]="Kavya";
	objArr[2][1]="N";
	
	return objArr;
}
}
