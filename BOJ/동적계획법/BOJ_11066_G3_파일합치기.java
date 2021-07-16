package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 참고 : https://guy-who-writes-sourcecode.tistory.com/43
 */

/**
 * memoization dp
 * 점화식
 * dp[i][j] = i부터 j장까지 합치는 비용
 * dp[i][i] = novel[i]
 * dp[i][i + 1] = novel[i] + novel[i+1]
 */

public class BOJ_11066_G3_파일합치기 {
	static int K;
	static int files[], sum[], dp[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			K = Integer.parseInt(br.readLine());
			files = new int[K+1];
			sum = new int[K+1];
			dp = new int[K+1][K+1];
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= K; i++) {
				files[i] = Integer.parseInt(st.nextToken());
				sum[i] = sum[i-1] + files[i];
			}
			
			for(int i = 1; i <= K; i++) {	// 1장 ~ K장 까지 묶음
				for(int from = 1; from+i <= K; from++) {	// from
					int to = from+i;
					dp[from][to] = Integer.MAX_VALUE;
					for(int div = from; div < to; div++) {		// 두 덩이로 나눌 기준점 idx
						dp[from][to] = Math.min(dp[from][to], dp[from][div] + dp[div+1][to] + (sum[to] - sum[from-1]));
					}
				}
			}
			
			
			sb.append(dp[1][K] + "\n");
		}
		System.out.print(sb.toString());
	}

}
