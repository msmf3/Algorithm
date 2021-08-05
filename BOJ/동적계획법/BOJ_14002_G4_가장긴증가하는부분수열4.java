package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 참고 : https://dragon-h.tistory.com/34?category=789780
 */

public class BOJ_14002_G4_가장긴증가하는부분수열4 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		int dp[] = new int[N];
		int maxLength = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
			for(int j = 0; j < i; j++) {
				if(arr[j] < arr[i]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
			maxLength = Math.max(maxLength, dp[i]);
		}
		sb.append(maxLength + "\n");
		Stack<Integer> stack = new Stack<>();
		int idx = N-1;
		while(maxLength > 0 && idx >= 0) {
			if(dp[idx] == maxLength) {
				--maxLength;
				stack.add(arr[idx]);
			}
			--idx;
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop() + " ");
		}
		System.out.print(sb.toString());
	}

}
