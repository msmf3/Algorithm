import java.util.Scanner;

public class BOJ_2908_B2_상수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		String a_bw = backward(new StringBuilder(a));
		String b_bw = backward(new StringBuilder(b));
		int a_int = Integer.parseInt(a_bw);
		int b_int = Integer.parseInt(b_bw);
		System.out.println(a_int > b_int ? a_int : b_int);
		
		sc.close();
	}
	
	private static String backward(StringBuilder s) {
		int n = s.length();
		for(int i = 0; i < n / 2; i++) {
			char a = s.charAt(i);
			char b = s.charAt(n-1 - i);
			s.setCharAt(i, b);
			s.setCharAt(n-1-i, a);
		}
		return s.toString();
	}

}
