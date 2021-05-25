import java.util.Scanner;

public class BOJ_1018_S5_체스판다시칠하기 {
	static int N, M;
	static char map[][];
	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new char[N][M];
		for(int i = 0; i < N; i++) {
			String s = sc.next();
			for(int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		for(int i = 0; i <= N-8; i++) {
			for(int j = 0; j <= M-8; j++) {
				go(i, j);
			}
		}
		
		System.out.println(ans);
		sc.close();
	}
	
	private static void go(int r, int c) {
		char wb = map[r][c];
		int cnt = 0;
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if((i+j) % 2 == 1 && map[r+i][c+j] == wb) {
					++cnt;
				}
				else if((i+j) % 2 == 0 && map[r+i][c+j] != wb) {
					++cnt;
				}
			}
		}
		ans = Math.min(ans, cnt);
		
		// 맨 왼쪽 위 칸을 다른 색으로 칠하는 경우
		wb = (wb == 'W' ? 'B' : 'W');
		cnt = 0;
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if((i+j) % 2 == 1 && map[r+i][c+j] == wb) {
					++cnt;
				}
				else if((i+j) % 2 == 0 && map[r+i][c+j] != wb) {
					++cnt;
				}
			}
		}
		ans = Math.min(ans, cnt);
	}

}
