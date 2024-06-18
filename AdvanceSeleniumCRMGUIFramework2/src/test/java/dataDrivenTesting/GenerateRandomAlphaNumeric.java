package dataDrivenTesting;

public class GenerateRandomAlphaNumeric {

	public static void main(String[] args) {
		int n = 15;
		String AlphaNumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
			int index = (int) (AlphaNumeric.length()*Math.random());
			sb.append(AlphaNumeric.charAt(index));
		}
        System.out.println(sb);
	}

}
