package 우선순위큐;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Boj_S1_1927_최소힙 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Queue<Integer> pq = new PriorityQueue<>();
		for(int i = 0; i < N; i++) {
			int x = sc.nextInt();
			if(x == 0) {	// 큐에서 빼낸 후 출력
				if(pq.isEmpty()) {
					System.out.println(0);
				} else {
					System.out.println(pq.poll());
				}
			} else {
				pq.add(x);
			}
		}
		
		sc.close();
	}

}
