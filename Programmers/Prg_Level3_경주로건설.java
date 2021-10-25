import java.util.Arrays;

public class Prg_Level3_경주로건설 {

	public static void main(String[] args) {
		int[][] board = {{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}};
		System.out.println(solution(board));
	}
	
	static int N;
	static int[][] dp;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int[] cost = {100, 600};
	
	public static int solution(int[][] board) {
        N = board.length;
        dp = new int[N][N];
        for(int i = 0; i < N; i++) {
        	Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        dp[1][0] = dp[0][1] = 100;
        
        if(board[0][1] == 0) {
        	dfs(0, 1, 1, board); // 오른쪽
        }
        
        for(int i = 0; i < N; i++) {
        	for(int j = 0; j < N; j++) {
        		System.out.print(dp[i][j] + " ");
        	}
        	System.out.println();
        }
        if(board[1][0] == 0) {
        	dfs(1, 0, 2, board); // 아랫쪽
        }
        
        for(int i = 0; i < N; i++) {
        	for(int j = 0; j < N; j++) {
        		System.out.print(dp[i][j] + " ");
        	}
        	System.out.println();
        }
        return dp[N-1][N-1];
    }
	
	private static void dfs(int r, int c, int dir, int[][] board) {
		if(r == N-1 && c == N-1) return;
		
		for(int k = 0; k < 4; k++) {
			if((k+2)%4 == dir) continue;
			
			int nr = r + dr[k];
			int nc = c + dc[k];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
			if(board[nr][nc] == 1) continue;
			
			int nextCost = dp[r][c] + cost[Math.abs(dir-k) % 2];
			if(dp[nr][nc] >= nextCost) {
				dp[nr][nc] = nextCost;
				dfs(nr, nc, k, board);
			}
		}
	}
}
