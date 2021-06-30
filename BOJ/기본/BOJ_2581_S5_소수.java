package 기본;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2581_S5_소수 {
	static int sum, min;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		sum = 0;
		sosu(M, N);
		if(sum == 0) {
			System.out.println(-1);
			System.exit(0);
		}
		System.out.println(sum);
		System.out.println(min);
	}

	private static void sosu(int m, int n) {
		for(int i = n; i >= m; i--) {
			if(i == 1) continue;
			boolean flag = true;
			for(int j = 2; j <= Math.sqrt(i); j++) {
				if(i % j == 0) {
					flag = false;
					break;
				}
			}
			if(flag) {
				sum += i;
				min = i;
			}
		}
	}

}
