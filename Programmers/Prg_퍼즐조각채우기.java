import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Prg_퍼즐조각채우기 {

	public static void main(String[] args) {
		int game_board[][] = {{1,1,0,0,1,0},
							{0,0,1,0,1,0},
							{0,1,1,0,0,1},
							{1,1,0,1,1,1},
							{1,0,0,0,1,0},
							{0,1,1,1,0,0}};
		int table[][] = {{1,0,0,1,1,0},
						{1,0,1,0,1,0},
						{0,1,1,0,1,1},
						{0,0,1,0,0,0},
						{1,1,0,1,1,0},
						{0,1,0,0,0,0}};
		solution(game_board, table);
	}
	
	static int N;
	static boolean filled[][];
	static boolean visited[][];
	// 방향 : 상 -> 우 -> 하 -> 좌
	static int dr[] = {-1, 0, 1, 0};
	static int dc[] = {0, 1, 0, -1};
	
	public static int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        N = game_board.length;
        filled = new boolean[N][N];
        visited = new boolean[N][N];
        
        // 테이블에 있는 퍼즐 조각들 리스트
        ArrayList<Piece> puzzlePieceList = new ArrayList<>();
        for(int i = 0; i < N; i++) {
        	for(int j = 0; j < N; j++) {
        		if(table[i][j] == 1 && !visited[i][j]) {
        			// 4번째 매개변수 type = 1이면, piece를 찾음
        			// 0이면 empty piece를 찾음
        			Piece piece = getPiece(i, j, table, 1);
        			puzzlePieceList.add(piece);
        		}
        	}
        }
        
        visited = new boolean[N][N];
        // 게임보드에 있는 빈 공간들 리스트
        ArrayList<Piece> emptyPieceList = new ArrayList<>();
        for(int i = 0; i < N; i++) {
        	for(int j = 0; j < N; j++) {
        		if(game_board[i][j] == 0 && !visited[i][j]) {
        			Piece piece = getPiece(i, j, game_board, 0);
        			emptyPieceList.add(piece);
        		}
        	}
        }
        
        for(Piece empty : emptyPieceList) {
        	a:for(Piece puzzle : puzzlePieceList) {
        		if(empty.size != puzzle.size || !puzzle.isActive) {
        			continue;
        		}
        		int puzzlePoints[][] = puzzle.points;
        		for(int i = 0; i < 4; i++) {
        			puzzlePoints = rotate90(puzzlePoints);
        			if(isSamePiece(empty.points, puzzlePoints)) {
        				answer += empty.size;
        				puzzle.isActive = false;
        				break a;
        			}
        		}
        	}
        }
        System.out.println(answer);
        return answer;
    }

	private static Piece getPiece(int r, int c, int table[][], int type) {
		visited[r][c] = true;
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r, c));
		ArrayList<Point> pointList = new ArrayList<>();
		pointList.add(new Point(r, c));
		int max_r = r, min_r = r;
		int max_c = c, min_c = c;
		while(!q.isEmpty()) {
			Point p = q.poll();
			for(int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];
				if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) continue;
				
				if(table[nr][nc] == type) {
					min_r = Math.min(min_r, nr);
					min_c = Math.min(min_c, nc);
					max_r = Math.max(max_r, nr);
					max_c = Math.max(max_c, nc);
					visited[nr][nc] = true;
					q.add(new Point(nr, nc));
					pointList.add(new Point(nr, nc));
				}
			}
		}
		int R = max_r-min_r+1, C = max_c-min_c+1;
		int points[][] = new int[R][C];
		for(Point p : pointList) {
			points[p.r-min_r][p.c-min_c] = 1; 
		}
		return new Piece(points, pointList.size());
	}
	
	private static boolean isSamePiece(int a[][], int b[][]) {
		if(a.length != b.length) return false;
		if(a[0].length != b[0].length) return false;
		
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[0].length; j++) {
				if(a[i][j] != b[i][j]) return false;
			}
		}
		return true;
	}
	
	private static int[][] rotate90(int a[][]) {
		int R = a[0].length, C = a.length;
		int result[][] = new int[R][C];
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				result[i][j] = a[j][R-i-1];
			}
		}
		return result;
	}

	static class Piece {
		int points[][];
		int size;
		// active 상태인지 체크. 채워진 곳이나 쓰여진 퍼즐블럭이면 false
		boolean isActive;
		
		public Piece(int points[][], int size) {
			this.points = points;
			this.size = size;
			this.isActive = true;
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
