package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * K개를 넘지 않는 비어있지 않은 물병
 */

public class BOJ_1052_S1_물병 {
	static int N, K;
	static final int max_value = 10_000_000;
	// 물병은 1L 부터 시작 합치면 2의 제곱수로 증가한다. ex) 1,2,4,8,16,...
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		// Brute Force 
		// N부터 10^7(대략 1천만) 까지 
		// 1~K 까지의 경우 X -> K만 보면 될듯 어떤 결과값이 K보다 작으면 될듯?
		// N % 2의 제곱수  
		
		// 수학적으로 접근 가능할 듯
		// K의 값이 클수록 정답의 값이 줄어듦
		// 13, 1~6 까지는 답이 3   13, 7~12이면 답은 1  14 % 7 = 0		13, 13~ 답은 0
		//		
		
		// K=1일 때, N의 값에 따른 최소 추가 개수
		// 1 -> 0
		// 2 -> 0
		// 3 -> 1
		// 4 -> 0
		// 5 -> 3
		// 6 -> 2
		// 7 -> 1
		// 8 -> 0
		// 점화식 : (N보다 큰 2의 제곱수) - N
		
		// K=2일 때, N의 값에 따른 최소 추가 개수
		// 1 -> 0
		// 2 -> 0
		// 3 -> 0
		// 4 -> 0
		// 5 -> 0 (4,1)
		// 6 -> 0 (4,2)
		// 7 -> 1 (4,2,1) -> 8 : (4,4)
		// 8 -> 0
		// 9 -> 0 (8,1)
		// 10 -> 0 (8,2)
		// 11 -> 1 (8,2,1) -> 12 : (
		
		// 최종 점화식 : 2진수로 만들었을 때 1의 개수 <= K
		
		// 정답이 없는 경우에 -1을 출력.
		int ans = -1;
		
		// 시간복잡도 = A( < 10_000_000) * B ( < log2(C < 20_000_000)) 맞나?
		for(int i = N; ; i++) {
			// N을 2진수로 변환했을 때 1의 개수
			if(isPossibleAnswer(i)) {
				ans = i - N;
				break;
			}
		}
		
		System.out.println(ans);
	}
	
	private static boolean isPossibleAnswer(int num) {
		int cnt = 0;
		// N을 2진수로 변환했을 때 1의 개수가 K를 넘으면 정답이 될 수 없음
		while(num > 0) {
			if(num % 2 == 1) {
				if(++cnt > K) {
					return false;
				}
			}
			num /= 2;
		}
		return true;
	}
}
