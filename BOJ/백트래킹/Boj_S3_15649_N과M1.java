package 백트래킹;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Boj_S3_15649_N과M1 {
	static int N, M;
	static List<Integer> arr;
	static boolean visited[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new LinkedList<>();
		visited = new boolean[N];
		
		go(0);
		
		sc.close();
	}
	
	private static void go(int cnt) {
		if(cnt == M) {
			for(int i = 0; i < M; i++) {
				System.out.print(arr.get(i) + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			if(visited[i-1]) continue;
			
			arr.add(i);
			visited[i-1] = true;
			go(cnt+1);
			
			arr.remove(arr.size()-1);
			visited[i-1] = false;
		}
	}

}
