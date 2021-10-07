import java.util.ArrayList;
import java.util.Collections;

public class Prg_Level2_빛의경로사이클 {

	public static void main(String[] args) {
		String[] grid = {"R","R"};
		int[] answer = solution(grid);
		for(int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}
	static int N, M;
	// 상: 0, 우: 1, 하: 2, 좌: 3
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static int[] solution(String[] grid) {
        ArrayList<Integer> answer = new ArrayList<>();
        N = grid.length;
        M = grid[0].length();
        boolean[][][] visited = new boolean[N][M][4];
        
        for(int i = 0; i < N; i++) {
        	for(int j = 0; j < M; j++) {
        		for(int k = 0; k < 4; k++) {
        			if(visited[i][j][k]) continue;
        			answer.add(shootLight(i, j, k, visited, grid));
        		}
        	}
        }
        Collections.sort(answer);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
	
	private static int shootLight(int r, int c, int k, boolean[][][] visited, String[] grid) {
		int cnt = 0;
		while(true) {
			if(visited[r][c][k]) break;
			visited[r][c][k] = true;
			++cnt;
			
			r = r + dr[k];
			c = c + dc[k];
			if(r < 0) r = N-1;
			else if(N <= r) r = 0;
			else if(c < 0) c = M-1;
			else if(M <= c) c = 0;
			
			char ch = grid[r].charAt(c);
			switch(ch) {
			case 'R':
				++k;
				if(k > 3) k = 0;
				break;
			case 'L':
				--k;
				if(k < 0) k = 3;
				break;
			}
		}
		return cnt;
	}
}
