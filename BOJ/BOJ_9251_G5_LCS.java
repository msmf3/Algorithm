import java.util.Scanner;

public class BOJ_9251_G5_LCS {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		int len1 = str1.length();
		int len2 = str2.length();
		int dp[][] = new int[len2+1][len1+1];
		char c = str2.charAt(0);
		for(int i = 1; i <= len2; i++) {
			c = str2.charAt(i-1);
			for(int j = 1; j <= len1; j++) {
				if(str1.charAt(j-1) == c) {
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		System.out.println(dp[len2][len1]);
		sc.close();
	}

}
