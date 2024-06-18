package commandlinw;

public class ReadRuntimeParameterTest {
	public static void main(String[] args) {
		// read data from cmd line using normal java program 
		System.out.println(args.length);
		// since it not recieved any parameter from cmdline the length is Zero
		
		
		for(String a: args) {
			System.out.println(a);
		}
	}
}
