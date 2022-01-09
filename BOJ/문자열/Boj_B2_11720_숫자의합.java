package 문자열;

import java.util.Scanner;

public class Boj_B2_11720_숫자의합 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		String s = sc.next();
		
		int sum = 0;
		for(int i = 0; i < N; i++) {
			sum += s.charAt(i) - '0';
		}
		System.out.println(sum);
		
		sc.close();
	}

}
