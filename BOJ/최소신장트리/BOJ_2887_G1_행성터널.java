package 최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 참고 : https://steady-coding.tistory.com/117
 * x좌표, y좌표, z좌표별로 각각 정렬하여 푸는 것이 핵심
 * 모든 Edge를 다 구하려고 하면 메모리 초과가 난다
 */

public class BOJ_2887_G1_행성터널 {
	static int N, ans;
	static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		Planet planet[] = new Planet[N];
		for(int i = 0; i < N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			planet[i] = new Planet(x, y, z, i);
		}
		// x좌표를 기준으로 정렬.
		Arrays.sort(planet, (p1, p2) -> p1.x - p2.x);
		for(int i = 0; i < N-1; i++) {
			int cost = Math.abs(planet[i].x - planet[i+1].x);
			graph.get(planet[i].idx).add(new Node(planet[i+1].idx, cost));
			graph.get(planet[i+1].idx).add(new Node(planet[i].idx, cost));
		}
		// y좌표를 기준으로 정렬.
		Arrays.sort(planet, (p1, p2) -> p1.y - p2.y);
		for(int i = 0; i < N-1; i++) {
			int cost = Math.abs(planet[i].y - planet[i+1].y);
			graph.get(planet[i].idx).add(new Node(planet[i+1].idx, cost));
			graph.get(planet[i+1].idx).add(new Node(planet[i].idx, cost));
		}
		
		// z좌표를 기준으로 정렬.
		Arrays.sort(planet, (p1, p2) -> p1.z - p2.z);
		for(int i = 0; i < N-1; i++) {
			int cost = Math.abs(planet[i].z - planet[i+1].z);
			graph.get(planet[i].idx).add(new Node(planet[i+1].idx, cost));
			graph.get(planet[i+1].idx).add(new Node(planet[i].idx, cost));
		}
		prim();
		System.out.println(ans);
	}
	
	private static void prim() {
		boolean visited[] = new boolean[N];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(0, 0));
		int cnt = 0;
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(visited[cur.to]) continue;
			visited[cur.to] = true;
			
			ans += cur.cost;
			if(++cnt == N) return;
			
			ArrayList<Node> list = graph.get(cur.to);
			for(int i = 0; i < list.size(); i++) {
				Node next = list.get(i);
				if(visited[next.to]) continue;
				pq.add(next);
			}
		}
	}
	
	static class Planet {
		int x, y, z, idx;
		
		public Planet(int x, int y, int z, int idx) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.idx = idx;
		}
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
