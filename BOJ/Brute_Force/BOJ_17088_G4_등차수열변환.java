package Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17088_G4_등차수열변환 {
	static final int MAX_CNT = 100001;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if(N == 1 || N == 2) {
			System.out.println(0);
			return;
		}
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int ans = MAX_CNT;
		int firstNum, lastNum;
		
		for(int i = -1; i <= 1; i++) {
			for(int j = -1; j <= 1; j++) {
				firstNum = arr[0] + i;
				lastNum  = arr[N-1] + j;
				int diff = lastNum - firstNum;
				if(diff % (N-1) != 0) continue;
				int[] tmpArr = arr.clone();
				tmpArr[0]   = firstNum;
				tmpArr[N-1] = lastNum;
				ans = Math.min(ans, getMinCnt(diff / (N-1), tmpArr, Math.abs(i) + Math.abs(j)));
			}
		}
		
		if(ans == MAX_CNT) {
			System.out.println(-1);
			return;
		}
		System.out.println(ans);
	}
	
	private static int getMinCnt(int diff, int[] arr, int cnt) {
		int c = cnt;
		
		for(int i = 1; i < arr.length-1; i++) {
			int d = arr[i] - arr[i-1];
			if(d == diff) continue;
			else if(d == diff+1) {
				++c;
				--arr[i];
			}
			else if(d == diff-1) {
				++c;
				++arr[i];
			}
			else {
				return MAX_CNT;
			}
		}
		if(arr[arr.length-1] - arr[arr.length-2] != diff) return MAX_CNT;
		
		return c;
	}
	
}
