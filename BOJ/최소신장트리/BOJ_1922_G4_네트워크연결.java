package 최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1922_G4_네트워크연결 {
	static int N, M;
	static int[] parents;
	static Edge[] edges;

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		parents = new int[N+1];
		edges = new Edge[M];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			edges[i] = new Edge(from, to, weight);
		}
		
		System.out.println(kruskal());
	}
	
	private static int kruskal() {
		int min = 0, cnt = 0;
		
		// 가중치 오름차순 정렬
		Arrays.sort(edges);
		// 부모 초기화
		make();

		// 간선 이어보기
		for(Edge edge : edges) {
			if(union(edge.from, edge.to)) {
				min += edge.weight;
				
				if(++cnt == N-1) return min;
			}
		}
		
		return min;
	}
	
	private static void make() {
		for(int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		parents[aRoot] = parents[bRoot];
		return true;
	}
	
	private static int find(int a) {
		if(a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	
	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// 간선 가중치를 기준으로 오름차순
			return Integer.compare(this.weight, o.weight);
		}
	}
}
