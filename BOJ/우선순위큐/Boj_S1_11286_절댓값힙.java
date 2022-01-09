package 우선순위큐;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Boj_S1_11286_절댓값힙 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Queue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if(Math.abs(o1) < Math.abs(o2)) {
					return -1;
				} else if(Math.abs(o1) == Math.abs(o2)) {
					return o1 - o2;
				} else {
					return 1;
				}
			}
		});
		for(int i = 0; i < N; i++) {
			int x = sc.nextInt();
			if(x == 0) {
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
