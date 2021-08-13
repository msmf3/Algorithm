package 비트마스킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 참고 : https://degurii.tistory.com/158
 */

public class BOJ_9527_G2_1의개수세기 {
	static long d[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		d = new long[55];	// 10^16 ~= 2^55
		d[0] = 1;
		for(int i = 1; i < 55; i++) {
			d[i] = 2 * d[i-1] + ((long)1 << i); 
		}
		/*
		for(int i = A; i <= B; i++) {
			sum += countOneBit(i);
		}
		*/
		long a_acc = countOneBit(A-1);
		long b_acc = countOneBit(B);
		System.out.println(b_acc - a_acc);
	}
	
	private static long countOneBit(long num) {
		long cnt = num & 1;
		for(int i = 54; i > 0; i--) {
			long a = (long)1 << i;
			if((num & a) != 0) {
				// 2진수가 i번째 비트가 1인 미만의 2진수의 1의 개수 누적합 + i번째 비트의 개수 
				cnt += d[i-1] + (num - a + 1);
				num -= a;
			}
		}
		return cnt;
	}
	
	/*
	private static int countOneBit(int num) {
		int i;
		for(i = 0; num != 0; i++) {
			num &= (num-1);
		}
		return i;
	}
	*/

}
