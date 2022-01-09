package DFS와BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_16946_G2_벽부수고이동하기4_시간초과 {
	static int N, M;
	static char map[][];
	static boolean visited[][];
	static int cnt;
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for(int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] != '0') {
					visited = new boolean[N][M]; 
					cnt = 0;
					dfs(i, j);
					cnt %= 10;
					map[i][j] = (char) (cnt + '0');
				}
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				bw.write(map[i][j]);
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	private static void dfs(int r, int c) {
		++cnt;
		visited[r][c] = true;
		for(int k = 0; k < 4; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			if(nr < 0 || N <= nr || nc < 0 || M <= nc || visited[nr][nc]) continue;
			if(map[nr][nc] == '0') {
				dfs(nr, nc);
			}
		}
	}

}
