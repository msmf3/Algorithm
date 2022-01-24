package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2056_G4_작업_DP {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		int minTime = 0;
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int opTime = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			dp[i] = opTime;
			for(int j = 0; j < K; j++) {
				int k = Integer.parseInt(st.nextToken());
				dp[i] = Math.max(dp[i], opTime + dp[k]);
			}
			minTime = Math.max(minTime, dp[i]);
		}
		System.out.println(minTime);
	}

}
