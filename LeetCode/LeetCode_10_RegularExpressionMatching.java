
public class LeetCode_10_RegularExpressionMatching {

	public static void main(String[] args) {
		System.out.println(isMatch("aa", "a*"));
	}
	
	public static boolean isMatch(String s, String p) {
		int n = s.length(); int m = p.length();
		boolean dp[][] = new boolean[n+1][m+1];
		dp[n][m] = true;
		// 문자열 / 패턴
		//   m i s * i
		// m T F F F F F
		// i F T F F F F
		// s F F T F F F
		// s F F T F F F
		// i F F F F T F
		//   F F F F F T
		
		// i = n 부터 인 이유 "aa" "a*" 인 예를 처리
		//   a *
		// a T F F
		// a T F F
		//   T F T
		for(int i = n; i >= 0; i--) {
			for(int j = m-1; j >= 0; j--) {
				boolean match = (i < n && 
								(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));
				if(j + 1 < m && p.charAt(j+1) == '*') {
					// * 조건
					// dp[i][j+2] = 0번 반복, dp[i+1][j] = x번 반복 체크
					dp[i][j] = dp[i][j+2] || match && dp[i+1][j];
				}
				else {
					dp[i][j] = match && dp[i+1][j+1];
				}
			}
		}
		
		for(int i = 0; i <= n; i++) {
			for(int j = 0; j <= m; j++) {
				System.out.print((dp[i][j] ? 1 : 0) + " ");
			}
			System.out.println();
		}
        return dp[0][0];
    }
}
