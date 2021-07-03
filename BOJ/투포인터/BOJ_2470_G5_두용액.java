package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2470_G5_두용액 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int ans1 = 0; int ans2 = 0;
		int min = Integer.MAX_VALUE;
		int lIdx = 0; int rIdx = N-1;
		while(lIdx < rIdx) {
			int sum = arr[lIdx] + arr[rIdx];
			if(Math.abs(sum) < Math.abs(min)) {
				ans1 = arr[lIdx];
				ans2 = arr[rIdx];
				min = sum;
			}
			if(sum < 0) {
				++lIdx;
			}
			else if(sum > 0) {
				--rIdx;
			}
			else {
				ans1 = arr[lIdx];
				ans2 = arr[rIdx];
				break;
			}
		}
		System.out.println(ans1 + " " + ans2);
	}

}
