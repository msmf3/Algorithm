package 최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1865_G3_웜홀 {
	static ArrayList<Node> graph;
	static int dist[];
	static int N;
	static int INF = 5_000_001;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			graph = new ArrayList<>();
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				graph.add(new Node(S, E, T));
				graph.add(new Node(E, S, T));
			}
			for(int i = 0; i < W; i++) {
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				graph.add(new Node(S, E, -T));
			}
			
			if(!bellmanford()) {
				sb.append("YES\n");
			}
			else {
				sb.append("NO\n");
			}
		}
		System.out.println(sb.toString());
	}

	private static boolean bellmanford() {
		boolean update = false;
		dist = new int[N+1];
		Arrays.fill(dist, INF);
		dist[1] = 0;
		for(int i = 1; i <= N; i++) {
			update = false;
			for(int j = 0; j < graph.size(); j++) {
				Node node = graph.get(j);
				if(dist[node.to] > dist[node.from] + node.time) {
					dist[node.to] = dist[node.from] + node.time;
					update = true;
				}
			}
			// 갱신되지 않았으면 앞으로도 갱신되지 않음
			if(!update) {
				break;
			}
		}
		// 마지막까지 갱신되었다면 음의 사이클을 의심
		if(update) {
			// 한번더 돌면서 갱신된다면 음의 사이클임(무한갱신)
			for(int j = 0; j < graph.size(); j++) {
				Node node = graph.get(j);
				if(dist[node.to] > dist[node.from] + node.time) {
					return false;
				}
			}
		}
		return true;
	}
	
	static class Node {
		int from, to, time;
		
		public Node(int from, int to, int time) {
			this.from = from;
			this.to = to;
			this.time = time;
		}
	}
}
