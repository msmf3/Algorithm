package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_11559_G4_PuyoPuyo {
	static int N = 12, M = 6;
	static char[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static boolean isPuyo;
	static int puyoCnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new char[N][M];
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		puyoCnt = 0;
		
		 do {
			isPuyo = false;
			visited = new boolean[N][M];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] != '.' && map[i][j] != '*') {
						puyo(i, j);
					}
				}
			}
			
			if(isPuyo) {
				++puyoCnt;
				bomb();
			}
		} while(isPuyo);
		
		System.out.print(puyoCnt);
	}
	
	private static void puyo(int r, int c) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(r, c));
		char color = map[r][c];
		visited = new boolean[N][M];
		visited[r][c] = true;
		
		ArrayList<Point> pyArray = new ArrayList<Point>();
		pyArray.add(new Point(r, c));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			for(int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];
				
				if(nr < 0 || nc < 0 || N <= nr || M <= nc) continue;
				if(visited[nr][nc]) continue;
				
				visited[nr][nc] = true;

				if(map[nr][nc] == '.') continue;
				
				else if(color == map[nr][nc]) {
					q.add(new Point(nr, nc));
					pyArray.add(new Point(nr, nc));
				}
			}
		}
		
		if(4 <= pyArray.size()) {
			isPuyo = true;
			
			for(int i = 0; i < pyArray.size(); i++) {
				Point p = pyArray.get(i);
				map[p.r][p.c] = '*'; 
			}
		}
	}
	
	private static void bomb() {
		for(int c = 0; c < M; c++) {
			int tr = N-1;
			for(int r = N-1; 0 <= r; r--) {
				while(0 <= tr && map[tr][c] == '*') {
					--tr;
				}
				if(tr < 0) {
					map[r][c] = '.';
				}
				else {
					map[r][c] = map[tr][c];
					--tr;
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
