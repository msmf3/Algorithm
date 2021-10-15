import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Prg_Level2_프렌즈4블록 {

	public static void main(String[] args) {
		String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
		System.out.println(solution(6, 6, board));
	}
	static int answer, M, N;
	static char[][] gameBoard;
	
	public static int solution(int m, int n, String[] board) {
        answer = 0;
        M = m; N = n;
        gameBoard = new char[m][n];
        for(int i = 0; i < m; i++) {
        	gameBoard[i] = board[i].toCharArray();
        }
        
        
        while(deleteBlock() > 0) {
        }
        
        return answer;
    }
	
	private static int deleteBlock() {
		Set<Point> deletePoints = new HashSet<>();
		
		// find
		for(int r = 0; r < M-1; r++) {
        	for(int c = 0; c < N-1; c++) {
        		char block = gameBoard[r][c];
        		if(block == ' ') continue;
        		if(block == gameBoard[r][c+1] &&
        		   block == gameBoard[r+1][c] &&
        		   block == gameBoard[r+1][c+1]) {
        			deletePoints.add(new Point(r, c));
        			deletePoints.add(new Point(r, c+1));
        			deletePoints.add(new Point(r+1, c));
        			deletePoints.add(new Point(r+1, c+1));
        		}
        	}
        }
		
		// delete
		for(Point p : deletePoints) {
			gameBoard[p.r][p.c] = ' '; 
		}
		
		// down
		for(int r = M-1; r > 0; r--) {
			for(int c = 0; c < N; c++) {
				if(gameBoard[r][c] == ' ') {
					int ur = r-1;
					while(ur >= 0 && gameBoard[ur][c] == ' ') {
						ur--;
					}
					if(ur >= 0) {
						gameBoard[r][c] = gameBoard[ur][c];
						gameBoard[ur][c] = ' ';
					}
				}
			}
		}
		
		answer += deletePoints.size();
		
		return deletePoints.size();
	}
	
	static class Point {
		int r, c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
		@Override
		public int hashCode(){
			return Objects.hash(r + " " + c);
		}
		
		@Override
		public boolean equals(Object o) {
			Point p = (Point) o;
			return (this.r == p.r && this.c == p.c);
		}
	}
}
