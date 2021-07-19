package 동적계획법;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_10942_G3_팰린드롬 {
	static int N, arr[];
	static boolean dp[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dp = new boolean[N+1][N+1];
		for(int i = 1; i <= N; i++) {
			dp[i][i] = true;
		}
		
		for(int i = 1; i < N; i++) {
			if(arr[i] == arr[i+1]) {
				dp[i][i+1] = true;
			}
		}
		/*
		for(int i = 2; i < N; i++) {
			palindromeCheck(i-1, i+1);
			if(dp[i][i+1]) {
				palindromeCheck(i-1, i+2);
			}
		}
		*/
		/*
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				bw.write((dp[i][j] ? 1 : 0) + " ");
			}
			bw.write("\n");
		}
		*/
		for(int i = 2; i < N; i++) {
			for(int from = 1; from + i <= N; from++) {
				int to = from + i;
				if(arr[from] == arr[to] && dp[from+1][to-1]) {
					dp[from][to] = true;
				}
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			bw.write((dp[from][to] ? 1 : 0) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	/*
	private static void palindromeCheck(int sIdx, int eIdx) {
		while(0 < sIdx && eIdx <= N) {
			if(arr[sIdx] == arr[eIdx]) {
				dp[sIdx][eIdx] = true;
				--sIdx;
				++eIdx;
			}
			else {
				break;
			}
		}
	}
	*/
}
