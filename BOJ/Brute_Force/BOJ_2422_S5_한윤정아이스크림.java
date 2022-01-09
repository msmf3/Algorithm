package Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2422_S5_한윤정아이스크림 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[][] graph = new boolean[N+1][N+1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u][v] = graph[v][u] = true;
		}
		
		int cnt = 0;
		for(int i = 1; i <= N-2; i++) {
			for(int j = i+1; j <= N-1; j++) {
				if(!graph[i][j]) {
					for(int k = j+1; k <= N; k++) {
						if(!graph[i][k] && !graph[j][k]) {
							++cnt;
						}
					}
				}
				
			}
		}
		
		System.out.println(cnt);
	}

}
