package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2467_G5_용액 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int lIdx = 0; int rIdx = N-1;
		int lAns = arr[0]; int rAns = arr[N-1];
		int min = Math.abs(lAns + rAns);
		while(lIdx < rIdx) {
			int mixed = arr[lIdx] + arr[rIdx];
			if(Math.abs(mixed) < min) {
				lAns = arr[lIdx];
				rAns = arr[rIdx];
				min = Math.abs(mixed);
			}
			if(mixed < 0) {
				++lIdx;
			}
			else if(mixed > 0) {
				--rIdx;
			}
			else {	// 0이면
				lAns = arr[lIdx];
				rAns = arr[rIdx];
				break;
			}
		}
		System.out.println(lAns + " " + rAns);
	}

}
