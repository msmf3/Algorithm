package 동적계획법;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * 참고 : https://sphong0417.tistory.com/50
 */

public class BOJ_2629_G2_양팔저울 {
	static int N, sum;
	static int weights[];
	static boolean dp[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		weights = new int[N+1];
		sum = 0;
		for(int i = 1; i <= N; i++) {
			weights[i] = Integer.parseInt(st.nextToken());
			sum += weights[i];
		}
		dp = new boolean[N+1][sum+1];
		fillDP();
		for(int i = 1; i <= sum; i++) {
			bw.write(dp[N][i] + " ");
		}
		
		int K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < K; i++) {
			int w = Integer.parseInt(st.nextToken());
			if(w > sum) {
				bw.write("N ");
				continue;
			}
			bw.write(dp[N][w] ? "Y " : "N ");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void fillDP() {
		int acc = weights[1];
		dp[1][weights[1]] = true;
		for(int i = 2; i <= N; i++) {
			int w = weights[i];
			acc += weights[i];
			// 현재 무게만 넣었을 때. 누적 무게 제외
			dp[i][w] = true;
			for(int j = 1; j + w <= acc; j++) {
				if(!dp[i-1][j]) continue;
				// 현재 무게를 안더한 경우. 누적 무게만
				dp[i][j] = true;
				// 현재 무게를 더한 경우
				dp[i][j+w] = true;
				// 누적 무게, 현재 무게 중에 가벼운 쪽에 추를 둬서 무게를 재는 경우
				// ex) 3, 7 이면 4를 3쪽에 둬서 무게를 잴 수 있음
				dp[i][Math.abs(j-w)] = true;
			}
		}
	}
}
