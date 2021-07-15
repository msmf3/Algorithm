package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 참고 : https://st-lab.tistory.com/131
 */

public class BOJ_1932_S1_정수삼각형 {
	static int N;
	static int arr[][], dp[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1][N+1];
		dp = new int[N+1][N+1];
		for(int a[] : dp) {
			Arrays.fill(a, -1);
		}
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= i; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(i == N) {
					dp[i][j] = arr[i][j];
				}
			}
		}
		
		System.out.println(getMaxSum(1, 1));
	}
	
	private static int getMaxSum(int depth, int idx) {
		if(dp[depth][idx] == -1) {
			dp[depth][idx] = arr[depth][idx] + Math.max(getMaxSum(depth+1, idx), getMaxSum(depth+1, idx+1));
		}
		
		return dp[depth][idx];
	}

}
