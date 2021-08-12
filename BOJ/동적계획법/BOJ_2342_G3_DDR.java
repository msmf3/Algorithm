package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 그리디 반례 : 1 3 2 4 1 2 0
 * 답 : 14 그리디 답 : 16
 * 참고 : https://dev-room.tistory.com/30
 */

public class BOJ_2342_G3_DDR {
	static int N;
	static int dp[][][];
	static ArrayList<Integer> dirList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
		StringTokenizer st = new StringTokenizer(br.readLine());
		dirList = new ArrayList<>();
		while(true) {
			int dir = Integer.parseInt(st.nextToken());
			if(dir == 0) break;
			dirList.add(dir);
		}
		N = dirList.size();
		dp = new int[N+1][5][5];
		System.out.println(dfs(N, 0, 0));
	}

	private static int dfs(int n, int left, int right) {
		if(n == 0) {
			return 0;
		}
		if(dp[n][left][right] != 0) {
			return dp[n][left][right];
		}
		
		int next = dirList.get(N-n);
		int left_cost  = dfs(n-1, next, right) + getCost(left, next);
		int right_cost = dfs(n-1, left, next) + getCost(right, next);
		
		return dp[n][left][right] = Math.min(left_cost, right_cost);
	}
	
//	private static int dfs(int n, int left, int right) {
//		if(n == N) {
//			return 0;
//		}
//		if(dp[n][left][right] != 0) {
//			return dp[n][left][right];
//		}
//		
//		int next = dirList.get(n);
//		int left_cost  = dfs(n+1, next, right) + getCost(left, next);
//		int right_cost = dfs(n+1, left, next) + getCost(right, next);
//		
//		return dp[n][left][right] = Math.min(left_cost, right_cost);
//	}
	
	private static int getCost(int cur, int next) {
		if(cur == 0) return 2;
		int c = Math.abs(cur - next);
		if(c == 0) return 1;
		else if(c == 1 || c == 3) return 3;
		else return 4;
	}
}
