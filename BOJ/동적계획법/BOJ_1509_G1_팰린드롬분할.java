package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 참고 : https://maivve.tistory.com/119
 */

public class BOJ_1509_G1_팰린드롬분할 {
	static int n, ans;
	static boolean palindrome[][];
	static int dp[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char str[] = br.readLine().toCharArray();
		n = str.length;
		palindrome = new boolean[n][n];
		dp = new int[n+1];
		for(int i = 0; i < n; i++) {
			palindrome[i][i] = true;
		}
		for(int i = 0; i < n-1; i++) {
			if(str[i] == str[i+1]) {
				palindrome[i][i+1] = true;
			}
		}
		// 2차원 boolean 배열에 팰린드롬 체크
		for(int i = 2; i < n; i++) {
			for(int from = 0; from + i < n; from++) {
				int to = from + i;
				if(str[from] == str[to] && palindrome[from+1][to-1]) {
					palindrome[from][to] = true;
				}
			}
		}
		for(int i = 1; i <= n; i++) {
			dp[i] = i;
		}
		// dp[i] = 0~(i-1)번째까지의 팰린드롬 분할의 최소개수
		for(int to = 1; to <= n; to++) {
			for(int from = 1; from <= to; from++) {
				if(palindrome[from-1][to-1] && dp[to] > dp[from-1] + 1) {
					dp[to] = dp[from-1] + 1;
				}
			}
		}
		System.out.println(dp[n]);
		// DFS 시간초과
		/*
		ans = Integer.MAX_VALUE;
		for(int end = n-1; end >= 0; end--) {
			if(palindrome[0][end]) {
				dfs(end+1, n-1, 1);
			}
		}
		*/
	}
	
	/*
	private static void dfs(int start, int end, int cnt) {
		if(start >= n) {
			ans = Math.min(ans, cnt);
			return;
		}
		
		for(int i = end; i >= start; i--) {
			if(palindrome[start][i]) {
				dfs(i+1, n-1, cnt+1);
				if(i == end) return;
			}
		}
	}
	*/

}
