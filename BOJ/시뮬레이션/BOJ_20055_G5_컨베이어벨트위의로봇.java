package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20055_G5_컨베이어벨트위의로봇 {
	static int N, K, ans;
	static int beltSize, zeroCnt;
	static int beltDur[];
	static boolean robot[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		beltSize = 2*N;
		beltDur = new int[beltSize+1];
		robot = new boolean[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= 2*N; i++) {
			beltDur[i] = Integer.parseInt(st.nextToken());
		}
		
		ans = 0;
		while(true) {
			++ans;
			// 1. 벨트 회전
			int tmp = beltDur[2*N];
			for(int i = beltSize; i > 1; i--) {
				beltDur[i] = beltDur[i-1];
			}
			beltDur[1] = tmp;
			// 로봇도 같이 회전
			for(int i = N; i >= 1; i--) {
				robot[i] = robot[i-1];
			}
			// 로봇 내리기
			if(robot[N]) robot[N] = false;
			
			// 2.로봇 이동
			for(int i = N; i >= 1; i--) {
				if(robot[i-1] && !robot[i] && beltDur[i] > 0) {
					robot[i] = robot[i-1];
					robot[i-1] = false;
					if(--beltDur[i] == 0) {
						++zeroCnt;
					}
				}
			}
			// 로봇 내리기
			if(robot[N]) robot[N] = false;
			
			// 3.로봇 올리기
			if(beltDur[1] > 0) { // 올리는 곳의 내구도 확인
				robot[1] = true;
				if(--beltDur[1] == 0) {
					++zeroCnt;
				}
			}
			
			// 4.내구도0인 칸 확인
			if(zeroCnt >= K) {
				break;
			}
		}
		System.out.println(ans);
	}

}
