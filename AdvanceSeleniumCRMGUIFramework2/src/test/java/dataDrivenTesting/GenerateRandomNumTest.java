package dataDrivenTesting;

import java.util.Random;

public class GenerateRandomNumTest {

	public static void main(String[] args) {
		Random random = new Random();
		int  ranInt  =random.nextInt(1000);
		System.out.println(ranInt);
		
	}

}
