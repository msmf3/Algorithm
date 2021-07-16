package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 참고 : https://pangtrue.tistory.com/302
 */

public class BOJ_11066_G3_파일합치기_Knuth {
	static int K;
	static int files[], sum[], dp[][], kn[][];
	
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
			kn = new int[K+1][K+1];
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= K; i++) {
				files[i] = Integer.parseInt(st.nextToken());
				sum[i] = sum[i-1] + files[i];
			}
			
			for(int i = 1; i <= K; i++) {
				kn[i][i] = i;
			}
			
			for(int i = 1; i <= K; i++) {	// 1장 ~ K장 까지 묶음
				for(int from = 1; from+i <= K; from++) {	// from
					int to = from+i;
					dp[from][to] = Integer.MAX_VALUE;
					for(int div = kn[from][to-1]; div <= kn[from+1][to]; div++) {		// 두 덩이로 나눌 기준점 idx
						int v = dp[from][div] + dp[div+1][to] + (sum[to] - sum[from-1]);
						if(dp[from][to] > v) {
							dp[from][to] = v;
							kn[from][to] = div;
						}
					}
				}
			}
			
			
			sb.append(dp[1][K] + "\n");
		}
		System.out.print(sb.toString());
	}

}
