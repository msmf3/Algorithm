package DFS와BFS;

import java.util.ArrayList;
import java.util.Collections;

/*
 * 참고 : https://dev-note-97.tistory.com/255
 */

public class Prg_Level3_리틀프렌즈사천성 {

	public static void main(String[] args) {
		String board[] = {".ZI.", "M.**", "MZU.", ".IU."};
		System.out.println(solution(4, 4, board));
	}
	
	static ArrayList<Tile> alpList;
	static int M, N;
	static char global_board[][];
	
	public static String solution(int m, int n, String[] board) {
        String answer = "";
        alpList = new ArrayList<>();
        M = m; N = n;
        global_board = new char[m][n];
        
        for(int i = 0; i < m; i++) {
        	String line = board[i];
        	for(int j = 0; j < n; j++) {
        		char c = line.charAt(j);
        		global_board[i][j] = c;
        		if('A' <= c && c <= 'Z') {
        			alpList.add(new Tile(i, j, c));
        		}
        	}
        }
        
        Collections.sort(alpList);
        int idx = 0;
        while(alpList.size() != 0) {
        	// 타일삭제가 가능한 경우
        	if(havePath(alpList.get(idx), alpList.get(idx+1))) {
        		// 타일 두개 삭제
        		Tile t1 = alpList.remove(idx);
        		Tile t2 = alpList.remove(idx);
        		answer += t1.alphabet;
        		global_board[t1.r][t1.c] = '.'; 
        		global_board[t2.r][t2.c] = '.'; 
        		idx = 0;
        	}
        	else {
        		idx += 2;
        		if(idx == alpList.size()) {
        			return "IMPOSSIBLE";
        		}
        	}
        }
        
        return answer;
    }
	
	private static boolean havePath(Tile t1, Tile t2) {
		int c1 = t1.c; int c2 = t2.c;
		int r1 = t1.r; int r2 = t2.r;
		char alp = t1.alphabet;
		
		if(r1 < r2) {
			// 우 -> 하
			if(checkRow(r1, r2, c1, alp) && checkCol(c1, c2, r2, alp)) {
				return true;
			}
			// 하 -> 우
			if(checkCol(c1, c2, r1, alp) && checkRow(r1, r2, c2, alp)) {
				return true;
			}
		}
		else {
			// 우 -> 상
			if(checkRow(r2, r1, c1, alp) && checkCol(c1, c2, r2, alp)) {
				return true;
			}
			// 상 -> 우
			if(checkCol(c1, c2, r1, alp) && checkRow(r2, r1, c2, alp)) {
				return true;
			}
		}
		
		
		return false;
	}
	
	private static boolean checkRow(int r1, int r2, int c, char alp) {
		for(int r = r1; r <= r2; r++) {
			if(global_board[r][c] != '.' && global_board[r][c] != alp) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean checkCol(int c1, int c2, int r, char alp) {
		for(int c = c1; c <= c2; c++) {
			if(global_board[r][c] != '.' && global_board[r][c] != alp) {
				return false;
			}
		}
		return true;
	}
	
	static class Tile implements Comparable<Tile> {
		int r, c;
		char alphabet;
		
		public Tile(int r, int c, char alphabet) {
			this.r = r;
			this.c = c;
			this.alphabet = alphabet;
		}

		@Override
		public int compareTo(Tile o) {
			if(this.alphabet == o.alphabet) {
				if(this.c == o.c) {
					return Integer.compare(this.r, o.r);
				}
				return Integer.compare(this.c, o.c);
			}
			return Character.compare(this.alphabet, o.alphabet);
		}
	}
}
