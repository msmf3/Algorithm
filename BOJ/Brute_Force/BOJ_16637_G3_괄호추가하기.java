package Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16637_G3_괄호추가하기 {
	static int N;
	static String expr;
	static long ans;
	static int[] numArr;
	static char[] operArr;
	static boolean[] bracket;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		expr = br.readLine();
		if(N == 1) {
			System.out.println(Integer.parseInt(expr));
			return;
		}
		numArr  = new int[N/2 + 1];
		operArr = new char[N/2];
		for(int i = 0; i < expr.length(); i++) {
			char c = expr.charAt(i);
			if(i % 2 == 0) {	// 숫자
				numArr[i/2] = c - '0';
			}
			else {				// 수식
				operArr[i/2] = c;
			}
		}
		bracket = new boolean[N/2];
		ans = Integer.MIN_VALUE;
		dfs(0, numArr[0]);
		System.out.println(ans);
	}
	
	private static void dfs(int idx, int num) {
		if(idx >= N/2) {
			ans = Math.max(ans, num);
			return;
		}
		int interNum = 0;
		// 순서대로 연산
		interNum = cal(num, numArr[idx+1], operArr[idx]);
		dfs(idx+1, interNum);
		
		if(idx < N/2-1) {
			// 괄호연산 먼저 진행
			interNum = cal(numArr[idx+1], numArr[idx+2], operArr[idx+1]);
			interNum = cal(num, interNum, operArr[idx]);
			dfs(idx+2, interNum);
		}
	}
	
	private static int cal(int a, int b, char oper) {
		int num = 0;
		switch(oper) {
		case '+':
			num = a + b;
			break;
		case '-':
			num = a - b;
			break;
		case '*':
			num = a * b;
			break;
		}
		return num;
	}
}
