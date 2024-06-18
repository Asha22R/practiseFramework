package practise.testng;

import org.testng.annotations.Test;

public class CreateContactTest {
@Test
public void createContactTest() {
	System.out.println("Execute createContactTest-->HDFC ");
}
@Test(dependsOnMethods = "createContactTest")
public void modifyContactTest() {
	System.out.println("Execute modifyContactTest--> HDFC-->ICICI");
}
@Test(dependsOnMethods = "modifyContactTest")
public void deleteContactTest() {
	System.out.println("Execute deleteContactTest-->ICICI");
}
}
