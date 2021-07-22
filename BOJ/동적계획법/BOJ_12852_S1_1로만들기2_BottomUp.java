package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Bottom-Up and 역추적 방법
 */

public class BOJ_12852_S1_1로만들기2_BottomUp {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int dp[] = new int[N+1];
		dp[1] = 0;
		for(int i = 2; i <= N; i++) {
			dp[i] = dp[i-1] + 1;
			if(i % 2 == 0) {
				dp[i] = Math.min(dp[i], dp[i/2] + 1);
			}
			if(i % 3 == 0) {
				dp[i] = Math.min(dp[i], dp[i/3] + 1);
			}
		}
		sb.append(dp[N] + "\n");
		int next = N;
		while(next > 0) {
			sb.append(next + " ");
			int min = dp[N-1]; 
			next = N-1;
			if(N % 2 == 0 && min > dp[N/2]) {
				next = N/2;
			}
			if(N % 3 == 0 && min > dp[N/3]) {
				next = N/3;
			}
			N = next;
		}
		System.out.println(sb.toString());
	}

}
