import java.util.LinkedList;
import java.util.Queue;

public class Prg_Level3_아이템줍기 {

	public static void main(String[] args) {
		int[][] rectangle = {{2,2,5,5},{1,3,6,4},{3,1,4,6}};
		int cx = 1;
		int cy = 4;
		int ix = 6;
		int iy = 3;
		System.out.println(solution(rectangle, cx, cy, ix, iy));
	}
	
	static int[][][] map;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	
	public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        map = new int[52][52][4];
        // 입력이 한개인 경우 그려야 함
        drawBorder(rectangle[0][0], rectangle[0][1], rectangle[0][2], rectangle[0][3], 0, 0, 0, 0);
        
        for(int i = 0; i < rectangle.length-1; i++) {
        	for(int j = i+1; j < rectangle.length; j++) {
        		int sx1 = rectangle[i][0]; int sy1 = rectangle[i][1];
        		int ex1 = rectangle[i][2]; int ey1 = rectangle[i][3];
        		int sx2 = rectangle[j][0]; int sy2 = rectangle[j][1];
        		int ex2 = rectangle[j][2]; int ey2 = rectangle[j][3];
        		drawBorder(sx1, sy1, ex1, ey1, sx2, sy2, ex2, ey2);
        	}
        }
        
        for(int i = 10; i >= 0; i--) {
        	for(int j = 0; j < 11; j++) {
        		if(map[i][j][0] == -1) {
        			System.out.print("- ");
        		}
        		else {
        			System.out.print(map[i][j][0] + " ");
        		}
        		
        	}
        	System.out.println();
        }
        
        return bfs(characterX, characterY, itemX, itemY);
    }
	
	private static int bfs(int characterX, int characterY, int itemX, int itemY) {
		Queue<Point> q = new LinkedList<>();
		boolean[][] visited = new boolean[52][52];
		q.add(new Point(characterX, characterY, 0));
		visited[characterY][characterX] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			for(int k = 0; k < 4; k++) {
				int nx = p.x + dx[k];
				int ny = p.y + dy[k];
				
				if(nx < 0 || nx > 50 || ny < 0 || ny > 50) continue;
				if(visited[ny][nx]) continue;
				
				if(map[p.y][p.x][k] == 1) {
					if(nx == itemX && ny == itemY) {
						return p.step+1;
					}
					q.add(new Point(nx, ny, p.step+1));
					visited[ny][nx] = true;
				}
			}
		}
		
		return -1;
	}
	
	private static void drawBorder(int sx1, int sy1, int ex1, int ey1, int sx2, int sy2, int ex2, int ey2) {
		// 두 사각형을 모두 맵에 표시
		// 첫 사각형 가로선 표시
		for(int x = sx1; x < ex1; x++) {
			if(map[sy1][x][3] != -1) {
				if(!isInside(x+0.5, sy1, sx2, ex2, sy2, ey2)) {
					map[sy1][x][3] = 1;
					map[sy1][x+1][2] = 1;
				}
				else {
					map[sy1][x][3] = -1;
					map[sy1][x+1][2] = -1;
				}
			}
			if(map[ey1][x][3] != -1) {
				if(!isInside(x+0.5, ey1, sx2, ex2, sy2, ey2)) {
					map[ey1][x][3] = 1;
					map[ey1][x+1][2] = 1;
				}
				else {
					map[ey1][x][3] = -1;
					map[ey1][x+1][2] = -1;
				}
			}
		}
		// 첫 사각형 세로선 표시
		for(int y = sy1; y < ey1; y++) {
			if(map[y][sx1][0] != -1) {
				if(!isInside(sx1, y+0.5, sx2, ex2, sy2, ey2)) {
					map[y][sx1][0] = 1;
					map[y+1][sx1][1] = 1;
				}
				else {
					map[y][sx1][0] = -1;
					map[y+1][sx1][1] = -1;
				}
			}
			
			if(map[y][ex1][0] != -1) {
				if(!isInside(ex1, y+0.5, sx2, ex2, sy2, ey2)) {
					map[y][ex1][0] = 1;
					map[y+1][ex1][1] = 1;
				}
				else {
					map[y][ex1][0] = -1;
					map[y+1][ex1][1] = -1;
				}
			}
		}
		// 두번째 사각형 가로선 표시
		for(int x = sx2; x < ex2; x++) {
			if(map[sy2][x][3] != -1) {
				if(!isInside(x+0.5, sy2, sx1, ex1, sy1, ey1)) {
					map[sy2][x][3] = 1;
					map[sy2][x+1][2] = 1;
				}
				else {
					map[sy2][x][3] = -1;
					map[sy2][x+1][2] = -1;
				}
			}
			
			if(map[ey2][x][3] != -1) {
				if(!isInside(x+0.5, ey2, sx1, ex1, sy1, ey1)) {
					map[ey2][x][3] = 1;
					map[ey2][x+1][2] = 1;
				}
				else {
					map[ey2][x][3] = -1;
					map[ey2][x+1][2] = -1;
				}
			}
		}
		// 두번째 사각형 세로선 표시
		for(int y = sy2; y < ey2; y++) {
			if(map[y][sx2][0] != -1) {
				if(!isInside(sx2, y+0.5, sx1, ex1, sy1, ey1)) {
					map[y][sx2][0] = 1;
					map[y+1][sx2][1] = 1;
				}
				else {
					map[y][sx2][0] = -1;
					map[y+1][sx2][1] = -1;
				}
			}
			
			if(map[y][ex2][0] != -1) {
				if(!isInside(ex2, y+0.5, sx1, ex1, sy1, ey1)) {
					map[y][ex2][0] = 1;
					map[y+1][ex2][1] = 1;
				}
				else {
					map[y][ex2][0] = -1;
					map[y+1][ex2][1] = -1;
				}
			}
		}
		
	}
	
	private static boolean isInside(double x, double y, int sx, int ex, int sy, int ey) {
		if(sx < x && x < ex && sy < y && y < ey) return true;
		return false;
	}
	
	static class Point {
		int x, y, step;
		
		public Point(int x, int y, int step) {
			this.x = x;
			this.y = y;
			this.step = step;
		}
	}
}
