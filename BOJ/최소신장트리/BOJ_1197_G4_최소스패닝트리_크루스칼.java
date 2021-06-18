package 최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 참고 : https://data-make.tistory.com/519
 */

public class BOJ_1197_G4_최소스패닝트리_크루스칼 {
	static int V, E, weightSum;
	static int parents[];
	static Edge[] edgeList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		parents = new int[V+1];
		edgeList = new Edge[E];
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(A, B, C);
		}
		
		weightSum = 0;
		kruskal();
		
		System.out.println(weightSum);
	}
	
	private static void kruskal() {
		int cnt = 0;
		
		Arrays.sort(edgeList);
		make();
		
		for(Edge edge : edgeList) {
			// 싸이클이 형성되지 않으면
			if(union(edge.from, edge.to)) {
				weightSum += edge.weight;
				if(++cnt == V-1) return;
			}
		}
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		parents[aRoot] = bRoot;
		return true;
	}
	
	private static int find(int a) {
		if(a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	
	private static void make() {
		// 정점 parents 배열 초기화
		for(int i = 1; i <= V; i++) {
			parents[i] = i;
		}
	}

	static class Edge implements Comparable<Edge> {
		int from, to, weight;
		
		Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// 간선 가중치 기준으로 오름차순 정렬
			return Integer.compare(this.weight, o.weight);
		}
	}
}
