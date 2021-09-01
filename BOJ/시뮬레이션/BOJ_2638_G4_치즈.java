package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2638_G4_치즈 {
	static int N, M;
	static int map[][];
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	static ArrayList<Point> meltCheeseList;
	static int cheeseCnt;
	
	// 2 : 외부공기, 1: 치즈, 0 : 내부공기
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
				if(map[i][j] == 1) ++cheeseCnt;
			}
		}
		int time = 0;
		while(cheeseCnt > 0) {
			meltCheeseList = new ArrayList<>();
			outsideAir();
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] == 1) {
						check(i, j);
					}
				}
			}
			melt();
			print();
			++time;
		}
		System.out.println(time);
	}
	
	private static void print() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	private static void outsideAir() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0, 0));
		boolean visited[][] = new boolean[N][M];
		map[0][0] = 2;
		visited[0][0] = true;
		while(!q.isEmpty()) {
			Point p = q.poll();
			for(int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				if(visited[nr][nc]) continue;
				
				if(map[nr][nc] == 0) {
					map[nr][nc] = 2;
					q.add(new Point(nr, nc));
				}
				else if(map[nr][nc] == 2) {
					q.add(new Point(nr, nc));
				}
				visited[nr][nc] = true;
			}
		}
	}
	
	private static void check(int r, int c) {
		int cnt = 0;
		for(int k = 0; k < 4; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			if(map[nr][nc] == 2) {
				++cnt;
			}
		}
		if(cnt >= 2) {
			meltCheeseList.add(new Point(r, c));
		}
	}
	
	private static void melt() {
		for(Point cheese : meltCheeseList) {
			map[cheese.r][cheese.c] = 2;
		}
		cheeseCnt -= meltCheeseList.size();
	}
	
	static class Point {
		int r, c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
