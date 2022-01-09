package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2473_G4_세용액_Failed {
	static StringBuilder sb = new StringBuilder();
	static long arr[];
	static int ansIdx1, ansIdx2, ansIdx3;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new long[N];
		long totalSum = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			totalSum += arr[i];
		}
		Arrays.sort(arr);
		int lIdx = 0; int rIdx = N-1; int mIdx = (lIdx+rIdx)/2;
		ansIdx1 = lIdx; ansIdx2 = mIdx; ansIdx3 = rIdx;
		long min = Math.abs(arr[lIdx] + arr[mIdx] + arr[rIdx]);
		if(min == 0) {
			ansIdx1 = lIdx; ansIdx2 = mIdx; ansIdx3 = rIdx;
			print();
		}
		while(lIdx+1 < rIdx) {
			long prevSum = 0;
			mIdx = (lIdx + rIdx) / 2;
			while(lIdx < mIdx && mIdx < rIdx) {
//				System.out.println(arr[lIdx] + " " + arr[mIdx] + " " + arr[rIdx]);
				long sum = arr[lIdx] + arr[mIdx] + arr[rIdx];
				if(min > Math.abs(sum)) {
					min = Math.abs(sum);
					ansIdx1 = lIdx; ansIdx2 = mIdx; ansIdx3 = rIdx;
				}
				if(sum == 0) {
					ansIdx1 = lIdx; ansIdx2 = mIdx; ansIdx3 = rIdx;
					print();
				}
				else if(sum < 0) {
					++mIdx;
				}
				else {
					--mIdx;
				}
				if((prevSum < 0 && sum > 0) || (prevSum > 0 && sum < 0)) {
					break;
				}
				prevSum = sum;
			}
			if(totalSum < 0) {
				totalSum -= arr[lIdx];
				++lIdx;
			}
			else {
				totalSum -= arr[rIdx];
				--rIdx;
			}
		}
		print();
	}
	
	private static void print() {
		sb.append(arr[ansIdx1] + " " + arr[ansIdx2] + " " + arr[ansIdx3]);
		System.out.println(sb.toString());
		System.exit(0);
	}

}
