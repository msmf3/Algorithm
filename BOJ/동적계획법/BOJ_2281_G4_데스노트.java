package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 참고 : https://nim-code.tistory.com/151

public class BOJ_2281_G4_데스노트 {
	static int N, M;
	static int[] nameArr;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		if(N == 1) {
			System.out.println(pow(M-N));
			return;
		}
		
		nameArr = new int[N];
		for(int i = 0; i < N; i++) {
			nameArr[i] = Integer.parseInt(br.readLine());
		}
		
		dp = new int[1001][1001];
		for(int i = 0; i < N; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		System.out.println(dfs(0, 0));
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	private static int pow(int a) {
		return a * a;
	}
	
	private static int dfs(int colIdx, int nameIdx) {
		if(nameIdx >= N) return 0;
		
		// 이미 체크한 곳이라면
		if(dp[nameIdx][colIdx] != -1) {
			return dp[nameIdx][colIdx];
		}
		
		// 다음 줄에 쓰는 경우
		dp[nameIdx][colIdx] = pow(M - colIdx + 1) + dfs(nameArr[nameIdx] + 1, nameIdx + 1);
		
		// 같은 줄에 쓰는 경우
		if(colIdx + nameArr[nameIdx] <= M) {
			dp[nameIdx][colIdx] = Math.min(dp[nameIdx][colIdx], dfs(colIdx + nameArr[nameIdx] + 1, nameIdx + 1));
		}
		
		return dp[nameIdx][colIdx];
	}
}
