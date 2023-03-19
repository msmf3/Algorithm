package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15684_G3_사다리조작 {
	static int N, M, H;
	static int ans, addCnt;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		ans = -1;
		
		map = new int[H+1][2*N+3];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b*2] = 1;
		}
		
		if(correctLadder()) {
			System.out.println(0);
			return;
		}
		
		for(int i = 1; i <= 3; i++) {
			addCnt = i;
			dfs(1, 2, 0);
			
			if(ans > 0) {
				System.out.println(ans);
				return;
			}
		}
		
		System.out.println(ans);
	}
	
	private static boolean correctLadder() {
		for(int i = 1; i <= N; i++) {
			int f = -1;
			int r = 1, c = i*2-1;
			
			while(r <= H) {
				if(map[r][c-1] == 1) {
					c -= 2;
				}
				else if(map[r][c+1] == 1) {
					c += 2;
				}
				++r;
			}
			
			if(i != c/2 + 1) return false;
		}
			
		return true;
	}
	
	private static void dfs(int R, int C, int cnt) {
		if(cnt == addCnt) {
			if(correctLadder()) {
				ans = cnt;
			}
			return;
		}
		
		if(ans > 0) return;
		
		for(int i = R; i <= H; i++) {
			for(int j = 2; j < 2*N; j+=2) {
				if(map[i][j] == 1 || map[i][j-2] == 1 || map[i][j+2] == 1) continue;
				
				map[i][j] = 1;
				dfs(i, j, cnt+1);
				map[i][j] = 0;
			}
		}
	}
}
