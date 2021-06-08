package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1629_S1_곱셈 {
	static int C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		System.out.println(power(A, B));
	}
	
	private static long power(int n, int x) {
		if(x == 1) {
			return n % C;
		}
		long a = power(n, x/2);
		if(x % 2 == 0) {
			return (a * a) % C;
		}
		else {
			return ((a * a) % C * n % C) % C;
		}
	}

}
