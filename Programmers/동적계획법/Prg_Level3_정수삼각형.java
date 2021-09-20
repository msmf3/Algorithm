package 동적계획법;

public class Prg_Level3_정수삼각형 {

	public static void main(String[] args) {
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};	
		System.out.println(solution(triangle));
	}
	
	public static int solution(int[][] triangle) {
        int answer = 0;
        int n = triangle.length;
        int[][] dp = new int[n][n];
        dp[0][0] = triangle[0][0];
        for(int i = 1; i < n; i++) {
        	dp[i][0] = triangle[i][0] + dp[i-1][0];
        	for(int j = 1; j < i; j++) {
        		int left = dp[i-1][j-1];
        		int right = dp[i-1][j];
        		dp[i][j] = Math.max(triangle[i][j]+left, triangle[i][j]+right);
        	}
        	dp[i][i] = triangle[i][i] + dp[i-1][i-1]; 
        }
        
        for(int i = 0; i < n; i++) {
        	answer = Math.max(answer, dp[n-1][i]);
        }
        
        return answer;
    }
}
