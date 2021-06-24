package 최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 다익스트라 알고리즘 설명 : https://blog.naver.com/ndb796/221234424646
 * 참고 : https://steady-coding.tistory.com/82
 */

public class BOJ_1504_G4_특정한최단경로 {
	static int N, E, v1, v2, ans;
	static final int INF = 200000000; // 최대 간선의 개수(2십만) * 최대 길이(1000) = 2억
	static ArrayList<ArrayList<Node>> graph;
	static boolean visited[];
	static int dist[];	// 최단거리 저장 배열
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		visited = new boolean[N+1];
		dist = new int[N+1];
		graph = new ArrayList<>();
		for(int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph.get(a).add(new Node(b, c));
			graph.get(b).add(new Node(a, c));
		}
		st = new StringTokenizer(br.readLine());
		// 꼭 거쳐야 하는 두 개의 정점
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());
		
		int result1 = 0;	// 1 -> v1 -> v2 -> N
		result1 += dijkstra(1, v1);
		result1 += dijkstra(v1, v2);
		result1 += dijkstra(v2, N);
		
		int result2 = 0;	// 1 -> v2 -> v1 -> N
		result2 += dijkstra(1, v2);
		result2 += dijkstra(v2, v1);
		result2 += dijkstra(v1, N);
		
		ans = (result1 >= INF && result2 >= INF ? -1 : Math.min(result1, result2));
		System.out.println(ans);
	}
	
	// from 에서 to로 가는 최단거리를 구하는 다익스트라 함수
	private static int dijkstra(int from, int to) {
		Arrays.fill(dist, INF);
		Arrays.fill(visited, false);
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(from, 0));
		dist[from] = 0;
		
		while(!pq.isEmpty()) {
			Node curNode = pq.poll();
			int cur = curNode.to;
			
			if(!visited[cur]) {
				visited[cur] = true;
				ArrayList<Node> list = graph.get(cur);
				for(Node node : list) {
					if(visited[node.to]) continue;
					if(dist[node.to] > dist[cur] + node.distance) {
						dist[node.to] = dist[cur] + node.distance;
						pq.offer(new Node(node.to, dist[node.to]));
					}
				}
			}
		}
		
		return dist[to];
	}
	
	static class Node implements Comparable<Node> {
		int to, distance;
		
		Node(int to, int distance) {
			this.to = to;
			this.distance = distance;
		}

		@Override
		public int compareTo(Node o) {
			return this.distance - o.distance;
		}
	}
}
