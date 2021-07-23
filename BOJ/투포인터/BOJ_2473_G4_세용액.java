package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 참고 : https://kdr0407.tistory.com/33
 */

public class BOJ_2473_G4_세용액 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		long arr[] = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(arr);
		int ansIdx1, ansIdx2, ansIdx3;
		ansIdx1 = ansIdx2 = ansIdx3 = 0;
		long min = Long.MAX_VALUE;
		a:for(int i = 0; i < N-2; i++) {
			int j = i+1; int k = N-1;
			while(j < k) {
				long sum = arr[i] + arr[j] + arr[k];
				if(min > Math.abs(sum)) {
					min = Math.abs(sum);
					ansIdx1 = i; ansIdx2 = j; ansIdx3 = k;
				}
				if(sum < 0) {
					++j;
				}
				else if(sum > 0){
					--k;
				}
				else if(sum == 0) {
					break a;
				}
			}
		}
		sb.append(arr[ansIdx1] + " " + arr[ansIdx2] + " " + arr[ansIdx3]);
		System.out.print(sb.toString());
	}

}
