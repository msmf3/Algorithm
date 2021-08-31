package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2096_G4_내려가기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int map[][] = new int[N][3];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
			map[i][2] = Integer.parseInt(st.nextToken());
		}
		int minDP[][] = new int[N][3];
		int maxDP[][] = new int[N][3];
		minDP[0][0] = maxDP[0][0] = map[0][0];
		minDP[0][1] = maxDP[0][1] = map[0][1];
		minDP[0][2] = maxDP[0][2] = map[0][2];
		for(int i = 1; i < N; i++) {
			minDP[i][0] = map[i][0] + Math.min(minDP[i-1][0], minDP[i-1][1]);
			minDP[i][1] = map[i][1] + Math.min(minDP[i-1][0], Math.min(minDP[i-1][1], minDP[i-1][2]));
			minDP[i][2] = map[i][2] + Math.min(minDP[i-1][1], minDP[i-1][2]);

			maxDP[i][0] = map[i][0] + Math.max(maxDP[i-1][0], maxDP[i-1][1]);
			maxDP[i][1] = map[i][1] + Math.max(maxDP[i-1][0], Math.max(maxDP[i-1][1], maxDP[i-1][2]));
			maxDP[i][2] = map[i][2] + Math.max(maxDP[i-1][1], maxDP[i-1][2]);
		}
		int min = Math.min(minDP[N-1][0], Math.min(minDP[N-1][1], minDP[N-1][2]));
		int max = Math.max(maxDP[N-1][0], Math.max(maxDP[N-1][1], maxDP[N-1][2]));
		System.out.println(max + " " + min);
	}

}
