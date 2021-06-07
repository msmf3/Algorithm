package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2630_S3_색종이만들기 {
	static int N;
	static int map[][];
	static int whiteCnt, blueCnt;
	
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
		// 0 : white, 1 : blue
		countColorPaper(0, 0, N);
		System.out.println(whiteCnt);
		System.out.println(blueCnt);
	}
	
	private static void countColorPaper(int sr, int sc, int size) {
		if(isSameColor(sr, sc, size)) {
			// white
			if(map[sr][sc] == 0) {
				++whiteCnt;
			}
			else {
				++blueCnt;
			}
			return;
		}
		
		size /= 2;
		
		countColorPaper(sr, sc + size, size);	// 1사분면
		countColorPaper(sr, sc, size);			// 2사분면
		countColorPaper(sr + size, sc, size);	// 3사분면
		countColorPaper(sr+size, sc+size, size);// 4사분면
	}
	
	private static boolean isSameColor(int sr, int sc, int size) {
		int color = map[sr][sc];
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				if(color != map[sr+i][sc+j]) {
					return false;
				}
			}
		}
		return true;
	}
}
