package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16234_G5_인구이동 {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int N, L, R;
	static int[][] A;
	static int[][] visited;
	static boolean hasUnity;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		A = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		hasUnity = true;
		int day = 0;
		while(true) {
			visited = new int[N][N];
			hasUnity = false;
			
			int area = 0;
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					if(visited[r][c] > 0) continue;
					
					bfs(r,c,++area);
					
				}
			}
			if(!hasUnity) break;
			++day;
		}
		
		System.out.println(day);
	}
	
	private static void bfs(int r, int c, int area) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(r, c));
		visited[r][c] = area;
		
		int cnt = 1;
		int sum = A[r][c];
		Queue<Point> sumQ = new LinkedList<>();
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			sumQ.offer(new Point(p.r, p.c));
			
			for(int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
				if(visited[nr][nc] != 0) continue;
				
				
				int next = A[nr][nc];
				int diff = Math.abs(A[p.r][p.c] - next);
				
				if(L <= diff && diff <= R) {
					visited[nr][nc] = 1;
					q.offer(new Point(nr, nc));
					hasUnity = true;
					sum += A[nr][nc];
					++cnt;
				}
			}
		}
		
		while(!sumQ.isEmpty()) {
			Point p = sumQ.poll();
			
			A[p.r][p.c] = sum / cnt;
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
