package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 위상정렬 참고 : https://jason9319.tistory.com/93
 * 코드 참고 : https://dundung.tistory.com/111
 */

public class BOJ_1005_G3_ACMCraft_위상정렬 {
	static int N;
	static int dp[];
	static int build_times[];
	static int in[];	// 들어오는 간선 수. 위상정렬에 이용
	static int value[];	// 어떤 건물이 지어지는데 까지 걸리는 시간
	static ArrayList<ArrayList<Integer>> graph;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			build_times = new int[N+1];
			dp = new int[N+1];
			in = new int[N+1];
			value = new int[N+1];
			Arrays.fill(dp, -1);
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= N; i++) {
				build_times[i] = Integer.parseInt(st.nextToken());
			}
			graph = new ArrayList<>();
			for(int i = 0; i <= N; i++) {
				graph.add(new ArrayList<>());
			}
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph.get(a).add(b);
				++in[b];
			}
			int W = Integer.parseInt(br.readLine());
			sb.append(topologicalSort(W) + "\n");
		}
		System.out.print(sb.toString());
	}
	
	private static int topologicalSort(int w) {
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i <= N; i++) {
			if(in[i] == 0) {
				q.add(i);
				value[i] = build_times[i];
			}
		}
		
		while(!q.isEmpty()) {
			int u = q.poll();
			for(int v : graph.get(u)) {
				value[v] = Math.max(value[v], value[u] + build_times[v]);
				if(--in[v] == 0) {
					q.add(v);
				}
			}
		}
		return value[w];
	}
}
