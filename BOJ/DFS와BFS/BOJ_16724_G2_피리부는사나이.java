package DFS와BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.StringTokenizer;

/*
 * 참고 : https://gre-eny.tistory.com/217
 */

public class BOJ_16724_G2_피리부는사나이 {
	static int N, M;
	static char map[][];
	static int parents[];
	static Map<Character, Integer> dMap;
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		parents = new int[N*M];
		for(int i = 1; i < parents.length; i++) {
			parents[i] = i;
		}
		dMap = new HashMap<>();
		dMap.put('U', 0);
		dMap.put('D', 1);
		dMap.put('L', 2);
		dMap.put('R', 3);
		for(int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				int curIdx = i * M + j;
				int nextIdx = getNextIdx(i, j);
				union(curIdx, nextIdx);
			}
		}
		int cnt = getSaveZoneCnt();
		bw.write(cnt);
		bw.close();
		br.close();
	}
	
	private static int getNextIdx(int r, int c) {
		int dir = dMap.get(map[r][c]);
		int nr = r + dr[dir];
		int nc = c + dc[dir];
		return nr * M + nc;
	}
	
	private static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	private static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return;
		if(aRoot > bRoot) {
			parents[aRoot] = bRoot;
		} 
		else {
			parents[bRoot] = aRoot;
		}
	}
	
	private static int getSaveZoneCnt() {
		HashSet<Integer> set = new HashSet<>();
		for(int i = 0; i < parents.length; i++) {
			set.add(find(i));
		}
		return set.size();
	}
}
