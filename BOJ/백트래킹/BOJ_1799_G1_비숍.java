package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 참고 : https://j2wooooo.tistory.com/80
 */

public class BOJ_1799_G1_비숍 {
	static int N, gIdx;
	static int ans[];
	static int map[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = new int[2];
		// 흑,백 타일에 따라 백트래킹
		dfs(0, 0);
		gIdx = 1;
		dfs(1, 0);
		System.out.println(ans[0] + ans[1]);
	}
	
	private static void dfs(int idx, int cnt) {
		if(idx >= N*N) {
			ans[gIdx] = Math.max(ans[gIdx], cnt);
			return;
		}
		int r = idx / N, c = idx % N;
		int next = idx+1;
		// 흑,백 타일은 (r+c)가 짝,홀 임을 이용해 다음 idx를 구함
		// N이 짝수일 때의 예외도 해결 가능
		while((next / N + next % N) % 2 != (r+c) % 2) ++next;
		if(map[r][c] == 1) {
			if(isPossible(r, c)) {
				map[r][c] = 2;
				dfs(next, cnt+1);
				map[r][c] = 1;
			}
		}
		dfs(next, cnt);
	}
	
	private static boolean isPossible(int r, int c) {
		// 좌상
		for(int i = 1; r-i >= 0 && c-i >= 0; i++) {
			if(map[r-i][c-i] == 2) return false;
		}
		// 우상
		for(int i = 1; r-i >= 0 && c+i < N; i++) {
			if(map[r-i][c+i] == 2) return false;
		}
		// 좌하
		for(int i = 1; r+i < N && c-i >= 0; i++) {
			if(map[r+i][c-i] == 2) return false;
		}
		// 우하
		for(int i = 1; r+i < N && c+i < N; i++) {
			if(map[r+i][c+i] == 2) return false;
		}
		return true;
	}

}
