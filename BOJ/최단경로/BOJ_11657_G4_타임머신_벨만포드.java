package 최단경로;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 벨만포드 : https://ratsgo.github.io/data%20structure&algorithm/2017/11/27/bellmanford/
 * 참고 : https://steady-coding.tistory.com/92
 */

public class BOJ_11657_G4_타임머신_벨만포드 {
	static int N, M;
	static ArrayList<ArrayList<City>> graph;
	static final int INF = Integer.MAX_VALUE;
	// 500 * 6000 * 10000 -> int 값 범위 초과
	static long dist[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new ArrayList<ArrayList<City>>();
		dist = new long[N+1];
		for(int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
			dist[i] = INF;
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			// 방향 그래프
			graph.get(A).add(new City(B, C));
		}
		
		StringBuilder sb = new StringBuilder();
		if(!bellmanFord()) {	// 음수 사이클 발생
			sb.append("-1");
		}
		else {
			for(int i = 2; i <= N; i++) {
				if(dist[i] == INF) {
					sb.append("-1\n");
				}
				else {
					sb.append(dist[i] + "\n");
				}
			}
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	private static boolean bellmanFord() {
		dist[1] = 0;	// 1부터 시작. 시작점은 초기화
		boolean update = false;
		
		// (N-1) 번 동안 최단거리(dist배열) 초기화 진행
		for(int i = 1; i < N; i++) {
			for(int j = 1; j <= N; j++) {
				// 도달할 수 없는 곳은 넘김
				if(dist[j] == INF) continue;
				ArrayList<City> list = graph.get(j);
				for(City city : list) {
					if(dist[city.to] > dist[j] + city.time) {
						dist[city.to] = dist[j] + city.time;
						update = true;
					}
				}
			}
			
			if(!update) {
				// 업데이트가 일어나지 않으면 더 이상 초기화되지 않으므로 break
				break;
			}
		}
		
		// 마지막에 update가 일어난 경우 - 음수 사이클이 발생할 수 있음
		if(update) {
			// 모든 엣지를 방문하고 음수 사이클이 일어나는지 확인
			for(int i = 1; i < N; i++) {
				if(dist[i] == INF) continue;
				ArrayList<City> list = graph.get(i);
				for(City city : list) {
					if(dist[city.to] > dist[i] + city.time) {
						return false;
					}
				}
			}
		}
		
		return true;
	}
	
	static class City {
		int to, time;
		
		City(int to, int time) {
			this.to = to;
			this.time = time;
		}
	}
}
