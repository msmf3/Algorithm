package 정수론및조합론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 참고 : https://st-lab.tistory.com/159
 */

public class BOJ_11050_B1_이항계수1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		System.out.println(BinomialCoefficient(N, K));
	}
	
	private static int BinomialCoefficient(int n, int k) {
		if(k == n || k == 0) {
			return 1;
		}
		
		return BinomialCoefficient(n-1, k-1) + BinomialCoefficient(n-1, k);
	}
	

}
