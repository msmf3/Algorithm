package 동적계획법;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 어느 노드에서 출발해도 최소 순회 경로는 같음 : https://www.acmicpc.net/board/view/29929
 * 참고 : https://dragon-h.tistory.com/29
 */

public class BOJ_2098_G1_외판원순회 {
	static int N, max_value;
	static int cost[][], dp[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		cost = new int[N][N];
		dp = new int[N][1<<N];
		max_value = 17 * 1000000;
		for(int i = 0; i < N; i++) {
			Arrays.fill(dp[i], max_value);
		}
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 0번노드에서 출발
		bw.write(tsp(0, 1) + "\n");
		bw.close();
		br.close();
	}
	
	private static int tsp(int node, int visit) {
		if(visit == (1 << N) - 1) {
			// 모든 정점을 방문한 경우 visit == 11111111..
			if(cost[node][0] == 0) return max_value;
			return cost[node][0];
		}
		
		if(dp[node][visit] != max_value) {
			// 방문한적이 있는 경우
			return dp[node][visit];
		}
		
		for(int i = 0; i < N; i++) {
			if(cost[node][i] == 0 || (visit & (1 << i)) != 0) continue;
			int next = visit | (1 << i);
			dp[node][visit] = Math.min(dp[node][visit], tsp(i, next) + cost[node][i]);
		}
		return dp[node][visit];
	}

}
