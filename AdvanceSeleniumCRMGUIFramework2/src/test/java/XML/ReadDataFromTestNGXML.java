package XML;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadDataFromTestNGXML {
	@Test
	public void sampleTest(XmlTest test){
	System.out.println(test.getParameter("browser"));
	System.out.println(test.getParameter("url"));
	System.out.println(test.getParameter("un"));
	System.out.println(test.getParameter("pwd"));
	}

}
