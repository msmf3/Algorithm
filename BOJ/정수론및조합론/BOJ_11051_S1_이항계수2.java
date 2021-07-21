package 정수론및조합론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 참고 : https://st-lab.tistory.com/162
 */

public class BOJ_11051_S1_이항계수2 {
	static int dp[][];
	static int div;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		div = 10007;
		dp = new int[N+1][K+1];
		System.out.println(BinomialCoefficient(N, K));
	}
	
	private static int BinomialCoefficient(int n, int k) {
		// 기저 조건
		if(k == 0 || k == n) {
			return dp[n][k] = 1;
		}
		// 이미 계산된 값이면 활용
		if(dp[n][k] > 0) {
			return dp[n][k];
		}
		dp[n][k] = BinomialCoefficient(n-1, k-1) + BinomialCoefficient(n-1, k);
		dp[n][k] %= div;
		return dp[n][k];
	}
}
