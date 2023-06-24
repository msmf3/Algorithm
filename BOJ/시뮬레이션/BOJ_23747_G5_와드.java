package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_23747_G5_와드 {
	static int R, C;
	static char map[][];
	static int sR, sC;
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R+2][C+2];
		for(int i = 1; i <= R; i++) {
			String line = br.readLine();
			for(int j = 1; j <= C; j++) {
				map[i][j] = line.charAt(j-1);
			}
		}
		
		st = new StringTokenizer(br.readLine());
		sR = Integer.parseInt(st.nextToken());
		sC = Integer.parseInt(st.nextToken());
		
		String cm = br.readLine();
		for(int i = 0; i < cm.length(); i++) {
			char command = cm.charAt(i);
			
			switch(command) {
			case 'W':
				warding();
				break;
			case 'U':
				--sR;
				break;
			case 'D':
				++sR;
				break;
			case 'L':
				--sC;
				break;
			case 'R':
				++sC;
				break;
			}
		}
		
		map[sR][sC] = '.';
		map[sR-1][sC] = '.';
		map[sR+1][sC] = '.';
		map[sR][sC-1] = '.';
		map[sR][sC+1] = '.';
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= R; i++) {
			for(int j = 1; j <= C; j++) {
				sb.append(map[i][j] == '.' ? '.' : '#');
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	private static void warding() {
		char w = map[sR][sC];
		if(w == '.') return;
		map[sR][sC] = '.';
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(sR, sC));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for(int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];
				
				if(map[nr][nc] == w) {
					map[nr][nc] = '.';
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
