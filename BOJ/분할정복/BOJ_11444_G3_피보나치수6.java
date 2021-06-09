package 분할정복;

import java.util.Scanner;

public class BOJ_11444_G3_피보나치수6 {
	static final long d = 1000000007;
	static long identity[][];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		if(N == 1) {
			System.out.println(1);
			System.exit(0);
		}
		identity = new long[2][2];
		identity[0][0] = identity[0][1] = identity[1][0] = 1;
		identity[1][1] = 0;
		System.out.println(fibonacci(N-1)[0][0]);
		sc.close();
	}
	
	// 행렬곱을 이용
	/*
	 * identity matrix : [ 1 1 
	 *                     1 0 ]
	 * [ Fn+1 Fn 									[ Fn+1 + Fn  Fn+1
	 *   Fn   Fn-1 ] 에서 identity matrix를 행렬곱하면          Fn+1       Fn   ] 자연스럽게 다음 Fn+2 (Fn+1 + Fn)를 구할 수 있음
	 * 이러한 성질을 이용하여 분할정복으로 O(log n) 의 시간복잡도로 풀 수 있음
	 */
	private static long[][] fibonacci(long n) {
		if(n == 1) {
			return identity;
		}
		long A[][] = fibonacci(n/2);
		if(n % 2 == 0) {
			return product(A, A);
		}
		else {
			return product(A, product(A, identity));
		}
	}
	
	private static long[][] product(long A[][], long B[][]) {
		long C[][] = new long[2][2];
		C[0][0] = ((A[0][0] * B[0][0]) % d + (A[0][1] * B[1][0]) % d) % d;
		C[0][1] = ((A[0][0] * B[0][1]) % d + (A[0][1] * B[1][1]) % d) % d;
		C[1][0] = ((A[1][0] * B[0][0]) % d + (A[1][1] * B[1][0]) % d) % d;
		C[1][1] = ((A[1][0] * B[0][1]) % d + (A[1][1] * B[1][1]) % d) % d;
		
		return C;
	}
	
	// 시간초과 코드, (공식을 이용)
//	private static long fibonacci(long n) {
//		if(n == 0) {
//			return 0;
//		}
//		if(n == 1) {
//			return 1;
//		}
//		if(n == 2) {
//			return 1;
//		}
//		long num = fibonacci(n/2);
//		
//		if(n % 2 == 1) {
//			long num2 = fibonacci(n/2+1);
//			return ((num * num) % d + (num2 * num2) % d) % d;
//		}
//		else {
//			long num0 = fibonacci(n/2-1);
//			return (((num0 * num) % d * 2) % d + (num * num) % d) % d;
//		}
//	}

}
