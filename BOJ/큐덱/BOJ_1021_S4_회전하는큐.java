package 큐덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * 참고 : https://st-lab.tistory.com/216
 */

public class BOJ_1021_S4_회전하는큐 {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		LinkedList<Integer> deque = new LinkedList<>();
		for(int i = 1; i <= N; i++) {
			deque.add(i);
		}
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int ans = 0;
		for(int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			int target_idx = deque.indexOf(num);
			int size = deque.size();
			int half_size = size / 2;
			if(size % 2 == 0) {
				--half_size;
			}
			
			if(target_idx <= half_size) {
				for(int j = 0; j < target_idx; j++) {
					deque.offerLast(deque.pollFirst());
					++ans;
				}
			}
			else {
				for(int j = 0; j < size - target_idx; j++) {
					deque.offerFirst(deque.pollLast());
					++ans;
				}
			}
			deque.poll();
		}
		System.out.print(ans);
	}

}
