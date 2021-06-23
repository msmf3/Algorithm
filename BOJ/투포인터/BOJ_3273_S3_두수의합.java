package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3273_S3_두수의합 {
	static int n;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arr[] = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int x = Integer.parseInt(br.readLine());
		
		System.out.println(getPairSumCnt(arr, x));
	}
	
	private static int getPairSumCnt(int arr[], int x) {
		int cnt = 0;
		int sIdx = 0; int eIdx = n-1;
		Arrays.sort(arr);
		while(sIdx < eIdx) {
			int sum = arr[sIdx] + arr[eIdx];
			if(sum == x) {
				++cnt;
				++sIdx;
				--eIdx;
			}
			else if(sum < x) {
				++sIdx;
			}
			else {
				--eIdx;
			}
		}
		return cnt;
	}

}
