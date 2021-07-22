package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 참고 : https://steady-coding.tistory.com/328
 */

public class BOJ_12852_S1_1로만들기2_TopDown {
	static Case dp[];
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		dp = new Case[N+1];
		dp[1] = new Case(0, "1");
		sb.append(bfs(N) + "\n");
		sb.append(dp[N].route);
		System.out.println(sb.toString());
	}
	
	private static int bfs(int n) {
		if(n == 1) {
			return dp[n].min;
		}
		if(dp[n] != null) {
			return dp[n].min;
		}
		int min = bfs(n-1) + 1;
		int idx = n-1;
		if(n % 3 == 0) {
			int div3 = bfs(n/3);
			if(div3 + 1 < min) {
				min = div3 + 1;
				idx = n / 3;
			}
		}
		if(n % 2 == 0) {
			int div2 = bfs(n/2);
			if(div2 + 1 < min) {
				min = div2 + 1;
				idx = n / 2;
			}
		}
		dp[n] = new Case(min, n + " " + dp[idx].route);
		return dp[n].min;
	}
	
	static class Case {
		int min;
		String route;
		
		public Case(int min, String route) {
			this.min = min;
			this.route = route;
		}
	}
}
