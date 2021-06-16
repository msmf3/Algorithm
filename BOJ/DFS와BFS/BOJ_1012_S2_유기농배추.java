package DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1012_S2_유기농배추 {
	static int M, N;
	static int map[][];
	static int earthworm;
	static int dx[] = {0, 0, -1, 1};
	static int dy[] = {-1, 1, 0, 0};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			
			int K = Integer.parseInt(st.nextToken());
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				map[Y][X] = 1;
			}
			earthworm = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] == 1) {
						bfs(j, i);
						++earthworm;
					}
				}
			}
			System.out.println(earthworm);
		}
	}

	private static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(x, y));
		map[y][x] = -1;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			for(int k = 0; k < 4; k++) {
				int nx = p.x + dx[k];
				int ny = p.y + dy[k];
				
				if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
				
				if(map[ny][nx] == 1) {
					q.offer(new Point(nx, ny));
					map[ny][nx] = -1;
				}
			}
		}
	}
	
	static class Point {
		int x, y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
