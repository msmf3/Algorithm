package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_21610_G5_마법사상어와비바라기 {
	static int N, M;
	static int map[][];
	static boolean cloud[][];
	static ArrayList<Point> cloudList;
	static int dr[] = {0, -1, -1, -1, 0, 1, 1, 1};
	static int dc[] = {-1, -1, 0, 1, 1, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cloudList = new ArrayList<Point>();
		cloudList.add(new Point(N-1, 1));
		cloudList.add(new Point(N-1, 2));
		cloudList.add(new Point(N, 1));
		cloudList.add(new Point(N, 2));
		cloud = new boolean[N+1][N+1];
		cloud[N-1][1] = cloud[N-1][2] = cloud[N][1] = cloud[N][2] = true;
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			for(int j = 0; j < cloudList.size(); j++) {
				Point p = cloudList.get(j);
				// 1. 구름 이동
				p.r = checkPos(p.r + dr[d-1] * (s%N));
				p.c = checkPos(p.c + dc[d-1] * (s%N));
				// 구름위치 저장
				cloudList.set(j, new Point(p.r, p.c));
				
				// 2. 물의양 +1
				++map[p.r][p.c];
			}
			
			// 3. 구름이 모두 사라진다
			cloud = new boolean[N+1][N+1];
			
			// 4. 물이 증가한 칸에서 물복사버그 시전
			for(int j = 0; j < cloudList.size(); j++) {
				Point p = cloudList.get(j);
				map[p.r][p.c] += checkBucket(p.r, p.c);
				cloud[p.r][p.c] = true;
			}
			
			// 5. 물의 양이 2이상인 곳에서 구름생성. 물양 -2
			cloudList = new ArrayList<Point>();
			cloudy();
		}
		
		// 물의 양 합을 출력
		int ans = 0;
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				ans += map[i][j];
			}
		}
		System.out.println(ans);
	}
	
	private static int checkPos(int p) {
		if(p < 1) return N+p;
		if(p > N) return p-N;
		
		return p;
	}
	
	private static int checkBucket(int r, int c) {
		int cnt = 0;
		if(r-1 > 0 && c-1 > 0 && map[r-1][c-1] > 0) ++cnt;
		if(r-1 > 0 && c+1 <= N && map[r-1][c+1] > 0) ++cnt;
		if(r+1 <= N && c+1 <= N && map[r+1][c+1] > 0) ++cnt;
		if(r+1 <= N && c-1 > 0 && map[r+1][c-1] > 0) ++cnt;
		
		return cnt;
	}
	
	private static void cloudy() {
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(!cloud[i][j] && map[i][j] >= 2) {
					map[i][j] -= 2;
					cloudList.add(new Point(i, j));
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
