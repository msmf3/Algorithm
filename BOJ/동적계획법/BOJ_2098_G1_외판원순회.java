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
 * 
 * 시간초과 반례 : https://www.acmicpc.net/board/view/101462
 *            DP 배열을 max_value로 초기화 했을 때와
 *                    -1로 초기화 하고 tsp 재귀함수에 dp[node][visit] = max_value를 해주는 것은
 *                    출발점으로 돌아오는 방법이 없는 경우에 방문체크 유무에 따라 시간이 달라짐.
 */

public class BOJ_2098_G1_외판원순회 {
	static int N, max_value, ans;
	static int cost[][], dp[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		cost = new int[N][N];
		dp = new int[N][1<<N];
		max_value = 17 * 1000000; // N <= 16, max_cost : 1000000
		ans = max_value;
		
		for(int i = 0; i < N; i++) {
			Arrays.fill(dp[i], -1);
		}
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 0번노드에서 출발
		bw.write(tsp(0, 1) + "\n");
		/*for(int i = 0; i < N; i++) {
			for(int j = 0; j < (1<<N); j++) {
				if(dp[i][j] == max_value) {
					System.out.print("0 ");
				}
				else {
					System.out.print(dp[i][j] + " ");
				}
			}
			System.out.println();
		}*/
		bw.close();
		br.close();
	}
	
	private static int tsp(int node, int visit) {
		if(visit == (1 << N) - 1) {
			// 모든 정점을 방문한 경우 visit == 11111111..
			if(cost[node][0] == 0) return max_value;
			return cost[node][0];
		}
		
		if(dp[node][visit] != -1) {
			// 방문한적이 있는 경우
			return dp[node][visit];
		}
		
		dp[node][visit] = max_value;
		
		for(int i = 0; i < N; i++) {
			if(cost[node][i] == 0 || (visit & (1 << i)) != 0) continue;
			int next = visit | (1 << i);
			dp[node][visit] = Math.min(dp[node][visit], tsp(i, next) + cost[node][i]);
		}
		
		return dp[node][visit];
	}

}
