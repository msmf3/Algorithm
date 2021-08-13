package Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 참고 : https://suriisurii.tistory.com/61
 */

public class BOJ_1007_G2_벡터매칭 {
	static int N;
	static double ans;
	static Point points[];
	static boolean isMinus[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			points = new Point[N];
			isMinus = new boolean[N];
			ans = Double.MAX_VALUE;
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				points[i] = new Point(x, y);
			}
			dfs(0, 0);
			sb.append(ans + "\n");
		}
		System.out.println(sb.toString());
	}
	
	private static void dfs(int cnt, int idx) {
		if(idx >= N) {
			return;
		}
		if(cnt == N/2) {
			double sumX = 0, sumY = 0;
			for(int i = 0; i < N; i++) {
				if(isMinus[i]) {
					sumX -= points[i].x;
					sumY -= points[i].y;
				}
				else {
					sumX += points[i].x;
					sumY += points[i].y;
				}
			}
			ans = Math.min(ans, Math.sqrt(sumX * sumX + sumY * sumY));
			return;
		}
		// minus 체크안하고
		dfs(cnt, idx + 1);
		isMinus[idx] = true;
		// minus 체크
		dfs(cnt + 1, idx + 1);
		isMinus[idx] = false;
	}
	
	static class Point {
		int x, y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
