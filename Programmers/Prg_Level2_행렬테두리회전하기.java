
public class Prg_Level2_행렬테두리회전하기 {

	public static void main(String[] args) {
		
	}
	static int R, C;
	
	public static int[] solution(int rows, int columns, int[][] queries) {
        R = rows; C = columns;
        int[][] map = new int[R+1][C+1];
        for(int i = 1; i <= R; i++) {
        	for(int j = 1; j <= C; j++) {
        		map[i][j] = (i-1) * C + j;
        	}
        }
        
        int[] answer = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
        	int[] query = queries[i];
        	int min = rotate(map, query[0], query[1], query[2], query[3]);
        	answer[i] = min;
        }
        
        return answer;
    }
	
	private static int rotate(int[][] map, int x1, int y1, int x2, int y2) {
		int min;
		int prev = min = map[x1][y1];
		// row 상
		for(int y = y1+1; y <= y2; y++) {
			int tmp = map[x1][y];
			min = Math.min(min, tmp);
			map[x1][y] = prev;
			prev = tmp;
		}
		// column 우
		for(int x = x1+1; x <= x2; x++) {
			int tmp = map[x][y2];
			min = Math.min(min, tmp);
			map[x][y2] = prev;
			prev = tmp;
		}
		// row 하
		for(int y = y2-1; y >= y1; y--) {
			int tmp = map[x2][y];
			min = Math.min(min, tmp);
			map[x2][y] = prev;
			prev = tmp;
		}
		// column 좌
		for(int x = x2-1; x >= x1; x--) {
			int tmp = map[x][y1];
			min = Math.min(min, tmp);
			map[x][y1] = prev;
			prev = tmp;
		}
		return min;
	}
}
