package 정수론및조합론;

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class BOJ_13172_G5_시그마 {
	static long div = 1_000_000_007;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		long ans = 0;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int b = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			long inv_b = pow(b, div-2);
			long d = a * inv_b % div;
			ans = (ans + d) % div;
		}
		
		System.out.println(ans);
	}
	
	private static long pow(long x, long n) {
		if(n == 1) {
			return x;
		}
		if(n % 2 == 1) {
			return x * pow(x, n-1) % div;
		}
		else {
			long tmp = pow(x, n/2);
			return tmp * tmp % div;
		}
	}

}
