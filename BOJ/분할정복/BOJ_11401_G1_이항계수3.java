package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 페르마의 소정리를 이용한 풀이법 참고 : https://kyunstudio.tistory.com/60
 */

public class BOJ_11401_G1_이항계수3 {
	static final long P = 1000000007;
	static long fac[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		if(N == K || K == 0) {
			System.out.println(1);
			System.exit(0);
		}
		
		fac = new long[N+1];
		fac[1] = 1;
		for(int i = 2; i <= N; i++) {
			fac[i] = (fac[i-1] * i) % P;
		}
		// 페르마의 소정리에 의해 P가 소수이고, A의 배수가 아니라면 
		// A의 (P-2)승이 = A의 (-1)승이 된다
		long ans = (fac[N] * (power((fac[K] * fac[N-K]) % P, P-2) % P)) % P;
		System.out.println(ans);
	}

	private static long power(long n, long x) {
		if(x == 1) {
			return n;
		}
		long a = power(n, x/2);
		if(x % 2 == 0) {
			return (a * a) % P;
		}
		else {
			return ((a * a) % P * n) % P;
		}
	}
}
