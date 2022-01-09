package 우선순위큐;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * N < 100,000(십만)
 * BufferedReader, BufferedWriter를 사용해서 시간제한을 통과한 문제
 */

public class Boj_G2_1655_가운데를말해요 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> min_heap = new PriorityQueue<>();
		Queue<Integer> max_heap = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
		int x = Integer.parseInt(br.readLine());
		max_heap.add(x);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(x + "\n");
		for(int i = 0; i < N-1; i++) {
			x = Integer.parseInt(br.readLine());
			if(i % 2 == 0) {	// 짝수번째 일 때
				min_heap.add(x);
			} else {
				max_heap.add(x);
			}
			if(max_heap.peek() > min_heap.peek()) { 
				// max_heap의 peek 값이 min_heap의 peek 값보다 높은 경우
				// 중앙값을 다시 min_heap의 peek에 둬야 하므로 swap
				max_heap.add(min_heap.poll());
				min_heap.add(max_heap.poll());
			}
			bw.write(max_heap.peek() + "\n");
		}
		bw.flush();
		bw.close();
	}

}
