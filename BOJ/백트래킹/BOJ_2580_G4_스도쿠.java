package 백트래킹;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2580_G4_스도쿠 {
	static int map[][] = new int[9][9];
	static List<Point> emptyLocations = new ArrayList<>();
	static int size;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) {
					emptyLocations.add(new Point(i, j));
				}
			}
		}
		size = emptyLocations.size();
		fillSudoku(0);
	}
	
	private static void fillSudoku(int idx) {
		if(idx == size) {
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			System.exit(0);
		}
		Point p = emptyLocations.get(idx);
		for(int num = 1; num <= 9; num++) {
			map[p.r][p.c] = 0;
			if(checkSudoku(p, num)) {
				map[p.r][p.c] = num;
				fillSudoku(idx+1);
			}
		}
	}

	private static boolean checkSudoku(Point p, int num) {
		// 가로, 세로 방향
		for(int i = 0; i < 9; i++) {
			if(num == map[p.r][i] || num == map[i][p.c]) {
				return false;
			}
		}
		
		int sr = 3 * (p.r / 3); int sc = 3 * (p.c / 3);
		// 3x3 정사각형
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(num == map[sr+i][sc+j]) {
					return false;
				}
			}
		}
		return true;
	}

	static class Point {
		int r, c;
		
		Point(int r, int c){
			this.r = r;
			this.c = c;
		}
	}

}
