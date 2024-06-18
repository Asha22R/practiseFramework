package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DemoDataDrivenTesting {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\User\\Desktop\\commondata1.properties");
        Properties p = new Properties();
        p.load(fis);
        System.out.println(p.getProperty("url"));
        
	}

}
