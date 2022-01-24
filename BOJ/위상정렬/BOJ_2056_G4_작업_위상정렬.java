package 위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 참고 : https://steady-coding.tistory.com/182

public class BOJ_2056_G4_작업_위상정렬 {
	static int N;
	static ArrayList<ArrayList<Integer>> graph;
	static int[] indegree, times;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		graph = new ArrayList<>();
		for(int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		indegree = new int[N+1];
		times = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			times[i] = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			for(int j = 0; j < K; j++) {
				int k = Integer.parseInt(st.nextToken());
				graph.get(i).add(k);
				++indegree[k];
			}
		}
		
		System.out.println(topologySort());
	}
	
	private static int topologySort() {
		Queue<Integer> q = new LinkedList<>();
		
		int[] result = new int[N+1];
		for(int i = 1; i <= N; i++) {
			result[i] = times[i];
			
			if(indegree[i] == 0) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int next : graph.get(cur)) {
				result[next] = Math.max(result[next], result[cur] + times[next]);
				
				if(--indegree[next] == 0) {
					q.add(next);
				}
			}
		}
		
		int minTime = 0;
		for(int i = 1; i <= N; i++) {
			minTime = Math.max(minTime, result[i]);
		}
		return minTime;
	}

}
