package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11049_G3_행렬곱셈순서 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Matrix arr[] = new Matrix[N+1];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			arr[i] = new Matrix(r, c);
		}
		int dp[][] = new int[N+1][N+1];
		for(int i = 1; i < N; i++) {
			for(int from = 1; from + i <= N; from++) {
				int to = from + i;
				dp[from][to] = Integer.MAX_VALUE;
				for(int div = from; div < to; div++) {
					int case1 = dp[from][div] + (arr[from].r * arr[div].c * arr[to].c) + dp[div+1][to];
					dp[from][to] = Math.min(dp[from][to], case1);
				}
			}
		}
		
//		for(int i = 1; i <= N; i++) {
//			for(int j = 1; j <= N; j++) {
//				System.out.print(dp[i][j] + " ");
//			}
//			System.out.println();
//		}
		System.out.println(dp[1][N]);
	}
	
	static class Matrix {
		int r, c;
		
		public Matrix(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

}
