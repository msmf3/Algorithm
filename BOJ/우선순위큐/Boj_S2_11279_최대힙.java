package 우선순위큐;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Boj_S2_11279_최대힙 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Queue<Integer> q = new PriorityQueue<>();
		for(int i = 0; i < N; i++) {
			int x = sc.nextInt();
			if(x == 0) {
				if(q.isEmpty()) {
					System.out.println(0);
				} else {
					System.out.println(q.poll() * -1);
				}
			} else {
				q.add(x * -1);
			}
		}
		
		sc.close();
	}

}
