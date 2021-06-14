package 스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1874_S3_스택수열 {
	static int arr[];
	static int N;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		if(isPossible()) {
			System.out.println(sb.toString());
		}
		else {
			System.out.println("NO");
		}
	}
	
	private static boolean isPossible() {
		Stack<Integer> stack = new Stack<>();
		int num = 0; int idx = 0;
		while(idx < N) {
			if(!stack.isEmpty() && stack.peek() == arr[idx]) {
				stack.pop();
				sb.append("-\n");
				++idx;
			}
			else {
				stack.add(++num);
				sb.append("+\n");
				if(num > N) {
					return false;
				}
			}
		}
		return true;
	}

}
