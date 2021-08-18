package DFS와BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

/*
 * 참고 : https://yabmoons.tistory.com/216
 */

public class BOJ_16946_G2_벽부수고이동하기4 {
	static int N, M, zNum, cnt;
	static char map[][];
	static int numMap[][], ansMap[][];
	static boolean visited[][];
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	static int parents[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		numMap = new int[N][M];
		ansMap = new int[N][M];
		visited = new boolean[N][M];
		parents = new int[N*M];
		// 자기자신이 루트일 경우에만 음수값 (-집합의 크기를 갖고있음)
		Arrays.fill(parents, -1);
		for(int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		zNum = 1;
		ArrayList<Integer> zCntList = new ArrayList<>();
		zCntList.add(0);
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == '0' && !visited[i][j]) {
					cnt = 0;
					dfs(i, j);
					zCntList.add(cnt);
					++zNum;
				}
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] != '0') {
					int cnt = 0;
					Set<Integer> set = new HashSet<Integer>();
					for(int k = 0; k < 4; k++) {
						int nr = i + dr[k];
						int nc = j + dc[k];
						if(nr < 0 || N <= nr || nc < 0 || M <= nc) continue;
						if(map[nr][nc] == '0') {
							set.add(numMap[nr][nc]);
						}
					}
					Iterator<Integer> iter = set.iterator();
					while(iter.hasNext()) {
						cnt += zCntList.get(iter.next());
					}
					ansMap[i][j] = (cnt+1) % 10;
				}
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				bw.write(ansMap[i][j]+'0');
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void dfs(int r, int c) {
		++cnt;
		numMap[r][c] = zNum;
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
