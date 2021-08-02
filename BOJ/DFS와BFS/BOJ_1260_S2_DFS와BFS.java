package DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_S2_DFS와BFS {
	static int N, M, V;
	static ArrayList<ArrayList<Integer>> graph;
	static boolean visited[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		graph = new ArrayList<>();
		for(int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Integer>());
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		for(int i = 1; i <= N; i++) {
			ArrayList<Integer> list = graph.get(i);
			Collections.sort(list);
		}
		visited = new boolean[N+1];
		dfs(V);
		sb.append("\n");
		bfs();
		System.out.println(sb.toString());
	}
	
	private static void dfs(int num) {
		visited[num] = true;
		sb.append(num + " ");
		ArrayList<Integer> list = graph.get(num);
		Iterator<Integer> value = list.iterator();
		while(value.hasNext()) {
			int next = value.next();
			if(!visited[next]) {
				dfs(next);
			}
		}
	}
	
	private static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		visited = new boolean[N+1];
		visited[V] = true;
		q.add(V);
		while(!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur + " ");
			ArrayList<Integer> list = graph.get(cur);
			Iterator<Integer> value = list.iterator();
			while(value.hasNext()) {
				int next = value.next();
				if(!visited[next]) {
					q.add(next);
					visited[next] = true;
				}
			}
		}
	}
}
