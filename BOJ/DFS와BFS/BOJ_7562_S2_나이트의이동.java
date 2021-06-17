package DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7562_S2_나이트의이동 {
	static int N;
	static int map[][];
	static int sr, sc, er, ec;
	static int step;
	static int dr[] = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int dc[] = {-2, -1, 1, 2, -2, -1, 1, 2};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			st = new StringTokenizer(br.readLine());
			sr = Integer.parseInt(st.nextToken()); sc = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			er = Integer.parseInt(st.nextToken()); ec = Integer.parseInt(st.nextToken());
			
			step = 1;
			bfs();
			
			System.out.println(step-1);
		}
	}
	
	private static void bfs() {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(sr, sc));
		map[sr][sc] = 1;
		if(sr == er && sc == ec) return;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			for(int k = 0; k < 8; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				
				if(map[nr][nc] == 0) {
					step = map[nr][nc] = map[p.r][p.c] + 1;
					if(nr == er && nc == ec) return;
					q.offer(new Point(nr, nc));
				}
			}
		}
	}
	
	static class Point {
		int r, c;
		
		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
