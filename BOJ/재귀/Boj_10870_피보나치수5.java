package 재귀;

import java.util.Scanner;

public class Boj_10870_피보나치수5 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		System.out.println(fibonacci(N));
		
		sc.close();
	}
	
	private static int fibonacci(int n) {
		if(n == 0) {
			return 0;
		}
		if(n == 1) {
			return 1;
		}
		
		return fibonacci(n-2) + fibonacci(n-1);
	}
}
