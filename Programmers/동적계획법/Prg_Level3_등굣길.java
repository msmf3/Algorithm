package 동적계획법;

public class Prg_Level3_등굣길 {

	public static void main(String[] args) {
		int[][] puddles = {{2,2}};
		System.out.println(solution(4,3,puddles));
	}
	
	public static int solution(int m, int n, int[][] puddles) {
        long div = 1_000_000_007;
        long[][] map = new long[n+1][m+1];
        for(int[] puddle : puddles) {
        	map[puddle[1]][puddle[0]] = -1;
        }
        map[0][1] = 1;
        for(int i = 1; i <= n; i++) {
        	for(int j = 1; j <= m; j++) {
        		// 웅덩이인 경우
        		if(map[i][j] == -1) continue;
        		long left = Math.max(0, map[i][j-1]);
        		long up = Math.max(0, map[i-1][j]);
        		map[i][j] = (up + left) % div;
        	}
        }
        
        return (int) map[n][m];
    }
}
