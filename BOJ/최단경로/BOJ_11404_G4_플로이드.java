package 최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11404_G4_플로이드 {
	static int N, M, INF;
	static int D[][];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		INF = 100_000_001;
		D = new int[N+1][N+1];
		for(int i = 0; i <= N; i++) {
			Arrays.fill(D[i], INF);
			D[i][i] = 0;
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			D[from][to] = Math.min(D[from][to], cost);
		}
		
		floyd();
		print();
	}
	
	private static void floyd() {
		for(int mid = 1; mid <= N; mid++) {
			for(int start = 1; start <= N; start++) {
				for(int end = 1; end <= N; end++) {
					D[start][end] = Math.min(D[start][end], D[start][mid] + D[mid][end]);
				}
			}
		}
	}
	
	private static void print() {
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(D[i][j] == INF) {
					sb.append("0 ");
				}
				else {
					sb.append(D[i][j] + " ");
				}
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
}
