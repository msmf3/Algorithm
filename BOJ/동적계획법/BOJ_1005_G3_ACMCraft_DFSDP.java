package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
	 참고 : https://cocoon1787.tistory.com/129
	 FAQ : https://www.acmicpc.net/board/view/30959
	 목적건물에서부터 BFS 로 풀면 중간에 어떤 건물을 지을 때 시작 건물부터 그 건물까지의 규칙의 수가 다를 수도 있기 때문에 
	 BFS로 풀 수 없는 문제이다. BFS로 풀면 예제는 다 답이 나오지만 반례가 있음.
	 DFS로 풀 수 있지만 지수 복잡도의 풀이가 된다. 그러므로 추가로 DP 메모이제이션을 이용해야 한다.
*/
public class BOJ_1005_G3_ACMCraft_DFSDP {
	static int dp[];
	static int build_times[];
	static ArrayList<ArrayList<Integer>> graph;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			build_times = new int[N+1];
			dp = new int[N+1];
			Arrays.fill(dp, -1);
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= N; i++) {
				build_times[i] = Integer.parseInt(st.nextToken());
			}
			graph = new ArrayList<>();
			for(int i = 0; i <= N; i++) {
				graph.add(new ArrayList<>());
			}
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph.get(b).add(a);
			}
			int W = Integer.parseInt(br.readLine());
			ArrayList<Integer> buildingList = new ArrayList<>();
			buildingList.add(W);
			dfs(W);
			/*
			for(int i = 0; i < N; i++) {
				System.out.print(dp[i] + " ");
			}
			System.out.println();
			*/
			sb.append(dp[W] + "\n");
		}
		System.out.print(sb.toString());
	}
	
	
	private static int dfs(int w) {
//		System.out.println(w);
		if(dp[w] != -1) {
			return dp[w];
		}
		ArrayList<Integer> list = graph.get(w);
		int max = 0;
		for(int a : list) {
			max = Math.max(max, dfs(a));
		}
		dp[w] = build_times[w] + max;
		return dp[w];
	}
}
