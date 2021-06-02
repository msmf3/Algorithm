package 백트래킹;

import java.util.Scanner;

public class BOJ_15652_S3_N과M4 {
	static int arr[];
	static int N, M;
	static StringBuilder S = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[M];
		Combination(0, 1);
		System.out.print(S);
		sc.close();
	}

	private static void Combination(int cnt, int cur) {
		if(cnt == M) {
			for(int i = 0; i < M; i++) {
				S.append(arr[i]).append(" ");
			}
			S.append("\n");
			return;
		}
		
		for(int i = cur; i <= N; i++) {
			arr[cnt] = i;
			Combination(cnt+1, i);
		}
	}
	
	
}
