package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 참고 : https://mapocodingpark.blogspot.com/2020/07/1695.html	

public class BOJ_1695_G4_팰린드롬만들기 {
	static int[] arr;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		arr= new int[N];
		dp = new int[N][N];
		// dp[i][j] -> arr의 i번째부터 j번째까지 팰린드롬으로 만들기위한 끼워넣을 수의 최소 개수
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			Arrays.fill(dp[i], -1);
		}
		
		System.out.println(palindrome(0, N-1));
	}
	
	private static int palindrome(int start, int end) {
		if(start >= end) return 0;
		
		// 이미 확인한 경우
		if(dp[start][end] != -1) return dp[start][end];
		
		if(arr[start] == arr[end]) return palindrome(start+1, end-1);
		
		// arr[start] != arr[end]
		dp[start][end] = Math.min(palindrome(start+1, end), palindrome(start, end-1)) + 1;
		
		return dp[start][end];
	}
}
