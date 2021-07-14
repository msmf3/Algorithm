package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 참고 : https://hidelookit.tistory.com/171
 */

public class BOJ_1520_G4_내리막길 {
	static int M, N;
	static int map[][], dp[][];
	static boolean visited[][];
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M+1][N+1];
		dp = new int[M+1][N+1];
		dp[1][1] = 1;
		visited = new boolean[M+1][N+1];
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited[1][1] = true;
		dfs(M, N);
		for(int i = 0; i <= M; i++) {
			for(int j = 0; j <= N; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		System.out.print(dp[M][N]);
	}
	
	private static int dfs(int r, int c) {
		if(r == 1 && c == 1) {
			return 1;
		}
		if(visited[r][c]) {
			return dp[r][c];
		}
		
		for(int k = 0; k < 4; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			
			if(nr < 1 || nr > M || nc < 1 || nc > N) continue;
			
			// 오르막길이면 continue
			if(map[nr][nc] <= map[r][c]) continue;
			
			dp[r][c] += dfs(nr, nc);
		}
		
		visited[r][c] = true;
		return dp[r][c];
	}

}
