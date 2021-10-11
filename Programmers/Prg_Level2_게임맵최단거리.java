import java.util.LinkedList;
import java.util.Queue;

public class Prg_Level2_게임맵최단거리 {

	public static void main(String[] args) {
		int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		System.out.println(solution(maps));
	}
	
	static int N, M;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
        return bfs(maps);
    }
	
	private static int bfs(int[][] maps) {
		boolean[][] visited = new boolean[N][M];
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(0, 0, 0));
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			if(p.r == N-1 && p.c == M-1) return p.step+1;
			
			for(int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				if(visited[nr][nc] || maps[nr][nc] == 0) continue;
				
				q.add(new Point(nr, nc, p.step+1));
				visited[nr][nc] = true;
			}
		}
		
		return -1;
	}
	
	static class Point {
		int r, c, step;
		
		public Point(int r, int c, int step) {
			this.r = r;
			this.c = c;
			this.step = step;
		}
	}
}
