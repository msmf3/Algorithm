package 최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 연결 그래프라면 최소 스패닝 트리의 간선의 개수는 (정점의 개수 - 1)이다.
 */

public class BOJ_9372_S4_상근이의여행 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
			for(int i = 0; i < M; i++) {
				br.readLine();
			}
			sb.append(N-1 + "\n");
		}
		System.out.print(sb.toString());
	}

}
