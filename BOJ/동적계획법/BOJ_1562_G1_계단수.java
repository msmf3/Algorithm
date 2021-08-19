package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 참고 : https://loosie.tistory.com/171
 */

public class BOJ_1562_G1_계단수 {
	static int N, allVisit;
	static long dp[][][];
	static long div = 1_000_000_000;	// 10억

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		allVisit = (1 << 10) - 1;
		// dp[i][j][k] = i자리 숫자, j로 끝나는, k(bit masking, visit)의 개수
		dp = new long[N+1][10][1<<10];
		for(int i = 1; i < 10; i++) {
			dp[1][i][(1<<i)] = 1;
		}
		// k : 0 ~ 1023(1<<10) 까지 모두 체크
		// k가 over 되는 경우(= 1자리 숫자인데, k=1023)도 있지만 어차피 Big O 가 그렇게 커지지 않기 때문에 모두 체크
		for(int i = 2; i <= N; i++) {
			for(int j = 0; j < 10; j++) {
				for(int k = 0; k < (1 << 10); k++) {
					int bit = k | (1 << j);
					if(j == 0) {
						dp[i][j][bit] += dp[i-1][1][k] % div;
					}
					else if(j == 9) {
						dp[i][j][bit] += dp[i-1][8][k] % div;
					}
					else {
						dp[i][j][bit] += (dp[i-1][j-1][k] + dp[i-1][j+1][k]) % div;
					}
				}
			}
		}
		long ans = 0;
		for(int i = 0; i < 10; i++) {
			// i 자리로 끝나고 모두 방문한 경우의 수를 더해줌
			ans += dp[N][i][allVisit];
			ans %= div;
//			System.out.println("i : " + i + " ans : " + ans);
		}
		System.out.println(ans);
	}
}
