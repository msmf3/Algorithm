package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920_S4_수찾기 {
	static int arr[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			int a = Integer.parseInt(st.nextToken());
			binarySearch(a, 0, N-1);
		}
		System.out.print(sb.toString());
	}

	private static void binarySearch(int a, int left, int right) {
		int idx = (left+right) / 2;
		if(left > right) {
			sb.append("0\n");
			return;
		}
		if(arr[idx] == a) sb.append("1\n");
		else if(arr[idx] < a) binarySearch(a, idx+1, right);
		else binarySearch(a, left, idx-1);
	}

}
