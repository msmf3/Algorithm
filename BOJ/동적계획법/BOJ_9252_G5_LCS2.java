package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9252_G5_LCS2 {
	static int dp[][];
	static String str1, str2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str1 = br.readLine();
		str2 = br.readLine();
		int len1 = str1.length(); int len2 = str2.length();
		dp = new int[len1+1][len2+1];
		// --- 입력 End ---
		
		for(int i = 0; i < str1.length(); i++) {
			for(int j = 0; j < str2.length(); j++) {
				if(str1.charAt(i) == str2.charAt(j)) {
					// 글자가 같다면 len 및 문자열 저장
					dp[i+1][j+1] = dp[i][j] + 1;
				}
				else {
					dp[i+1][j+1] = dp[i+1][j] > dp[i][j+1] ? dp[i+1][j] : dp[i][j+1]; 
				}
			}
		}
		System.out.println(dp[len1][len2]);
		
		System.out.println(findLCS(len1, len2));
	}
	
	private static String findLCS(int r, int c) {
		String ansStr = "";
		Stack<Character> stack = new Stack<>();
		
		while(r > 0 && c > 0) {
			if(dp[r][c] == dp[r-1][c]) {
				--r;
			}
			else if(dp[r][c] == dp[r][c-1]) {
				--c;
			}
			else {
				stack.add(str1.charAt(r-1));
				--r;
				--c;
			}
		}
		
		while(!stack.isEmpty()) {
			ansStr += stack.pop();
		}
		return ansStr;
	}

}
