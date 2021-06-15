package 스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 스택을 이용한 풀이법 참고 : https://st-lab.tistory.com/196
 */

public class BOJ_17298_G4_오큰수 {
	static int N;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Stack<Integer> stack = new Stack<>();
		stack.push(0);	// index0 push
		for(int i = 1; i < N; i++) {
			if(arr[i] <= arr[stack.peek()]) {
				stack.push(i);
			}
			else {	// arr[i] > arr[stack.peek()]
				while(!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
					arr[stack.pop()] = arr[i];
				}
				stack.push(i);
			}
		}
		while(!stack.isEmpty()) {
			arr[stack.pop()] = -1;
		}
		
		for(int i = 0; i < N; i++) {
			sb.append(arr[i] + " ");
		}
		System.out.print(sb.toString());
	}

}
