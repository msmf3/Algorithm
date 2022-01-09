package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17089_G5_세친구 {
	static int ans = Integer.MAX_VALUE;
	static boolean[][] graph;
	static int[] frCntArr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		graph = new boolean[N+1][N+1];
		frCntArr = new int[N+1];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u][v] = graph[v][u] = true;
			++frCntArr[u];
			++frCntArr[v];
		}
		
		for(int i = 1; i <= N-2; i++) {
			for(int j = i+1; j <= N-1; j++) {
				if(graph[i][j]) {
					for(int k = j+1; k <= N; k++) {
						if(graph[i][k] && graph[j][k]) {
							ans = Math.min(ans, frCntArr[i] + frCntArr[j] + frCntArr[k] - 6);
						}
					}
				}
			}
		}
		if(ans == Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		}
		System.out.println(ans);
	}
	/*
	private static void go(int frCnt, int cnt, int idx, boolean[] visited) {
		if(cnt == 3) {
			ans = Math.min(ans, (frCnt + graph.get(idx).size()) - 6);
			return;
		}
		
		ArrayList<Integer> node = graph.get(idx);
		for(int i = 0; i < node.size(); i++) {
			visited[i] = true;
			go(node.size(), cnt+1, node.get(i), visited);
			visited[i] = false;
		}
	}
	*/
}
