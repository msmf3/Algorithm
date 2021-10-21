package DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10026_G5_적록색약 {
	static int N;
	static char[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		visited = new boolean[N][N];
		int areaCnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					dfs(i, j, map[i][j]);
					++areaCnt;
				}
			}
		}
		
		int RGWeaknessAreaCnt = 0;
		visited = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					dfsRGWeakness(i, j, map[i][j]);
					++RGWeaknessAreaCnt;
				}
			}
		}
		
		System.out.println(areaCnt + " " + RGWeaknessAreaCnt);
	}
	
	private static void dfs(int r, int c, char color) {
		visited[r][c] = true;
		
		for(int k = 0; k < 4; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
			if(visited[nr][nc]) continue;
			
			if(map[nr][nc] == color) {
				dfs(nr, nc, color);
			}
		}
	}
	
	private static void dfsRGWeakness(int r, int c, char color) {
		visited[r][c] = true;
		char color2 = 'B';
		if(color == 'R') color2 = 'G';
		else if(color == 'G') color2 = 'R';
		
		for(int k = 0; k < 4; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
			if(visited[nr][nc]) continue;
			
			if(map[nr][nc] == color || map[nr][nc] == color2) {
				dfsRGWeakness(nr, nc, color);
			}
		}
	}
	
	static class Point {
		int r, c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
