package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2116_G5_주사위쌓기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		// 주사위 입력
		int[][] dice = new int[10001][6];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 6; j++) {
				dice[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 주사위 반대편
		int[] across = new int[6];
		across[0] = 5;
		across[1] = 3;
		across[2] = 4;
		across[3] = 1;
		across[4] = 2;
		across[5] = 0;
		
		int ans = 0;
		// 첫번째 주사위만 조정하고 나머지는 윗면 숫자에 맞게 쌓아올려짐 
		// 옆면은 그냥 돌릴 수 있으므로 최대값을 가져오면 됨
		for(int i = 0; i < 6; i++) {
			int top = dice[0][i];
			
			int tmp_ans = 0, tmp_max = 0;
			
			// 첫번째 주사위 최대값
			for(int j = 1; j <= 6; j++) {
				if(j != top && j != dice[0][across[i]]) {
					tmp_max = Math.max(j, tmp_max);
				}
			}
			
			tmp_ans += tmp_max;
			// 두번째 ~ N 번째는 첫번째 주사위의 top을 따라감
			for(int j = 1; j < N; j++) {
				tmp_max = 0;
				int k = 0;
				for(; k < 6; k++) {
					if(dice[j][k] == top) break;
				}
				
				// 현재 주사위의 top, bottom 알아내기
				int prev_top = top;
				top = dice[j][across[k]];
				int bottom = prev_top;
				
				for(; k < 6; k++) {
					if(dice[j][k] != top && dice[j][k] != bottom) tmp_max = Math.max(tmp_max, dice[j][k]);
				}
				
				tmp_ans += tmp_max;
			}
			ans = Math.max(ans, tmp_ans);
		}
		System.out.println(ans);
	}

}
