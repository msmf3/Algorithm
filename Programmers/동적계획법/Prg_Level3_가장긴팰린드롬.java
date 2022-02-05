package 동적계획법;

// 참고 : https://velog.io/@sa833591/%EA%B0%80%EC%9E%A5-%EA%B8%B4-%ED%8C%B0%EB%A6%B0%EB%93%9C%EB%A1%AC-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-Lv.3

public class Prg_Level3_가장긴팰린드롬 {
	
	public static void main(String[] args) {
		String s = "abacde";
		System.out.println(solution(s));
	}
	
	public static int solution(String s)
    {
		int answer = 1;
        int N = s.length();
        boolean[][] dp = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			dp[i][i] = true;
		}
		for(int i = 0; i < N-1; i++) {
			if(s.charAt(i) == s.charAt(i+1)) {
				dp[i][i+1] = true;
				answer = 2;
			}
		}
		
		for(int len = 3; len <= N; len++) {
			for(int start = 0; start <= N-len; start++) {
				int end = start + len - 1;
				if(s.charAt(start) == s.charAt(end)) {
					if(dp[start+1][end-1]) {
						answer = len;
						dp[start][end] = true;
					}
				}
			}
		}
        return answer;
    }

}
