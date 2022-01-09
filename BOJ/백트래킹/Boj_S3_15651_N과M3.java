package 백트래킹;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Boj_S3_15651_N과M3 {
	static int N, M;
	static int arr[];
	static BufferedWriter bw;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[M];
		
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		go(0, 1);
		
		bw.flush();
		bw.close();
		
		sc.close();
	}
	
	private static void go(int cnt, int cur) throws IOException {
		if(cnt == M) {
			for(int i = 0; i < M; i++) {
				bw.write(arr[i] + " ");
			}
			bw.write("\n");
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			arr[cnt] = i;
			go(cnt+1, i);
		}
	}

}
