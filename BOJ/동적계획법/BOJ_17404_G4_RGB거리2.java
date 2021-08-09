package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 참고 : https://dragon-h.tistory.com/31
 */

public class BOJ_17404_G4_RGB거리2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int arr[][] = new int[N+1][3];
		int dp[][] = new int[N+1][3];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}
		dp[1][0] = arr[1][0];
		dp[1][1] = arr[1][1];
		dp[1][2] = arr[1][2];
		int min_ans = Integer.MAX_VALUE;
		for(int k = 0; k < 3; k++) {
			// 첫번째 집을 R, G, B 로 칠한 경우의 수를 나누고 생각.
			int oo1 = (k+1) % 3;
			int oo2 = (k+2) % 3;
			dp[1][k] = arr[1][k];
			dp[1][oo1] = 1001;
			dp[1][oo2] = 1001;
			
			for(int i = 2; i <= N; i++) {
				for(int j = 0; j < 3; j++) {
					int o1 = (j+1) % 3;
					int o2 = (j+2) % 3;
					dp[i][j] = Math.min(dp[i-1][o1], dp[i-1][o2]) + arr[i][j];
				}
			}
			
			for(int j = 0; j < 3; j++) {
				// 첫번째 칠한집과 겹치지 않는 경우만 봄
				if(k == j) continue;
				min_ans = Math.min(min_ans, dp[N][j]);
			}
		}
		System.out.println(min_ans);
	}

}
