package 최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 참고 : https://data-make.tistory.com/519
 */

public class BOJ_1197_G4_최소스패닝트리_프림 {
	static int V, E;
	static int weightSum = 0;
	static ArrayList<ArrayList<Node>> graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		graph = new ArrayList<ArrayList<Node>>();
		for(int i = 0; i < V+1; i++) {
			graph.add(new ArrayList<Node>());
		}
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			graph.get(A).add(new Node(B, C));
			graph.get(B).add(new Node(A, C));
		}
		
		prim();
		
		System.out.println(weightSum);
	}

	private static void prim() {
		boolean[] visited = new boolean[V+1];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		// 1번 노드부터
		pq.add(new Node(1, 0));
		
		int cnt = 0;
		while(!pq.isEmpty()) {
			Node edge = pq.poll();
			// 이미 방문한 정점인 경우 pass
			if(visited[edge.to]) continue;
			
			visited[edge.to] = true;
			weightSum += edge.weight;
			
			if(++cnt == V) return;
			
			ArrayList<Node> list = graph.get(edge.to);
			for(int i = 0; i < list.size(); i++) {
				Node next = list.get(i);
				if(visited[next.to]) continue;
				
				pq.add(next);
			}
		}
	}
	
	static class Node implements Comparable<Node> {
		int to, weight;
		
		Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			// 오름차순
			return Integer.compare(this.weight, o.weight);
		}
	}
}
