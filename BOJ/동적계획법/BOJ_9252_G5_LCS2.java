package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9252_G5_LCS2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();
		int len1 = str1.length(); int len2 = str2.length();
		LCS dp[][] = new LCS[len1+1][len2+1];
		for(int i = 0; i <= str1.length(); i++) {
			dp[i][0] = new LCS(0, "");
		}
		for(int i = 0; i <= str2.length(); i++) {
			dp[0][i] = new LCS(0, "");
		}
		for(int i = 0; i < str1.length(); i++) {
			for(int j = 0; j < str2.length(); j++) {
				if(str1.charAt(i) == str2.charAt(j)) {
					LCS prev = dp[i][j];
					dp[i+1][j+1] = new LCS(prev.len+1, prev.lcs + str2.charAt(j));
				}
				else {
					LCS prev = dp[i+1][j].len > dp[i][j+1].len ? dp[i+1][j] : dp[i][j+1]; 
					dp[i+1][j+1] = prev;
				}
			}
		}
		/*
		for(int i = 1; i <= len1; i++) {
			for(int j = 1; j <= len2; j++) {
				System.out.print(dp[i][j].len + " ");
			}
			System.out.println();
		}
		*/
		
		System.out.println(dp[len1][len2].len);
		System.out.println(dp[len1][len2].lcs);
	}
	
	static class LCS {
		int len;
		String lcs;
		
		public LCS(int len, String lcs) {
			this.len = len;
			this.lcs = lcs;
		}
	}

}
