package 큐덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 참고 : http://melonicedlatte.com/algorithm/2018/02/18/230705.html
 */

public class BOJ_1966_S3_프린터큐 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			Queue<Pair> q = new LinkedList<>();
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				int priority = Integer.parseInt(st.nextToken());
				q.add(new Pair(i, priority));
				pq.add(priority);
			}
			
			int cnt = 0;
			while(!q.isEmpty()) {
				Pair p = q.poll();
				int idx = p.idx;
				int pri = p.priority;
				
				if(pq.peek() == pri) {
					pq.poll();
					++cnt;
					if(idx == M) {
						sb.append(cnt + "\n");
						break;
					}
				}
				else {
					q.offer(new Pair(idx, pri));
				}
			}
		}
		System.out.print(sb.toString());
	}
	
	static class Pair {
		int idx, priority;
		
		public Pair(int idx, int priority) {
			this.idx = idx;
			this.priority = priority;
		}
	}
}
