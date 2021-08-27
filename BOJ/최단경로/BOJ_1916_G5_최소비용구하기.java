package 최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1916_G5_최소비용구하기 {
	static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
	static boolean visited[];
	static int minCost[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		visited = new boolean[N+1];
		minCost = new int[N+1];
		Arrays.fill(minCost, Integer.MAX_VALUE);
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			graph.get(A).add(new Node(B, cost));
		}
		st = new StringTokenizer(br.readLine());
		int startPoint = Integer.parseInt(st.nextToken());
		int endPoint = Integer.parseInt(st.nextToken());
		System.out.print(dijkstra(startPoint, endPoint));
	}
	
	private static int dijkstra(int from, int to) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(from, 0));
		minCost[from] = 0;
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			if(visited[cur.to]) continue;
			visited[cur.to] = true;
			ArrayList<Node> list = graph.get(cur.to);
			for(Node next : list) {
				if(visited[next.to]) continue;
				if(minCost[next.to] > minCost[cur.to] + next.cost) {
					minCost[next.to] = minCost[cur.to] + next.cost;
					pq.add(new Node(next.to, minCost[next.to]));
				}
			}
		}
		return minCost[to];
		}
		
	static class Node implements Comparable<Node> {
		int to, cost;
		
		public Node(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
}
