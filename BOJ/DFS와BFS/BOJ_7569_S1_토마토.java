package DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7569_S1_토마토 {
	static int M, N, H;
	static int map[][][];
	static int greenTomatoCnt, days;
	static int dr[] = {-1, 1, 0, 0, 0, 0};
	static int dc[] = {0, 0, -1, 1, 0, 0};
	static int dh[] = {0, 0, 0, 0, -1, 1};
	static Queue<Point> q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][N][M];
		greenTomatoCnt = 0; days = 1;
		q = new LinkedList<>();
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k = 0; k < M; k++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
					if(map[i][j][k] == 0) {
						++greenTomatoCnt;
					}
					else if(map[i][j][k] == 1) {
						q.add(new Point(j, k, i));
					}
				}
			}
		}
		if(greenTomatoCnt == 0) {
			System.out.println(0);
			System.exit(0);
		}
		
		bfs();
		if(greenTomatoCnt > 0) {
			System.out.println(-1);
		}
		else {
			System.out.println(--days);
		}
	}
	
	private static void bfs() {
		while(!q.isEmpty()) {
			Point p = q.poll();
			for(int k = 0; k < 6; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];
				int nh = p.h + dh[k];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || nh < 0 || nh >= H) continue;
				
				if(map[nh][nr][nc] == 0) {
					--greenTomatoCnt;
					q.offer(new Point(nr, nc, nh));
					days = map[nh][nr][nc] = map[p.h][p.r][p.c] + 1;
				}
			}
		}
	}
	
	static class Point {
		int r, c, h;
		
		Point(int r, int c, int h) {
			this.r = r;
			this.c = c;
			this.h = h;
		}
	}
}
