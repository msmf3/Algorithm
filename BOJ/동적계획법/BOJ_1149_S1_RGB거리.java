package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149_S1_RGB거리 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int houseRGB[][] = new int[N][3];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				houseRGB[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int dp[][] = new int[N][3];
		for(int i = 0; i < 3; i++) {
			dp[0][i] = houseRGB[0][i];
		}
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < 3; j++) {
				dp[i][j] = Math.min(dp[i-1][(j+1)%3], dp[i-1][(j+2)%3]) + houseRGB[i][j];
			}
		}
		int ans = Integer.MAX_VALUE;
		for(int i = 0; i < 3; i++) {
			ans = Math.min(ans, dp[N-1][i]);
		}
		System.out.println(ans);
	}

}
