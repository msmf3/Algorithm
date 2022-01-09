package 백트래킹;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Boj_S3_15650_N과M2 {
	static int N, M;
	static List<Integer> arr;
	static boolean visited[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new LinkedList<>();
		visited = new boolean[N+1];
		
		go(0, 1);
		
		sc.close();
	}
	
	private static void go(int cnt, int cur) {
		if(cnt == M) {
			for(int i = 0; i < M; i++) {
				System.out.print(arr.get(i) + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = cur; i <= N; i++) {
			if(visited[i-1]) continue;
			
			arr.add(i);
			visited[i-1] = true;
			go(cnt+1, i+1);
			
			arr.remove(arr.size()-1);
			visited[i-1] = false;
		}
	}

}
