package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 참고 : https://life-with-coding.tistory.com/316
 */

public class BOJ_7579_G3_앱 {
//	static int ans;
	static int N, M;
	static int dp[];
	static int memories[], costs[];
//	static boolean visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		memories = new int[N];
		for(int i = 0; i < N; i++) {
			memories[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		costs = new int[N];
		int cost_sum = 0;
		for(int i = 0; i < N; i++) {
			costs[i] = Integer.parseInt(st.nextToken());
			cost_sum += costs[i];
		}
		// dp[cost] = cost 만큼 썼을 때 얻을 수 있는 최대의 메모리
		dp = new int[cost_sum+1];
		for(int i = 0; i < N; i++) {
			for(int j = cost_sum; j >= costs[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j-costs[i]] + memories[i]);
			}
		}
		
		for(int i = 1; i<= cost_sum; i++) {
			if(dp[i] >= M) {
				System.out.println(i);
				break;
			}
		}
	}
	// dp 사용하지 않은 dfs (시간초과)
	/*
	private static void dfs(int memory, int cost) {
		if(memory >= M) {
			ans = Math.min(ans, cost);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			dfs(memory + memories[i], cost + costs[i]);
			visited[i] = false;
		}
	}
	*/
}
