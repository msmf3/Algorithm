package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 참고 : https://st-lab.tistory.com/141
 */

public class BOJ_12865_G5_평범한배낭 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Backpack backpacks[] = new Backpack[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			backpacks[i] = new Backpack(w, v);
		}
		
		// Bottom-Up DP
		/*
		int dp[][] = new int[N+1][K+1];
		
		for(int i = 1; i <= N; i++) {
			Backpack bp = backpacks[i-1];
			for(int j = 1; j <= K; j++) {
				// 백팩이 최대 무게를 초과하지 않는 경우
				if(bp.weight <= j) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-bp.weight] + bp.value);
				}
				else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		*/
		
		// 중복제거 Bottom-Up DP
		int dp[] = new int[K+1];
		for(int i = 1; i <= N; i++) {
			Backpack bp = backpacks[i-1];
			for(int j = K; j > 0; j--) {
				// 무게가 최대무게보다 큰 경우 더 이상 탐색할 필요가 없음
				if(j - bp.weight < 0) {
					break;
				}
				dp[j] = Math.max(dp[j], dp[j - bp.weight] + bp.value);
			}
		}
		
		System.out.println(dp[K]);
	}
	
	static class Backpack {
		int weight, value;
		
		public Backpack(int weight, int value) {
			this.weight = weight;
			this.value = value;
		}
	}

}
