package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1562_G1_계단수_DFS {
	static int N, allVisit, div;
	static int dp[][][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		allVisit = (1 << 10) - 1;
		div = 1_000_000_000;
		dp = new int[N+1][10][1<<10];
		
		long ans = 0;
		for(int i = 1; i < 10; i++) {
			ans += dfs(1, (1<<i), i);
			ans %= div;
		}
		System.out.println(ans % div);
	}
	
	private static long dfs(int cnt, int visit, int num) {
		if(dp[cnt][num][visit] != 0) {
			return dp[cnt][num][visit] % div;
		}
		if(cnt == N) {
			if(visit == allVisit) {
				return 1;
			}
			return 0;
		}
		if(num == 9) {
			dp[cnt][num][visit] += dfs(cnt+1, visit|(1<<8), 8);
		}
		else if(num == 0) {
			dp[cnt][num][visit] += dfs(cnt+1, visit|(1<<1), 1);
		}
		else {
			dp[cnt][num][visit] += dfs(cnt+1, visit|(1<<(num-1)), num-1) + dfs(cnt+1, visit|(1<<(num+1)), num+1);
		}
		return dp[cnt][num][visit] % div;
	}

}
