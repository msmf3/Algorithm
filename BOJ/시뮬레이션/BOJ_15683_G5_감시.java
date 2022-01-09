package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15683_G5_감시 {
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int N, M, ans;
	static int[][] map;
	static int blindSpotCnt;
	static ArrayList<CCTV> CCTVList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		CCTVList = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) ++blindSpotCnt;
				else if(map[i][j] == 6) ;
				else {
					CCTVList.add(new CCTV(i, j, map[i][j]));
				}
			}
		}
		
		ans = blindSpotCnt;
		dfs(0, blindSpotCnt, map);
		
		System.out.println(ans);
	}
	
	private static void dfs(int idx, int bsCnt, int[][] prevMap) {
		if(idx == CCTVList.size()) {
			ans = Math.min(ans, bsCnt);
			return;
		}
		CCTV cctv = CCTVList.get(idx);
		int[][] curMap;
		int wCnt;
		
		switch(cctv.type) {
		case 1:
			for(int k = 0; k < 4; k++) {
				curMap = copyMap(prevMap);
				wCnt = 0;
				wCnt += watch(cctv.r, cctv.c, k, curMap);
				dfs(idx+1, bsCnt-wCnt, curMap);
			}
			break;
		case 2:
			for(int k = 0; k < 2; k++) {
				curMap = copyMap(prevMap);
				wCnt = 0;
				wCnt += watch(cctv.r, cctv.c, k, curMap);
				wCnt += watch(cctv.r, cctv.c, k+2, curMap);
				dfs(idx+1, bsCnt-wCnt, curMap);
			}
			break;
		case 3:
			for(int k = 0; k < 4; k++) {
				curMap = copyMap(prevMap);
				wCnt = 0;
				wCnt += watch(cctv.r, cctv.c, k, curMap);
				wCnt += watch(cctv.r, cctv.c, (k+1)%4, curMap);
				dfs(idx+1, bsCnt-wCnt, curMap);
			}
			break;
		case 4:
			for(int k = 0; k < 4; k++) {
				curMap = copyMap(prevMap);
				wCnt = 0;
				wCnt += watch(cctv.r, cctv.c, k, curMap);
				wCnt += watch(cctv.r, cctv.c, (k+1)%4, curMap);
				wCnt += watch(cctv.r, cctv.c, (k+2)%4, curMap);
				dfs(idx+1, bsCnt-wCnt, curMap);
			}
			break;
		case 5:
			curMap = copyMap(prevMap);
			wCnt = 0;
			for(int k = 0; k < 4; k++) {
				wCnt += watch(cctv.r, cctv.c, k, curMap);
			}
			dfs(idx+1, bsCnt-wCnt, curMap);
			break;
		}
	}
	
	private static int[][] copyMap(int[][] pMap) {
		int[][] cMap = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				cMap[i][j] = pMap[i][j];
			}
		}
		return cMap;
	}
	
	private static int watch(int r, int c, int d, int[][] tempMap) {
		int watchCnt = 0;
		int nr = r, nc = c;
		while(true) {
			nr = nr + dr[d];
			nc = nc + dc[d];
			if(nr < 0 || nr >= N || nc < 0 || nc >= M) break;
			if(tempMap[nr][nc] == 0) {
				++watchCnt;
				tempMap[nr][nc] = -1;
			}
			else if(tempMap[nr][nc] == 6) {
				break;
			}
		}
		
		return watchCnt;
	}
	
	static class CCTV {
		int r, c, type;
		
		public CCTV(int r, int c, int type) {
			this.r = r;
			this.c = c;
			this.type = type;
		}
	}
}
