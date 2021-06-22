package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 참고 : https://devowen.com/265
 */

public class BOJ_1300_G3_K번째수 {
	static int N;
	static long K, ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Long.parseLong(br.readLine());
		
		binarySearch(0, K);
		System.out.println(ans);
	}

	private static void binarySearch(long left, long right) {
		long mid = (left+right) / 2;
		if(left > right) return;
		
		int cnt = 0;
		for(int i = 1; i <= N; i++) {
			// 해당 행에서 mid보다 작거나 같은 수의 개수를 더해줌
			cnt += Math.min(mid / i, N);
		}
		
		// mid 값보다 작거나 같은 수(cnt)가 K값보다 큰 수 중 최소값을 구해야 함
		// K값과 cnt를 비교하면서 이분탐색
		// (K <= cnt) 는 left 와 mid 사이에 K번째 수가 있음
		// ans = mid 의 값으로 갱신하고 마지막엔 최소값이 갱신된다.
		if(K <= cnt) {
			ans = mid;
			binarySearch(left, mid-1);
		}
		else {
			binarySearch(mid+1, right);
		}
	}

}
