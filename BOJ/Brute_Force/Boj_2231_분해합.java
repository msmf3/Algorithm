package Brute_Force;

import java.util.Scanner;

public class Boj_2231_분해합 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int ans = 0;
		for(int i = 1; i <= N; i++) {
			int bunhaehab = i + hab(i);
			if(N == bunhaehab) {
				ans = i;
				break;
			}
		}
		System.out.println(ans);
		
		sc.close();
	}
	
	private static int hab(int n) {
		int result = 0;
		
		while(n/10 != 0) {
			result += n%10;
			n /= 10;
		}
		
		result += n%10;
		return result;
	}

}
