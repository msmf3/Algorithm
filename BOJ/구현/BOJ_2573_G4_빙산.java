package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2573_G4_빙산 {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int islandCnt;
	static int dayCnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		islandCnt = 0;
		dayCnt = 0;
		while(islandCnt < 2) {
			melt();
			++dayCnt;
			if(islandCnt == 0) break;
		}
		
		if(islandCnt == 0) {
			System.out.println(islandCnt);
		}
		else {
			System.out.println(dayCnt);
		}
	}
	
	private static void melt() {
		int[][] copyMap = new int[N][M];
		for(int i = 0; i < N; i++) {
			copyMap[i] = map[i].clone();
		}
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				int wCnt = 0;
				for(int k = 0; k < 4; k++) {
					int nr = r + dr[k];
					int nc = c + dc[k];
					
					if( nr < 0 || N <= nr || nc < 0 || M <= nc ) continue;
					
					int height = map[nr][nc];
					
					if(height == 0) {
						wCnt++;
					}
				}
				copyMap[r][c] = Math.max(0, copyMap[r][c] - wCnt);
			}
		}
		
		for(int i = 0; i < N; i++) {
			map[i] = copyMap[i].clone();
		}
		
		countIsland();
	}
	
	private static void countIsland() {
		visited = new boolean[N][M];
		islandCnt = 0;
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(!visited[r][c] && 0 < map[r][c]) {
					++islandCnt;
					bfs(r, c);
				}
			}
		}
	}
	
	private static void bfs(int r, int c) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(r, c));
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for(int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];
				
				if( nr < 0 || N <= nr || nc < 0 || M <= nc ) continue;
				if( visited[nr][nc] ) continue;
				
				if(map[nr][nc] > 0) {
					visited[nr][nc] = true;
					q.add(new Point(nr, nc));
				}
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
