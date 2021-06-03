package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9663_G5_NQueen {
	static int map[];
	static int N, ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		// 배열의 index : 행, 저장된 값 : 열
		map = new int[N];
		ans = 0;
		
		nQueen(0);
		System.out.println(ans);
	}

	private static void nQueen(int row) {
		if(row == N) {
			++ans;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			map[row] = i;
			if(canPut(row)) {
				nQueen(row+1);
			}
		}
	}

	private static boolean canPut(int row) {
		for(int i = 0; i < row; i++) {
			// 같은 열에 겹침
			if(map[row] == map[i]) {
				return false;
			}
			
			// 대각선방향 : 열과 행의 차가 같은 경우
			if(Math.abs(row - i) == Math.abs(map[row] - map[i])) {
				return false;
			}
		}
		return true;
	}

}
